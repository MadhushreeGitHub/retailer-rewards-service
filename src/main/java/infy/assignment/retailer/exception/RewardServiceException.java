package infy.assignment.retailer.exception;

public class RewardServiceException extends Exception {
  private static final long serialVersionUID = 1L;

  public RewardServiceException(String message) {
    super(message);
  }

  public RewardServiceException(String message, Throwable cause) {
    super(message, cause);
  }

}
