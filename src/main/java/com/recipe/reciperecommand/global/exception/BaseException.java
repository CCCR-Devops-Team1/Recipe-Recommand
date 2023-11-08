package com.recipe.reciperecommand.global.exception;

import com.recipe.reciperecommand.global.dto.response.ResponseStatus;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BaseException extends RuntimeException{
  private ResponseStatus status;

  public BaseException(ResponseStatus status){
    super(status.getMsg());
    this.status = status;
  }

}
