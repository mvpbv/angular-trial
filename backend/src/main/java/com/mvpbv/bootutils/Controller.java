package com.mvpbv.bootutils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    @RequestMapping("/healthz")
    public String hello() {
        return "Ready to go!";
    }
    @RequestMapping("err") 
    public String err() {
        return "Error!";
    }
}

