package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;
import java.util.Optional;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository {

    List<Employee> findAllByOrderByLastNameAsc();

    Optional<Employee> findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
