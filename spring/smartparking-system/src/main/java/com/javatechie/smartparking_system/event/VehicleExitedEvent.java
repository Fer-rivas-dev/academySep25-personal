package com.javatechie.smartparking_system.event;

import java.time.LocalDateTime;
import java.util.Objects;

public final class VehicleExitedEvent {
    private final String vehicleNumber;
    private final LocalDateTime entryTime;
    private final LocalDateTime exitTime;

    public VehicleExitedEvent(String vehicleNumber, LocalDateTime entryTime, LocalDateTime exitTime) {
        this.vehicleNumber = vehicleNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public String vehicleNumber() {
        return vehicleNumber;
    }

    public LocalDateTime entryTime() {
        return entryTime;
    }

    public LocalDateTime exitTime() {
        return exitTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleExitedEvent)) return false;
        VehicleExitedEvent that = (VehicleExitedEvent) o;
        return Objects.equals(vehicleNumber, that.vehicleNumber) &&
               Objects.equals(entryTime, that.entryTime) &&
               Objects.equals(exitTime, that.exitTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleNumber, entryTime, exitTime);
    }

    @Override
    public String toString() {
        return "VehicleExitedEvent{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                '}';
    }
}
