package com.capgemini.sampleapp1.foo.service.api.rest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgemini.sampleapp1.foo.service.api.FooMessageTo;

@FeignClient(value = "sampleapp2")
public interface SampleApp2Client {

  @RequestMapping(method = RequestMethod.GET, path = "/sampleapp2/services/rest/foomanagement/v1/sayYourName")
  FooMessageTo askToSampleApp2HisName();

}
