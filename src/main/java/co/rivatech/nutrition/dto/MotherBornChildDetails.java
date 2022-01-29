package co.rivatech.nutrition.dto;

import co.rivatech.nutrition.enums.MotherChildBreastFeeding;
import co.rivatech.nutrition.enums.MotherChildFirstFood;
import lombok.Data;

/**
 * @author vranjan
 * created 11/09/2021
 */
@Data
public class MotherBornChildDetails {
    private MotherChildFirstFood motherChildFirstFood;

    private String motherChildFirstFoodHindi;

    private MotherChildBreastFeeding motherChildBreastFeeding;

    private String motherChildBreastFeedingHindi;

    private Boolean firstYellowMilk;

}
