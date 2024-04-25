package com.example.converter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.converter.Services.BasicConversitions;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.logging.log4j.Logger;


@RestController
//@RequestMapping("/api/v1")
public class Controller {

    ///Logger logger = LoggerFactory.getLogger(Controller.class);
     private static final Logger logger = LogManager.getLogger(Controller.class);
    
    @Autowired
    BasicConversitions basicConversitions; 
    
    @GetMapping("/")
	public String index() {
        logger.debug("simply implemented log");
		return "welcome to Spring Boot project!";
	}

    @GetMapping("/base64/decode")
    public String handleBase64Decode(@RequestParam String value) throws UnsupportedEncodingException {
        
       return basicConversitions.base64Decode(value);
    }
    
    @GetMapping("/base64/encode")
    public String handleBase64Encode(@RequestParam String value) throws UnsupportedEncodingException {
       
        return basicConversitions.base64Encode(value);
    }

    @GetMapping("/url/encode")
    public String handleUrlEncode(@RequestParam String value,@RequestParam String method) throws UnsupportedEncodingException {
       
        return basicConversitions.URLEncoder(value,method);
    }

    @GetMapping("/url/decode")
    public String handleUrlDecode(@RequestParam String value,@RequestParam String method) throws UnsupportedEncodingException {
       
        return basicConversitions.URLDecoder(value,method);
    }

    @GetMapping("jwt/decode")
    public Map<String, Object> handleDecodeJwtToken(@RequestParam String token) throws UnsupportedEncodingException {
        return basicConversitions.jwtDecode(token);
    }


    
}
