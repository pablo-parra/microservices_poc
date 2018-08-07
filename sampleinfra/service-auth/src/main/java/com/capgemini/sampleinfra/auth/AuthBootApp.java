package com.capgemini.sampleinfra.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.devonfw.microservices.annotation.EnableMicroservices;

@EnableMicroservices
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class AuthBootApp {

  public static void main(String[] args) {

    SpringApplication.run(AuthBootApp.class, args);
  }

}
