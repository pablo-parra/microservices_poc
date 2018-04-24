package com.capgemini.sampleinfra.eureka;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaServer
@EnableAutoConfiguration
@SpringBootApplication
public class EurekaBootApp {

  public static void main(String[] args) {

    new SpringApplicationBuilder(EurekaBootApp.class).web(true).run(args);
  }
}
