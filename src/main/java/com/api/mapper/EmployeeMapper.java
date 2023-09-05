package com.api.mapper;

import com.api.dto.EmployeeDTO;
import com.api.entities.Employee;

public class EmployeeMapper {

    public static EmployeeDTO mapToEmployeeDTO (Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee (EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail());
    }
}
