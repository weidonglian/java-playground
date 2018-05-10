package com.biosol.learning.test.security;


import java.util.*;

import org.junit.*;
import org.springframework.test.util.*;

import com.biosol.learning.security.*;
import com.biosol.learning.service.impl.*;

import io.jsonwebtoken.*;

/**
 * Created by fan.jin on 2017-01-08.
 */
public class TokenHelperTest {

    private TokenHelper tokenHelper;

    @Before
    public void init() {
        tokenHelper = new TokenHelper();
        FixedClockService fixedClockService = new FixedClockService(new Date(20L));
        ReflectionTestUtils.setField(tokenHelper, "clockService", fixedClockService);
        ReflectionTestUtils.setField(tokenHelper, "EXPIRES_IN", 1);
        ReflectionTestUtils.setField(tokenHelper, "SECRET", "mySecret");
    }

    @Test(expected=ExpiredJwtException.class)
    public void testGenerateTokenExpired() {
        String token = tokenHelper.generateToken("fanjin");
        Jwts.parser()
            .setSigningKey("mySecret")
            .parseClaimsJws(token)
            .getBody();
    }
}
