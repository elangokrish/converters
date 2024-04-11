package com.example.converter.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Base64;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
//@RequestMapping("/api/v1")
public class Controller {
    
    @GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

    @GetMapping("/base64/decode")
    public String handleBase64Decode(@RequestParam String param) {
        //String originalInput = "test input";
        String encodedString = Base64.getEncoder().encodeToString(param.getBytes());
        System.out.println("decoded String:"+encodedString);
        return encodedString;
    }
    
    @GetMapping("/base64/encode")
    public String handleBase64Encode(@RequestParam String param) {
        byte[] decodedBytes = Base64.getDecoder().decode(param);
        String decodedString = new String(decodedBytes);
        System.out.println("encoded String:"+decodedString);
        return decodedString;
    }

    
}
