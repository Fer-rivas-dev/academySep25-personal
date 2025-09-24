package com.javatechie.smartparking_system.entry;

import org.springframework.beans.factory.annotation.Autowired;
import com.javatechie.smartparking_system.event.VehicleEnteredEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EntryService {

    // save vehicle entry details to DB
    // allocate a parking slot
    // send notification to the user

    private final ParkingEntryRepository repository;
    private final ApplicationEventPublisher publisher;

    @Autowired
    public EntryService(ParkingEntryRepository repository,
                        ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }


    public void vehicleEntry(String vehicleNumber) {
        ParkingEntry parkingEntry = new ParkingEntry(null, vehicleNumber, LocalDateTime.now(), null, true);
        repository.save(parkingEntry);
        // publish an event
        publisher.publishEvent(new VehicleEnteredEvent(vehicleNumber, parkingEntry.getEntryTime()));

    }
}
