package com.example.demo;

import com.example.demo.model.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/login")
    @ResponseBody
    public String getLogin()
    {
        return "<a href='/oauth2/authorization/spotify'>Login</a>";
    }


    @GetMapping("/hello")
    public String hello(HttpServletResponse response)
    {
        String token = ((OAuth2AuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getTokenValue();
        System.out.println(token);
        response.addHeader("Token", token);

        return "redirect://localhost:8080?token="+token;
    }

    @GetMapping("/")
    @ResponseBody
    public String volvo()
    {
        return "jebane";
    }

    @GetMapping("/user")
    @ResponseBody
    public String kek(HttpServletResponse response)
    {
        String token = ((OAuth2AuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getTokenValue();
        System.out.println(token);
        response.addHeader("Token", token);
        return "kurwa";
    }
}
