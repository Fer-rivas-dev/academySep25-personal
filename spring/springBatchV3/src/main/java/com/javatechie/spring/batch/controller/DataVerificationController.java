package com.javatechie.spring.batch.controller;

import com.javatechie.spring.batch.repository.CustomerRepository;
import com.javatechie.spring.batch.repository.CustomerMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DataVerificationController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMongoRepository customerMongoRepository;

    @GetMapping("/verify-data")
    public Map<String, Object> verifyData() {
        Map<String, Object> result = new HashMap<>();

        long h2Count = customerRepository.count();
        long mongoCount = customerMongoRepository.count();

        result.put("h2_database_records", h2Count);
        result.put("mongodb_records", mongoCount);
        result.put("data_integrity_check", h2Count == mongoCount ? "PASSED" : "FAILED");
        result.put("batch_migration_status", h2Count > 0 && mongoCount > 0 ? "SUCCESS" : "INCOMPLETE");

        return result;
    }
}