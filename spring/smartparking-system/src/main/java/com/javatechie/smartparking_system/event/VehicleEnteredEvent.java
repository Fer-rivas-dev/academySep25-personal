package com.javatechie.smartparking_system.event;

import java.time.LocalDateTime;
import java.util.Objects;

public final class VehicleEnteredEvent {
    private final String vehicleNumber;
    private final LocalDateTime entryTime;

    public VehicleEnteredEvent(String vehicleNumber, LocalDateTime entryTime) {
        this.vehicleNumber = vehicleNumber;
        this.entryTime = entryTime;
    }

    public String vehicleNumber() {
        return vehicleNumber;
    }

    public LocalDateTime entryTime() {
        return entryTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleEnteredEvent)) return false;
        VehicleEnteredEvent that = (VehicleEnteredEvent) o;
        return Objects.equals(vehicleNumber, that.vehicleNumber) &&
               Objects.equals(entryTime, that.entryTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleNumber, entryTime);
    }

    @Override
    public String toString() {
        return "VehicleEnteredEvent{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", entryTime=" + entryTime +
                '}';
    }
}
