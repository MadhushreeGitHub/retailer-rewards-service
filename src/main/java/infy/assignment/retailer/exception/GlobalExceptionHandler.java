package infy.assignment.retailer.exception;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<List<?>> handleIllegalArgumentException(IllegalArgumentException e) {
    System.err.println("Invalid argument: " + e.getMessage());
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<List<?>> handleGeneralException(Exception e) {
    System.err
        .println("An error occurred while calculating customer reward points: " + e.getMessage());
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(RewardServiceException.class)
  public ResponseEntity<List<?>> handleRewardServiceException(RewardServiceException e) {
    System.err.println("Reward service error: " + e.getMessage());
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
