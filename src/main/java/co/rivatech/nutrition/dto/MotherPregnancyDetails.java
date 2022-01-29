package co.rivatech.nutrition.dto;

import lombok.Data;

/**
 * @author vranjan
 * created 11/09/2021
 */
@Data
public class MotherPregnancyDetails {
    private Boolean isPregnant;

    private Boolean ANCBenefits;

    private Boolean isAnaemic;

    private String haemoglobin;
}
