package com.luv2code.springboot.thymeleafdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceMock implements EmployeeService {

	@Override
	public List<Employee> findAll() {
		List<Employee> lista = new ArrayList<>();
	
		lista.add(new Employee(1000, "Patrobas","Flores","patrobas@gmail.com"));
		lista.add(new Employee(1001, "Epeneto","Flores","epeneto@gmail.com"));
		lista.add(new Employee(1002, "Andronico","Flores","andronico@gmail.com"));
		lista.add(new Employee(1003, "Filologo","Flores","filologo@gmail.com"));
		lista.add(new Employee(1004, "Olimpias","Flores","olimpias@gmail.com"));
		
		return lista;
	}

	@Override
	public Employee findById(int theId) {
		return null;
	}

	@Override
	public void save(Employee theEmployee) {
		
	}

	@Override
	public void deleteById(int theId) {
		
	}



}






