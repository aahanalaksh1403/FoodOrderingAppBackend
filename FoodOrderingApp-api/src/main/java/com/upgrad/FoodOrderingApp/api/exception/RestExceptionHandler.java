package com.upgrad.FoodOrderingApp.api.exception;

import com.upgrad.FoodOrderingApp.api.model.ErrorResponse;
import com.upgrad.FoodOrderingApp.service.exception.AuthenticationFailedException;
import com.upgrad.FoodOrderingApp.service.exception.AuthorizationFailedException;
import com.upgrad.FoodOrderingApp.service.exception.CustomerNotFoundException;
import com.upgrad.FoodOrderingApp.service.exception.SignOutRestrictedException;
import com.upgrad.FoodOrderingApp.service.exception.SignUpRestrictedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {

  /**
   * SignUpRestrictedException handler.
   *
   * @param exc     SignUpRestrictedException
   * @param request WebRequest
   * @return ErrorResponse
   */
  @ExceptionHandler(SignUpRestrictedException.class)
  public ResponseEntity<ErrorResponse> signupRestrictionException(SignUpRestrictedException exc,
      WebRequest request) {
    return new ResponseEntity<ErrorResponse>(
        new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.CONFLICT
    );
  }

  /**
   * AuthenticationFailedException handler.
   *
   * @param exc     AuthenticationFailedException
   * @param request WebRequest
   * @return ErrorResponse
   */
  @ExceptionHandler(AuthenticationFailedException.class)
  public ResponseEntity<ErrorResponse> authenticationFailedException(
      AuthenticationFailedException exc, WebRequest request) {
    return new ResponseEntity<ErrorResponse>(
        new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()),
        HttpStatus.UNAUTHORIZED
    );
  }

  /**
   * SignOutRestrictedException handler.
   *
   * @param exc     SignOutRestrictedException
   * @param request WebRequest
   * @return ErrorResponse
   */
  @ExceptionHandler(SignOutRestrictedException.class)
  public ResponseEntity<ErrorResponse> signoutRestrictedException(SignOutRestrictedException exc,
      WebRequest request) {
    return new ResponseEntity<ErrorResponse>(
        new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()),
        HttpStatus.UNAUTHORIZED
    );
  }


  /**
   * CustomerNotFoundException handler.
   *
   * @param exc     CustomerNotFoundException
   * @param request WebRequest
   * @return ErrorResponse
   */
  @ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<ErrorResponse> userNotFoundException(CustomerNotFoundException exc,
      WebRequest request) {
    return new ResponseEntity<ErrorResponse>(
        new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.NOT_FOUND
    );
  }

  /**
   * AuthorizationFailedException handler.
   *
   * @param exc     AuthorizationFailedException
   * @param request WebRequest
   * @return ErrorResponse
   */
  @ExceptionHandler(AuthorizationFailedException.class)
  public ResponseEntity<ErrorResponse> authorizationFailedException(
      AuthorizationFailedException exc, WebRequest request) {
    return new ResponseEntity<ErrorResponse>(
        new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.FORBIDDEN
    );
  }


}