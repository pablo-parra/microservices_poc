package com.capgemini.sampleapp1.foo.service.api;

import java.io.Serializable;

/**
 */
public class FooMessageTo implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  /**
   * json property
   */
  private String msg;

  /**
   * The default constructor.
   */
  public FooMessageTo() {
  }
  
  /**
   * The constructor.
   *
   * @param msg
   */
  public FooMessageTo(String msg) {
    setMsg(msg);
  }

  /**
   * @return msg
   */
  public String getMsg() {

    return this.msg;
  }

  /**
   * @param msg new value of {@link #getMsg}.
   */
  public void setMsg(String msg) {

    this.msg = msg;
  }
}
