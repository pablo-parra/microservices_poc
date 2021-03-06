package com.capgemini.sampleapp2.general.service.impl;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import io.oasp.module.rest.service.impl.RestServiceExceptionFacade;

/**
 *
 */
@Named("ApplicationAccessDeniedHandler")
public class ApplicationAccessDeniedHandler implements AccessDeniedHandler {

  private RestServiceExceptionFacade exceptionFacade;

  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response,
      AccessDeniedException accessDeniedException) throws IOException, ServletException {

    Response restResponse = this.exceptionFacade.toResponse(accessDeniedException);
    Object entity = restResponse.getEntity();
    response.setStatus(restResponse.getStatus());
    if (entity != null) {
      response.getWriter().write(entity.toString());
    }
  }

  /**
   * @param exceptionFacade the exceptionFacade to set
   */
  @Inject
  public void setExceptionFacade(RestServiceExceptionFacade exceptionFacade) {

    this.exceptionFacade = exceptionFacade;
  }

}
