package com.example.demobackapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;


@SpringBootApplication
@RestController
@CrossOrigin(allowCredentials = "true")
public class DemoBackApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoBackApiApplication.class, args);
  }

  @PostMapping
  public ResponseEntity<Hello> login(@RequestParam MultiValueMap<String, String> params) {
    Hello hello = new Hello();
    hello.setHello("Hello!!!!!");
    HttpCookie cookie = ResponseCookie.from("IwSessionId", "xxxxxxxxxxxxxxxxxxx").path("/").build();
    return ResponseEntity
      .ok()
      .header(HttpHeaders.SET_COOKIE, cookie.toString())
      .body(hello);
  }
}

class Hello {
  private String hello;

  public void setHello(String hello) {
    this.hello = hello;
  }

  public String getHello() {
    return this.hello;
  }
}