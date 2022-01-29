package co.rivatech.nutrition.exception;

/**
 * @author vranjan
 * created 04/12/2021
 */
public class InvalidResourceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidResourceException(String message) {
        super(message);
    }
}
