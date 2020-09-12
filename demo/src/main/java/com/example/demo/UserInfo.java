package com.example.demo;

import com.example.demo.model.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.LinkedHashMap;

@Controller
public class UserInfo {


//    @GetMapping("/redirect")
//    public String getUser(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient auth2AuthorizedClient){
//
//        OAuth2AccessToken token = auth2AuthorizedClient.getAccessToken();
//        System.out.println(token.toString());
//        return "login";
//    }

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
        System.out.println(token);
        response.addHeader("Token", token);

        return "redirect://localhost:8080?token=1";
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/getToken")
    @ResponseBody
    public ResponseEntity<String> getToken()
    {
        System.out.println(this.token);
        return new ResponseEntity<String>(this.token,HttpStatus.OK);
    }

}
