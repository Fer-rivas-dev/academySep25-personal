package com.curso.javatechie;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demonstrates three correct ways to alternate odd/even printing using CompletableFuture.
 */
public final class EvenAndOddPrinterFixed {

    private static final int MAX_NUMBER = 10;
    private static final Executor EXECUTOR = ForkJoinPool.commonPool();

    private EvenAndOddPrinterFixed() {
    }

    public static void main(String[] args) {
        System.out.println("Wait/Notify Strategy");
        runWithWaitNotify(MAX_NUMBER);
        System.out.println();

        System.out.println("Semaphore Strategy");
        runWithSemaphores(MAX_NUMBER);
        System.out.println();

        System.out.println("Phaser Strategy");
        runWithPhaser(MAX_NUMBER);
        System.out.println();
    }

    public static void runWithWaitNotify(int maxNumber) {
        final Object monitor = new Object();
        final MutableInt counter = new MutableInt(1);
        final CountDownLatch startLatch = new CountDownLatch(2);

        CompletableFuture<Void> oddFuture = CompletableFuture.runAsync(
                () -> waitNotifyWorker(true, maxNumber, monitor, counter, startLatch), EXECUTOR);
        CompletableFuture<Void> evenFuture = CompletableFuture.runAsync(
                () -> waitNotifyWorker(false, maxNumber, monitor, counter, startLatch), EXECUTOR);

        CompletableFuture.allOf(oddFuture, evenFuture).join();
        System.out.println("✔ Wait/Notify completed\n");
    }

    private static void waitNotifyWorker(boolean isOddPrinter, int maxNumber, Object monitor,
                                          MutableInt counter, CountDownLatch startLatch) {
        String label = isOddPrinter ? "ODD" : "EVEN";
        try {
            startLatch.countDown();
            startLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        while (true) {
            synchronized (monitor) {
                try {
                    while (counter.value <= maxNumber && isOddPrinter != isOdd(counter.value)) {
                        monitor.wait();
                    }
                    if (counter.value > maxNumber) {
                        monitor.notifyAll();
                        return;
                    }

                    System.out.println("Thread " + label + " [" + Thread.currentThread().getName() + "]: " + counter.value);
                    counter.value++;
                    monitor.notifyAll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    monitor.notifyAll();
                    return;
                }
            }
        }
    }

    public static void runWithSemaphores(int maxNumber) {
        final AtomicInteger counter = new AtomicInteger(1);
        final Semaphore oddPermit = new Semaphore(1);
        final Semaphore evenPermit = new Semaphore(0);

        CompletableFuture<Void> oddFuture = CompletableFuture.runAsync(
                () -> semaphoreWorker(true, maxNumber, counter, oddPermit, evenPermit), EXECUTOR);
        CompletableFuture<Void> evenFuture = CompletableFuture.runAsync(
                () -> semaphoreWorker(false, maxNumber, counter, evenPermit, oddPermit), EXECUTOR);

        CompletableFuture.allOf(oddFuture, evenFuture).join();
        System.out.println("✔ Semaphore completed\n");
    }

    private static void semaphoreWorker(boolean isOddPrinter, int maxNumber, AtomicInteger counter,
                                         Semaphore selfPermit, Semaphore otherPermit) {
        String label = isOddPrinter ? "ODD" : "EVEN";
        try {
            while (true) {
                selfPermit.acquire();
                int current = counter.get();
                if (current > maxNumber) {
                    otherPermit.release();
                    return;
                }

                System.out.println("Thread " + label + " [" + Thread.currentThread().getName() + "]: " + current);
                counter.incrementAndGet();
                otherPermit.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            otherPermit.release();
        }
    }

    public static void runWithPhaser(int maxNumber) {
        final MutableInt counter = new MutableInt(1);
        final Object counterLock = new Object();
        final java.util.concurrent.Phaser phaser = new java.util.concurrent.Phaser(2);

        CompletableFuture<Void> oddFuture = CompletableFuture.runAsync(
                () -> phaserWorker(true, maxNumber, counter, counterLock, phaser), EXECUTOR);
        CompletableFuture<Void> evenFuture = CompletableFuture.runAsync(
                () -> phaserWorker(false, maxNumber, counter, counterLock, phaser), EXECUTOR);

        CompletableFuture.allOf(oddFuture, evenFuture).join();
        System.out.println("✔ Phaser completed\n");
    }

    private static void phaserWorker(boolean isOddPrinter, int maxNumber, MutableInt counter,
                                      Object counterLock, java.util.concurrent.Phaser phaser) {
        String label = isOddPrinter ? "ODD" : "EVEN";
        boolean deregistered = false;
        try {
            while (true) {
                boolean finished;
                synchronized (counterLock) {
                    if (counter.value > maxNumber) {
                        finished = true;
                    } else if (isOddPrinter == isOdd(counter.value)) {
                        System.out.println("Thread " + label + " [" + Thread.currentThread().getName() + "]: " + counter.value);
                        counter.value++;
                        finished = counter.value > maxNumber;
                    } else {
                        finished = false;
                    }
                }

                if (finished) {
                    phaser.arriveAndDeregister();
                    deregistered = true;
                    return;
                }

                phaser.arriveAndAwaitAdvance();
            }
        } finally {
            if (!deregistered) {
                phaser.arriveAndDeregister();
            }
        }
    }

    private static boolean isOdd(int value) {
        return (value & 1) == 1;
    }

    private static final class MutableInt {
        private int value;

        private MutableInt(int initialValue) {
            this.value = initialValue;
        }
    }
}
