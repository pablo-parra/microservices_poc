package com.capgemini.sampleapp2.general.common.base;

import javax.inject.Inject;

import io.oasp.module.beanmapping.common.api.BeanMapper;

/**
 * This abstract class wraps advanced functionality according dozer mappings
 */
public abstract class AbstractBeanMapperSupport {

  /** @see #getBeanMapper() */
  @Inject
  private BeanMapper beanMapper;

  /**
   * @return the {@link BeanMapper} instance.
   */
  protected BeanMapper getBeanMapper() {

    return this.beanMapper;
  }

}
