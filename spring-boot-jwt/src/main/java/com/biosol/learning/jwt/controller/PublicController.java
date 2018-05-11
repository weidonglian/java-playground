package com.biosol.learning.jwt.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fan.jin on 2017-05-08.
 */

@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class PublicController {

    @RequestMapping( method = GET, value= "/foo")
    public Map<String, String> getFoo() {
        Map<String, String> fooObj = new HashMap<>();
        fooObj.put("foo", "bar");
        return fooObj;
    }

}
