package com.example.demo;

import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.model.Artists;
import com.example.demo.model.SpotifyAlbum;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class AlbumController {

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/search/{name}")
    public Artists getArtists(@RequestHeader("Authorization") String token, @PathVariable String name)
    {
        RestTemplate restTemplate = new RestTemplate();

        System.out.println(token);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<SpotifyAlbum> albumResponseEntity = restTemplate.exchange( 	"https://api.spotify.com/v1/search?q="+name+"&type=artist,track&limit=5",
                HttpMethod.GET,
                entity,
                SpotifyAlbum.class);
        return  albumResponseEntity.getBody().getArtists();

    }


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/artist/{id}")
    public Artist getArtistInfo(@RequestHeader("Authorization") String header, @PathVariable String id)
    {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", header);
        HttpEntity entity = new HttpEntity(httpHeaders);
        ResponseEntity<Artist> artistResponseEntity = restTemplate.exchange("https://api.spotify.com/v1/artists/"+id,
                HttpMethod.GET,
                entity,
                Artist.class);

        return artistResponseEntity.getBody();
    }

}