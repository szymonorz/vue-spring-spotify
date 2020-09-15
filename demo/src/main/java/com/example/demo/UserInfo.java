package com.example.demo;

import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserInfo {



    private String token;
    @GetMapping("/login")
    @ResponseBody
    public String getLogin()
    {
        return "<a href='/oauth2/authorization/spotify'>Login</a>";
    }


    @GetMapping("/hello")
    public String hello(HttpServletResponse response)
    {
        token = ((OAuth2AuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getTokenValue();
        response.addHeader("Token", token);

        return "redirect://localhost:8080?token=1";
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/getToken")
    @ResponseBody
    public ResponseEntity<String> getToken()
    {
        return new ResponseEntity<String>(this.token,HttpStatus.OK);
    }

}
