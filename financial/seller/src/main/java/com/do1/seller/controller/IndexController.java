package com.do1.seller.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class IndexController {
   
	@RequestMapping("/")  
    public String index(){  
        return "webapp seller start..";  
    }  


}
