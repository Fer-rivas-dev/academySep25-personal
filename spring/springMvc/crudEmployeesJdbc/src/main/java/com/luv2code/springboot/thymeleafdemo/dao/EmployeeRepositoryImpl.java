package com.luv2code.springboot.thymeleafdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private DataSource dataSource;

    @Autowired
    public EmployeeRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Employee> findAllByOrderByLastNameAsc() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee ORDER BY last_name ASC";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                Employee employee = new Employee(id, firstName, lastName, email);
                employees.add(employee);
            }
        } catch (SQLException e) {
            // For simplicity, we'll print the stack trace
            // In a real application, you should handle this more gracefully
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public Optional<Employee> findById(int id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void save(Employee employee) {
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
    }
}