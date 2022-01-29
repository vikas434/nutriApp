package co.rivatech.nutrition.exception;

public class UserDataMissingException extends RuntimeException {
    public UserDataMissingException(String message) {
        super(message);
    }
}
