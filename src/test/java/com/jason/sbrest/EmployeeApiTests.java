package com.jason.sbrest;

import com.jason.sbrest.model.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

public class EmployeeApiTests extends AbstractApiTests {
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getEmployeeListTest() throws Exception {
        String uri = "/employees/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).headers(adminTokenHeader())
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Employee[] employees = TestUtils.mapFromJson(content, Employee[].class);
        assertTrue(employees.length > 0);
    }

    @Test
    public void getEmployeeById() throws Exception {
        String uri = "/employees/1/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).headers(adminTokenHeader())
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Employee employee = TestUtils.mapFromJson(content, Employee.class);
        assertNotNull(employee);
    }

    @Test
    public void getEmployeeByIdNonExisting() throws Exception {
        String uri = "/employees/112233/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).headers(adminTokenHeader())
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
    }

    @Test
    public void createEmployeeTest() throws Exception {
        String uri = "/employees/";
        EmployeeBody employeeInput = new EmployeeBody();
        employeeInput.setFirstName("createEmpl");
        employeeInput.setLastName("Test");
        employeeInput.setEmail("createUserTest@testing.com");

        String inputJson = TestUtils.mapToJson(employeeInput);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).headers(adminTokenHeader())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        Employee newEmployee = TestUtils.mapFromJson(content, Employee.class);
        assertNotNull(newEmployee);
        assertEquals(employeeInput.getFirstName(), newEmployee.getFirstName());
        assertEquals(employeeInput.getLastName(), newEmployee.getLastName());
        assertEquals(employeeInput.getEmail(), newEmployee.getEmail());
    }

    @Test
    public void deleteEmployeeById() throws Exception {
        String uri = "/employees/1/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri).headers(adminTokenHeader())
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        MvcResult mvcGetResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int getStatus = mvcGetResult.getResponse().getStatus();
        assertEquals(404, getStatus);
    }
}
