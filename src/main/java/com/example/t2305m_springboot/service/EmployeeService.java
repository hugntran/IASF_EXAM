package com.example.t2305m_springboot.service;

import com.example.t2305m_springboot.entity.Employee;
import com.example.t2305m_springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    public List<Employee> searchEmployees(String keyword) {
        return repository.findByFirstNameContainingOrLastNameContaining(keyword, keyword);
    }
}
