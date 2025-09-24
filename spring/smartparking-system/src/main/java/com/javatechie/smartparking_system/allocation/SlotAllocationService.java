package com.javatechie.smartparking_system.allocation;

import com.javatechie.smartparking_system.event.VehicleEnteredEvent;
//import com.javatechie.smartparking_system.event.VehicleExitedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class SlotAllocationService {

    private final SlotRepository slotRepository;

    public SlotAllocationService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }


    @EventListener
    public void handleVehicleEntry(VehicleEnteredEvent event) {

        Slot slot = slotRepository.findFirstByAvailableTrue()
                .orElseThrow(() -> new RuntimeException("🚫 No available slots!"));
        slot.setAvailable(false);
        slot.setVehicleNumber(event.vehicleNumber());
        slotRepository.save(slot); //UPDATE

        System.out.println("🅿️ Allocated Slot " + slot.getSlotCode() + " to vehicle " + event.vehicleNumber());
    }

//   @EventListener
//    public void handleVehicleExit(VehicleExitedEvent event) {
//        slotRepository.findByVehicleNumber(event.vehicleNumber())
//                .ifPresentOrElse(slot -> {
//                    slot.setAvailable(true); // free the slot
//                    slot.setVehicleNumber(null);
//                    slotRepository.save(slot);
//                    System.out.println("🅿️ Freed Slot " + slot.getSlotCode() + " from vehicle " + event.vehicleNumber());
//                }, () -> {
//                    throw new RuntimeException("🚫 No slot found for vehicle " + event.vehicleNumber());
//                });
//    }


}
