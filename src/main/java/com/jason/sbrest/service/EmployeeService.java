package com.jason.sbrest.service;

import com.jason.sbrest.model.Employee;
import com.jason.sbrest.model.EmployeeBody;
import com.jason.sbrest.model.User;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeeDetailsList(Pageable pageable);

    Employee getEmployeeById(long emplId);

    Employee saveEmployee(@Valid EmployeeBody empl);

    void deleteEmployee(long emplId);
}
