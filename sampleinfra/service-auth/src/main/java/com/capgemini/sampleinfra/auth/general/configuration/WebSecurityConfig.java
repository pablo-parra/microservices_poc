package com.capgemini.sampleinfra.auth.general.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.devonfw.microservices.configuration.jwt.JsonWebTokenUtility;

import io.oasp.module.rest.service.impl.RestServiceExceptionFacade;

/**
 * Security configuration based on {@link WebSecurityConfigurerAdapter}.
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${security.expose.error.details}")
  boolean exposeInternalErrorDetails;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests().anyRequest()/* .authenticated() */.anonymous().and()

        // disable CSRF, http basic, form login
        .csrf().disable() //
        .httpBasic().disable() //
        .formLogin().disable()

        // ReST is stateless, no sessions
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Bean
  public RestServiceExceptionFacade restServiceExceptionFacade() {

    RestServiceExceptionFacade exceptionFacade = new RestServiceExceptionFacade();
    exceptionFacade.setExposeInternalErrorDetails(this.exposeInternalErrorDetails);
    return exceptionFacade;
  }

  @Bean
  public JsonWebTokenUtility getJsonWebTokenUtility() {

    return new JsonWebTokenUtility();
  }

  // @SuppressWarnings("javadoc")
  // @Inject
  // public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
  //
  // auth.inMemoryAuthentication().withUser("pablo").password("1234").roles("Developer");
  // }
}
