package com.capgemini.sampleapp1.foo.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

import com.capgemini.sampleapp1.foo.service.api.FooMessageTo;
import com.capgemini.sampleapp1.foo.service.api.rest.FooClient;
import com.capgemini.sampleapp1.foo.service.api.rest.FoomanagementRestService;
import com.capgemini.sampleapp1.foo.service.api.rest.SampleApp2Client;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 */
@Named("FoomanagementRestService")
public class FoomanagementRestServiceImpl implements FoomanagementRestService {

  @Inject
  FooClient fooClient;

  @Inject
  SampleApp2Client sampleApp2Client;

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

  @Override
  @HystrixCommand(fallbackMethod = "defaultResponse")
  public FooMessageTo askToSampleApp2HisName() {

    FooMessageTo response = this.sampleApp2Client.askToSampleApp2HisName();
    response.setMsg("I am ".concat(this.applicationName).concat(". From port: ")
        .concat(String.valueOf(this.applicationPort)).concat(". SampleApp2 has answered: ").concat(response.getMsg()));
    return response;
  }

  private FooMessageTo defaultResponse() {

    return new FooMessageTo(this.applicationPort + " : The sampleApp2 is down, nobody is perfect!! ¯\\_(ツ)_/¯ ");
  }

}
