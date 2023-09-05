package com.api.services.impl;

import com.api.dto.EmployeeDTO;
import com.api.entities.Employee;
import com.api.exceptions.ResourceNotFoundException;
import com.api.mapper.EmployeeMapper;
import com.api.repositories.EmployeeRepository;
import com.api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("The employee was not found by id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }
}
