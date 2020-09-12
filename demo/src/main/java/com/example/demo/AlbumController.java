package com.example.demo;

import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.model.Artists;
import com.example.demo.model.SpotifyAlbum;
import net.minidev.json.JSONObject;
import org.codehaus.jackson.JsonNode;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class AlbumController {

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/search/{name}")
    public ResponseEntity<Artists> getArtists(@RequestHeader("Authorization") String token, @PathVariable String name)
    {
        RestTemplate restTemplate = new RestTemplate();

        System.out.println(token);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<SpotifyAlbum> albumResponseEntity = null;
        try{
            albumResponseEntity = restTemplate.exchange( 	"https://api.spotify.com/v1/search?q="+name+"&type=artist,track&limit=5",
                HttpMethod.GET,
                entity,
                SpotifyAlbum.class);
        }catch (HttpClientErrorException e)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return  ResponseEntity.
                status(HttpStatus.OK).
                body(albumResponseEntity.getBody().getArtists());

    }


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/artist/{id}")
    public ResponseEntity<JSONObject> getArtistInfo(@RequestHeader("Authorization") String header, @PathVariable String id)
    {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", header);
        HttpEntity entity = new HttpEntity(httpHeaders);
        ResponseEntity<JSONObject> artistResponseEntity = null;
        ResponseEntity<JSONObject> tracksEntity = null;
        ResponseEntity<JSONObject> albumsEntity = null;
        JSONObject result = new JSONObject();
        try{
            artistResponseEntity = restTemplate.exchange("https://api.spotify.com/v1/artists/"+id,
                HttpMethod.GET,
                entity,
                JSONObject.class);
            tracksEntity = restTemplate.exchange("https://api.spotify.com/v1/artists/"+id+"/top-tracks?country=SE",
                HttpMethod.GET,
                entity,
                JSONObject.class);
         albumsEntity = restTemplate.exchange("https://api.spotify.com/v1/artists/"+id+"/albums?limit=10",
            HttpMethod.GET,
            entity,
            JSONObject.class);
        }catch (HttpClientErrorException unauthorized)
        {
            JSONObject error = new JSONObject();
            error.put("stats",401);
            error.put("message", "expired");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }
        result.put("Artist", artistResponseEntity.getBody());
        result.put("Top-Tracks", tracksEntity.getBody());
        result.put("Albums", albumsEntity.getBody());

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
