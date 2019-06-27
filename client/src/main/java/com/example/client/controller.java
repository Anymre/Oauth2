package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class controller {
    @Autowired
    private OAuth2RestTemplate restTemplate;
    @RequestMapping("/")
    public String test(){
        String o = restTemplate.getAccessToken().getValue();
        return "redirect:http://127.0.0.1:8080?access_token="+o;
    }
}
