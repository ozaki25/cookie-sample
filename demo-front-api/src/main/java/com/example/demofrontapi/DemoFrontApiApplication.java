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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@SpringBootApplication
@RestController
@CrossOrigin(allowCredentials = "true")
public class DemoFrontApiApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoFrontApiApplication.class, args);
  }

  @Autowired
  private RestTemplateBuilder restTemplateBuilder;

  @PostMapping
  public ResponseEntity<?> login(@RequestHeader MultiValueMap<String, String> headers, @CookieValue(name = "sessionId", required = false) String sessionId) {
    System.out.println("###################");
    System.out.println(sessionId);
    System.out.println("###################");

    RestTemplate restTemplate = restTemplateBuilder.build();
    RequestEntity<String> requestEntity = null;
    URI uri = UriComponentsBuilder
      .fromUriString("http://localhost:8082")
      .build()
      .toUri();
    requestEntity = new RequestEntity<String>(null, headers, HttpMethod.POST, uri);

    return restTemplate.exchange(requestEntity, Object.class);
  }

}

