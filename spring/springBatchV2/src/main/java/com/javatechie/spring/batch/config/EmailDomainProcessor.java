package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Customer;
import com.javatechie.spring.batch.entity.CustomerMongo;
import org.springframework.batch.item.ItemProcessor;

public class EmailDomainProcessor implements ItemProcessor<Customer, CustomerMongo> {

    @Override
    public CustomerMongo process(Customer customer) throws Exception {
        CustomerMongo customerMongo = new CustomerMongo();

        customerMongo.setCustomerId(customer.getId());
        customerMongo.setFirstName(customer.getFirstName());
        customerMongo.setLastName(customer.getLastName());
        customerMongo.setGender(customer.getGender());
        customerMongo.setContactNo(customer.getContactNo());
        customerMongo.setCountry(customer.getCountry());
        customerMongo.setDob(customer.getDob());

        if (customer.getEmail() != null && customer.getEmail().contains("@")) {
            String emailPart = customer.getEmail().substring(0, customer.getEmail().indexOf("@"));
            String newEmail = emailPart + "@china.com";
            customerMongo.setEmail(newEmail);
        } 

        return customerMongo;
    }
}