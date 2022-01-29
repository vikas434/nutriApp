package co.rivatech.nutrition.dto;

import co.rivatech.nutrition.enums.MEALTYPE;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author vranjan
 * created 29/08/2021
 */
@Data
@AllArgsConstructor
public class UploadImageResponse {
    private String fileName;

    private int tolaId;

    private MEALTYPE mealtype;
}
