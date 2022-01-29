package co.rivatech.nutrition.exception;

/**
 * @author vranjan
 * created 26/08/2021
 */
public class MobileAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MobileAlreadyExistsException(String message) {
        super(message);
    }
}
