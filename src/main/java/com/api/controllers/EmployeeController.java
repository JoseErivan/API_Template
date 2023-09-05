package com.api.controllers;

import com.api.dto.EmployeeDTO;
import com.api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDTOList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO employeeDTOReturned = employeeService.updateEmployee(employeeId, employeeDTO);
        return ResponseEntity.ok(employeeDTOReturned);
    }
}
