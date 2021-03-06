package com.example.demofrontapi;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@SpringBootApplication
@RestController
@CrossOrigin(allowCredentials = "true", origins = {"http://localhost:4200"})
public class DemoFrontApiApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoFrontApiApplication.class, args);
  }

  @Autowired
  private RestTemplateBuilder restTemplateBuilder;

  @GetMapping
  public ResponseEntity<String> hello(@CookieValue(name = "sessionId", required = false) String sessionId) {
  return ResponseEntity.ok().body(sessionId);
  }

  
  @PostMapping
  public ResponseEntity<?> login(@RequestHeader MultiValueMap<String, String> headers, @CookieValue(name = "sessionId", required = false) String sessionId) {
    System.out.println("###################");
    System.out.println(sessionId);
    System.out.println("###################");

    RestTemplate restTemplate = restTemplateBuilder.build();
    RequestEntity<String> requestEntity = null;
    URI uri = UriComponentsBuilder
      .fromUriString("http://127.0.0.1:8082")
      .build()
      .toUri();
    requestEntity = new RequestEntity<String>(null, headers, HttpMethod.POST, uri);

    return restTemplate.exchange(requestEntity, Object.class);
  }

}

