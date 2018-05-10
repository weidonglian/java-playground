package com.biosol.learning.test;

import javax.annotation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;

import com.biosol.learning.security.auth.*;

import io.restassured.*;
import io.restassured.module.mockmvc.*;

@Configuration
public class MockMvcConfig {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private TokenAuthenticationFilter filter;

//    @Autowired
//    private Environment env;

    private int port = 8080;

    public RequestBuilder mockRequestBuilder() {
        return null;
    }

    @Bean
    public MockMvc mockMvc() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(wac);
        return builder.addFilters(filter)
                .build();
    }

    @PostConstruct
    protected void restAssured() {
        RestAssuredMockMvc.mockMvc(mockMvc());
        RestAssured.port = this.port;
    }
}
