package co.rivatech.nutrition.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

import co.rivatech.nutrition.constatnts.Constants;

/**
 * @author vranjan
 * created 09/08/2021
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFoundException exception, WebRequest request) {
        ErrorDetails errorDetails =
                new ErrorDetails(new Date(),
                        exception.getMessage(),
                        Constants.NOT_FOUND,
                        request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<?> resourceAlreadyExists(ResourceAlreadyExistsException exception, WebRequest request) {
        ErrorDetails errorDetails =
                new ErrorDetails(new Date(),
                        exception.getMessage(),
                        Constants.ALREADY_EXISTS,
                        request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MobileAlreadyExistsException.class)
    public ResponseEntity<?> MobileAlreadyExists(MobileAlreadyExistsException exception, WebRequest request) {
        ErrorDetails errorDetails =
                new ErrorDetails(new Date(),
                        exception.getMessage(),
                        Constants.ALREADY_EXISTS,
                        request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidResourceException.class)
    public ResponseEntity<?> InvalidResource(InvalidResourceException exception, WebRequest request) {
        ErrorDetails errorDetails =
                new ErrorDetails(new Date(),
                        exception.getMessage(),
                        Constants.ISSUE_IN_REQUEST,
                        request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> BadRequest(Exception exception, WebRequest request) {
        ErrorDetails errorDetails =
                new ErrorDetails(new Date(),
                        exception.getMessage(),
                        Constants.ISSUE_IN_REQUEST,
                        request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoPhotoFoundException.class)
    public ResponseEntity<?> PhotoRequest(Exception exception, WebRequest request) {
        ErrorDetails errorDetails =
                new ErrorDetails(new Date(),
                        exception.getMessage(),
                        Constants.NOT_FOUND,
                        request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoticeNotFoundException.class)
    public ResponseEntity<?> NoticeDelete(Exception exception, WebRequest request) {
        ErrorDetails errorDetails =
                new ErrorDetails(new Date(),
                        exception.getMessage(),
                        Constants.NOT_FOUND,
                        request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserDataMissingException.class)
    public ResponseEntity<?> UserDataMissing(Exception exception, WebRequest request) {
        ErrorDetails errorDetails =
                new ErrorDetails(new Date(),
                        exception.getMessage(),
                        Constants.ISSUE_IN_REQUEST,
                        request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
