package com.biosol.learning.jwt.security;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import com.biosol.learning.jwt.service.*;

import io.jsonwebtoken.*;


/**
 * Created by fan.jin on 2016-10-19.
 */

@Component
public class TokenHelper {

    @Value("${app.name}")
    private String APP_NAME;

    @Value("${jwt.secret}")
    private String SECRET;

    @Value("${jwt.expires_in}")
    private int EXPIRES_IN;

    @Value("${jwt.header}")
    private String AUTH_HEADER;

    @Value("${jwt.cookie}")
    private String AUTH_COOKIE;

    @Autowired
    UserDetailsService userDetailsService;
    
    @Autowired
    ClockService clockService;
    
    private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setIssuer( APP_NAME )
                .setSubject(username)
                .setIssuedAt(generateCurrentDate())
                .setExpiration(generateExpirationDate())
                .signWith( SIGNATURE_ALGORITHM, SECRET )
                .compact();
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(this.SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith( SIGNATURE_ALGORITHM, SECRET )
                .compact();
    }

    public Boolean canTokenBeRefreshed(String token) {
        try {
            final Date expirationDate = getClaimsFromToken(token).getExpiration();
//            String username = getUsernameFromToken(token);
//            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            return expirationDate.compareTo(generateCurrentDate()) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.setIssuedAt(generateCurrentDate());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    private Date generateCurrentDate() {
        return clockService.date();
    }

    private Date generateExpirationDate() {
        return new Date(clockService.millis() + this.EXPIRES_IN * 1000);
    }

    public String getToken( HttpServletRequest request ) {
        /**
         *  Getting the token from Cookie store
         */
        Cookie authCookie = getCookieValueByName( request, AUTH_COOKIE );
        if ( authCookie != null ) {
            return authCookie.getValue();
        }
        /**
         *  Getting the token from Authentication header
         *  e.g Bearer your_token
         */
        String authHeader = request.getHeader(AUTH_HEADER);
        if ( authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }

    /**
     * Find a specific HTTP cookie in a request.
     *
     * @param request
     *            The HTTP request object.
     * @param name
     *            The cookie name to look for.
     * @return The cookie, or <code>null</code> if not found.
     */
    public Cookie getCookieValueByName(HttpServletRequest request, String name) {
        if (request.getCookies() == null) {
            return null;
        }
        for (int i = 0; i < request.getCookies().length; i++) {
            if (request.getCookies()[i].getName().equals(name)) {
                return request.getCookies()[i];
            }
        }
        return null;
    }
}
