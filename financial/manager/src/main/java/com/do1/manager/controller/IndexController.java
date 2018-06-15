package com.do1.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController 
public class IndexController {
   
	@RequestMapping("/")  
    public String index(){  
        return "webapp start..";  
    }  


}
