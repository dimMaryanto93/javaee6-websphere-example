package com.maryanto.dimas.example.service;

import com.maryanto.dimas.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String findById(Integer employeeId) {
        return this.employeeRepository.findById(employeeId);
    }
}
