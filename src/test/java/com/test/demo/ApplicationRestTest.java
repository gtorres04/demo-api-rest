package com.test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class ApplicationRestTest {

    @Autowired
    private MockMvc mockMvc;

    protected void assertResponse(
            String method,
            String endpoint,
            Integer expectedStatusCode,
            String expectedResponse
    ) throws Exception {
        ResultMatcher response = expectedResponse.isEmpty()
                ? content().string("")
                : content().json(expectedResponse);
        mockMvc
                .perform(request(HttpMethod.valueOf(method), endpoint))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(response);
    }

}
