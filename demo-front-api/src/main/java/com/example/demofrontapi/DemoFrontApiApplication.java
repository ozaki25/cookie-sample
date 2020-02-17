package com.example.demofrontapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
@CrossOrigin(allowCredentials = "true")
public class DemoFrontApiApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoFrontApiApplication.class, args);
  }

  @PostMapping
  public ResponseEntity<String> login() {
    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.postForObject("http://localhost:8082", null, String.class);
    return ResponseEntity.ok().body(result);
  }

}

