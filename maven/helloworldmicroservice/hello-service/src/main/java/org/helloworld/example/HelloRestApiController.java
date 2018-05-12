package org.helloworld.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestApiController
{
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello()
    {
        return "hello";
    }
}
