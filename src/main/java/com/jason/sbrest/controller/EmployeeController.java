package com.jason.sbrest.controller;

import com.jason.sbrest.model.Employee;
import com.jason.sbrest.model.EmployeeBody;
import com.jason.sbrest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Employee> employeeDetailsList (Pageable pageable) {
        return employeeService.getEmployeeDetailsList(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee employeeDetails (@PathVariable("id") long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployee (@PathVariable("id") long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Employee> createUser (@RequestBody @Valid EmployeeBody empl) {
        Employee createdUser = employeeService.saveEmployee(empl);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }


}
