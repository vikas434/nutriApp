package co.rivatech.nutrition.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author vranjan
 * created 09/08/2021
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceAlreadyExistsException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
