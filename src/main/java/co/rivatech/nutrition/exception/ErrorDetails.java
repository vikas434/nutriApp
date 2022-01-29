package co.rivatech.nutrition.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author vranjan
 * created 09/08/2021
 */
@AllArgsConstructor
@Data
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String messageHindi;
    private String details;
}
