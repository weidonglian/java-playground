package com.biosol.learning.security.auth;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.web.authentication.logout.*;
import org.springframework.stereotype.*;

import com.fasterxml.jackson.databind.*;

/**
 * Created by fan.jin on 2017-05-06.
 */
@Component
public class LogoutSuccess implements LogoutSuccessHandler {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        Map<String, String> result = new HashMap<>();
        result.put( "result", "success" );
		response.setContentType("application/json");
		response.getWriter().write( objectMapper.writeValueAsString( result ) );
        response.setStatus(HttpServletResponse.SC_OK);

    }

}