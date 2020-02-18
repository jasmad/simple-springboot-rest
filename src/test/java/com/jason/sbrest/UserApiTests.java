package com.jason.sbrest;

import com.jason.sbrest.model.USER_ROLE;
import com.jason.sbrest.model.User;
import com.jason.sbrest.model.UserBody;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

public class UserApiTests extends AbstractApiTests {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getUserListUnauthorizedTest() throws Exception {
        String uri = "/users/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).headers(agentTokenHeader())
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        User[] users = TestUtils.mapFromJson(content, User[].class);
        assertTrue(users.length > 0);
    }

    @Test
    public void getUserListTest() throws Exception {
        String uri = "/users/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).headers(adminTokenHeader())
                                    .accept(MediaType.APPLICATION_JSON_VALUE))
                                    .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        User[] users = TestUtils.mapFromJson(content, User[].class);
        assertTrue(users.length > 0);
    }

    @Test
    public void getUserById() throws Exception {
        String uri = "/users/1/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).headers(adminTokenHeader())
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        User user = TestUtils.mapFromJson(content, User.class);
        assertNotNull(user);
    }

    @Test
    public void getUserByIdNonExisting() throws Exception {
        String uri = "/users/112233/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).headers(adminTokenHeader())
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
    }

    @Test
    public void createUserTest() throws Exception {
        String uri = "/users/";
        UserBody userInput = new UserBody();
        userInput.setFirstName("createUser");
        userInput.setLastName("Test");
        userInput.setEmail("createUserTest@testing.com");
        userInput.setPassword("justTesting");
        userInput.setRole(USER_ROLE.AGENT);

        String inputJson = TestUtils.mapToJson(userInput);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).headers(adminTokenHeader())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        User newUser = TestUtils.mapFromJson(content, User.class);
        assertNotNull(newUser);
        assertEquals(userInput.getFirstName(), newUser.getFirstName());
        assertEquals(userInput.getLastName(), newUser.getLastName());
        assertEquals(userInput.getEmail(), newUser.getEmail());
        assertEquals(userInput.getRole(), newUser.getRole());
    }

}
