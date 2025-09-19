package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.CustomerMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerMongoRepository extends MongoRepository<CustomerMongo, String> {
}