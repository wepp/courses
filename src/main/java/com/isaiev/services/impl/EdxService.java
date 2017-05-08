package com.isaiev.services.impl;

import com.isaiev.parsers.EdxJsonParser;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * Created by Isaiev on 08.05.2017.
 */
@Service
public class EdxService {

    private EdxJsonParser parser = new EdxJsonParser();
    private String token;

    private final String CLIENT_ID="AUaiiUV1XyisGfqOQmgfEifGQ7VNYTDj1RVQjVze";
    private final String CLIENT_SECRET="l6uBn6b9zBUwFqCWr6OACHO9Y56HbXSW6RYnohZ2U9vtXF58VKOPQCOED6oMfpMnJDXG6uR1BMK6rsgtdsZN5Ie11jpl5BtTHdUCPHpIK5ZIJuOgVbclZk4NdrGhJgmS";

    public void getAllCourses () {
        if(token==null){
            getAccessToken ();
        }
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.edx.org/catalog/v1/catalogs/125/courses";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, generateRequestForAll(),String.class);
        System.out.println(response.getBody());
    }

    private HttpEntity generateRequestForAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "JWT "+token);
        return new HttpEntity(headers);
    }

    public void getAccessToken (){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.edx.org/oauth2/v1/access_token";
        String response = restTemplate.postForObject(url, generateRequestForToken(), String.class);
        //System.out.println("response "+response);
        token = parser.parseAccessToken(response);
    }

    private HttpEntity<Object> generateRequestForToken(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String request = "grant_type=client_credentials&"+
                "client_id="+CLIENT_ID+"&"+
                "client_secret="+CLIENT_SECRET+"&"+
                "token_type=jwt";
        return new HttpEntity<Object>(request, headers);
    }
}
