package com.jason.sbrest.service.impl;

import com.jason.sbrest.model.Employee;
import com.jason.sbrest.model.EmployeeBody;
import com.jason.sbrest.model.User;
import com.jason.sbrest.repository.EmployeeRepository;
import com.jason.sbrest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeeDetailsList(Pageable pageable) {
        Page<Employee> page = employeeRepository.findAll(pageable);
        return page.getContent();
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not found employee " + employeeId));
    }

    @Override
    public Employee saveEmployee(@Valid EmployeeBody empl) {
        Employee newEmployee = new Employee();
        newEmployee.setEmail(empl.getEmail());
        newEmployee.setFirstName(empl.getFirstName());
        newEmployee.setLastName(empl.getLastName());
        return employeeRepository.save(newEmployee);
    }

    @Override
    public void deleteEmployee(long emplId) {
        employeeRepository.deleteById(emplId);
    }
}
