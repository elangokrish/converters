package com.example.converter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.converter.Services.BasicConversitions;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
//@RequestMapping("/api/v1")
public class Controller {

    @Autowired
    BasicConversitions basicConversitions; 
    
    @GetMapping("/")
	public String index() {
		return "welcome to elango's Spring Boot project!";
	}

    @GetMapping("/base64/decode")
    public String handleBase64Decode(@RequestParam String param) {
        
        return basicConversitions.base64Decode(param);
    }
    
    @GetMapping("/base64/encode")
    public String handleBase64Encode(@RequestParam String param) {
       
        return basicConversitions.base64Encode(param);
    }

    
}
