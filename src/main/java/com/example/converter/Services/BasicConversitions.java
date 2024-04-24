package com.example.converter.Services;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class BasicConversitions {
    
    public String base64Encode(String param) throws UnsupportedEncodingException {

        String encodedString = Base64.getEncoder().encodeToString(param.getBytes("UTF-8"));
        System.out.println("Encoded String:"+encodedString);
        return encodedString;

    }//DONE

    /*public static byte[] base64Encode2(byte[] data) throws UnsupportedEncodingException {
        return Base64.decodeBase64(data);
    }
     
    public static byte[] base64Decode2(String data) throws UnsupportedEncodingException {
        return Base64.getDecoder();
    }*/
    

    public String base64Decode(String param) throws UnsupportedEncodingException {

        byte[] decodedBytes = Base64.getDecoder().decode(param);
        String decodedString = new String(decodedBytes,"UTF-8");
        System.out.println("Decoded String:"+decodedString);
        return decodedString;

        //System.out.println("Decoded: " + new String(bytes, "UTF-8")); /
    }////DONE

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

    public Map<String, Object> jwtDecode(String token) throws UnsupportedEncodingException{

        System.out.println("received token:{}"+token);
        String parts[] = token.split("\\.");

        if( parts.length < 2 || parts.length >3){
            System.out.println("not a proper jwt Token"+token+"length is:"+parts.length);            
        }

        String header = base64Decode(parts[0]);
        String payload =  base64Decode(parts[1]);
        String signature=null;

        if(parts.length==3){
            signature  = base64Decode(parts[2]);
        }
        Map<String,Object> decodedJwtMap= new HashMap<String,Object>();   
        decodedJwtMap.put("header", header);
        decodedJwtMap.put("payload", payload);
        decodedJwtMap.put("signature", signature);

        System.out.println("decodedJwtMap:{}"+decodedJwtMap);
        return decodedJwtMap;

        //        JSONObject header = new JSONObject(decode(parts[0]));
        //  JSONObject payload = new JSONObject(decode(parts[1]));
    }
}
