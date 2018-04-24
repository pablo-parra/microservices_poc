package com.capgemini.sampleapp2.foo.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

import com.capgemini.sampleapp2.foo.service.api.FooMessageTo;
import com.capgemini.sampleapp2.foo.service.api.rest.FooClient;
import com.capgemini.sampleapp2.foo.service.api.rest.FoomanagementRestService;

/**
 */
@Named("FoomanagementRestService")
public class FoomanagementRestServiceImpl implements FoomanagementRestService {

  @Inject
  FooClient fooClient;

  @Value("${msgFromConfigServer}")
  String msgFromConfigServer;

  @Value("${spring.application.name}")
  private String applicationName;

  @Value("${server.port}")
  private int applicationPort;

  @Override
  public FooMessageTo foo() {

    return new FooMessageTo(this.msgFromConfigServer);
  }

  @Override
  public FooMessageTo fooRemote() {

    return this.fooClient.foo();
  }

  @Override
  public FooMessageTo sayYourName() {

    return new FooMessageTo(this.applicationName.concat(". From port: ").concat(String.valueOf(this.applicationPort)));
  }

}
