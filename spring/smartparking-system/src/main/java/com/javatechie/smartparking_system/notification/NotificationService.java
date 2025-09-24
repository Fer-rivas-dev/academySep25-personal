package com.javatechie.smartparking_system.notification;

import com.javatechie.smartparking_system.event.VehicleEnteredEvent;
import com.javatechie.smartparking_system.event.VehicleExitedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @EventListener
    public void notifyOnVehicleEntry(VehicleEnteredEvent event) {
        // Logic to send notification to the user
        System.out.println("📩 Notification: Vehicle " + event.vehicleNumber() +
                " entered at " + event.entryTime() + ". Welcome!");
    }

    @EventListener
    public void notifyOnVehicleExit(VehicleExitedEvent event) {
        // Logic to send notification to the user
        System.out.println("📩 Notification: Vehicle " + event.vehicleNumber() + " has exited. Thank you for visiting!");
    }
}
