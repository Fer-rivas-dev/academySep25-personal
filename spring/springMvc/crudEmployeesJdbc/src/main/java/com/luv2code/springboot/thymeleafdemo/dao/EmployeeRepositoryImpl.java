package com.luv2code.springboot.thymeleafdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private DataSource dataSource;

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
        String sql = "SELECT * FROM employee WHERE id = ?";
        
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                int empId = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                Employee employee = new Employee(empId, firstName, lastName, email);
                return Optional.of(employee);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

    @Override
    public void save(Employee employee) {
        String sql;
        
        if (employee.getId() == 0) {
            sql = "INSERT INTO employee (first_name, last_name, email) VALUES (?, ?, ?)";
        } else {
            sql = "UPDATE employee SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
        }
        
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            
            if (employee.getId() != 0) {
                statement.setInt(4, employee.getId());
            }
            
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, id);
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}