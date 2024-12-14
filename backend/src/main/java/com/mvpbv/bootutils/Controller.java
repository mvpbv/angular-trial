package com.mvpbv.bootutils;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/v1")
public class Controller {


    public Controller() {
    }

    @RequestMapping("/healthz")
    public Map<String, String> healthCheck() {
        var response = new HashMap<String, String>();
        response.put("status", "Ready to go!");
        return response;
    }
    @RequestMapping("err")
    public String err() {
        return "Error!";
    }
    
    
}

