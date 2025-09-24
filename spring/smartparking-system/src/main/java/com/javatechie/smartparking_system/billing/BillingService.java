package com.javatechie.smartparking_system.billing;

import com.javatechie.smartparking_system.event.VehicleExitedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class BillingService {


    private final BillingRecordRepository billingRecordRepository;

    public BillingService(BillingRecordRepository billingRecordRepository) {
        this.billingRecordRepository = billingRecordRepository;
    }

    @EventListener
    public void handleVehicleExit(VehicleExitedEvent event) {
    	
        Duration duration = Duration.between(event.entryTime(), event.exitTime());
        double amount = Math.max(20, (duration.toMinutes() / 60.0) * 50); // ₹50/hour

        BillingRecord record = new BillingRecord(null, event.vehicleNumber(), amount, event.exitTime());
        billingRecordRepository.save(record);

        System.out.println("✅ Billed $" + amount + " for vehicle " + event.vehicleNumber() +
                " from " + event.entryTime() + " to " + event.exitTime());
    }


}
