package com.jason.sbrest;

import com.jason.sbrest.model.JwtRequest;
import com.jason.sbrest.model.JwtResponse;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SbrestApplication.class)
@WebAppConfiguration
public class AbstractApiTests {
    protected MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected String retrieveAdminToken() throws Exception {
        String uri = "/authenticate/";
        JwtRequest req = new JwtRequest();
        req.setUsername("admin@admin.admin");
        req.setPassword("nimda");
        String inputJson = TestUtils.mapToJson(req);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        JwtResponse jwtResponse = TestUtils.mapFromJson(content, JwtResponse.class);
        return jwtResponse.getJwttoken();
    }

    protected String retrieveAgentToken() throws Exception {
        String uri = "/authenticate/";
        JwtRequest req = new JwtRequest();
        req.setUsername("agent@agent.agent");
        req.setPassword("nimda");
        String inputJson = TestUtils.mapToJson(req);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        JwtResponse jwtResponse = TestUtils.mapFromJson(content, JwtResponse.class);
        return jwtResponse.getJwttoken();
    }

    protected HttpHeaders adminTokenHeader() throws Exception {
        String token = retrieveAdminToken();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        return headers;
    }

    protected HttpHeaders agentTokenHeader() throws Exception {
        String token = retrieveAgentToken();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        return headers;
    }
}
