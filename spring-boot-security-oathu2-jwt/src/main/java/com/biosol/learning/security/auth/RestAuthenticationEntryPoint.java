package com.biosol.learning.security.auth;

import java.io.*;

import javax.servlet.http.*;

/**
 * Created by fan.jin on 2016-11-12.
 */
import org.springframework.security.core.*;
import org.springframework.security.web.*;
import org.springframework.stereotype.*;

/**
 * Created by fan.jin on 2016-11-07.
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // This is invoked when user tries to access a secured REST resource without supplying any credentials
        // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}

