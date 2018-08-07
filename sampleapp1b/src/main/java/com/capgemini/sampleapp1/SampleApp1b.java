package com.capgemini.sampleapp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.devonfw.microservices.annotation.EnableMicroservices;

@EnableMicroservices
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = { "com.devonfw", "com.capgemini.sampleapp1" })
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SampleApp1b {

  /**
   * Entry point for spring-boot based app
   *
   * @param args - arguments
   */
  public static void main(String[] args) {

    SpringApplication.run(SampleApp1b.class, args);
  }
}
