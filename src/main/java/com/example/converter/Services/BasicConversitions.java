package com.example.converter.Services;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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


    public String URLDecoder(String value,String method) throws UnsupportedEncodingException {

        String decodedString=null;
        switch (method) {
            case "UTF_8":
                decodedString = URLDecoder.decode(value, StandardCharsets.UTF_8);
                break;
            case "UTF_16":
                decodedString = URLDecoder.decode(value, StandardCharsets.UTF_16);
                break;
            case "US_ASCII":
                decodedString = URLDecoder.decode(value, StandardCharsets.US_ASCII);
                break;
            case "ISO_8859_1":
                decodedString = URLDecoder.decode(value, StandardCharsets.ISO_8859_1);
                break;
            case "UTF_16BE":
                decodedString = URLDecoder.decode(value, StandardCharsets.UTF_16BE);
                break;
            case "UTF_16LE":
                decodedString = URLDecoder.decode(value, StandardCharsets.UTF_16LE);
                break;
            default:
                break;
        }
        return decodedString;
    }

    public String URLEncoder(String value,String method) throws UnsupportedEncodingException {

        String encodedString=null;
        switch (method) {
            case "UTF_8":
                encodedString = URLEncoder.encode(value, StandardCharsets.UTF_8);
                break;
            case "UTF_16":
                encodedString = URLEncoder.encode(value, StandardCharsets.UTF_16);
                break;
            case "US_ASCII":
                encodedString = URLEncoder.encode(value, StandardCharsets.US_ASCII);
                break;
            case "ISO_8859_1":
                encodedString = URLEncoder.encode(value, StandardCharsets.ISO_8859_1);
                break;
            case "UTF_16BE":
                encodedString = URLEncoder.encode(value, StandardCharsets.UTF_16BE);
                break;
            case "UTF_16LE":
                encodedString = URLEncoder.encode(value, StandardCharsets.UTF_16LE);
                break;
            default:
                break;
        }
        return encodedString;
    }
}
