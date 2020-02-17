package com.example.demobackapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;


@SpringBootApplication
@RestController
@CrossOrigin(allowCredentials = "true")
public class DemoBackApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoBackApiApplication.class, args);
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Hello> login() {
    HttpCookie cookie = ResponseCookie.from("sessionId", "xxxxxxxxxxxxxxxxxxx")/*.sameSite("None").secure(true).domain("localhost")*/.path("/").build();
    Hello hello = new Hello();
    hello.setHello("Hello!!!!!!!!!!!!!");
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
