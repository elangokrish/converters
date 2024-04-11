package com.example.converter.Services;

import java.util.Base64;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class BasicConversitions {
    
    public String base64Encode(String param) {

        String encodedString = Base64.getEncoder().encodeToString(param.getBytes());
        System.out.println("Encoded String:"+encodedString);
        return encodedString;
    }

    public String base64Decode(String param) {

        byte[] decodedBytes = Base64.getDecoder().decode(param);
        String decodedString = new String(decodedBytes);
        System.out.println("Decoded String:"+decodedString);
        return decodedString;
    }

}
