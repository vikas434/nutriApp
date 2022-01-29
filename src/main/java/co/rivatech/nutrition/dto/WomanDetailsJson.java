package co.rivatech.nutrition.dto;

import java.util.Date;

import lombok.Data;

/**
 * @author vranjan
 * created 11/09/2021
 */
@Data
public class WomanDetailsJson {
    private Date dob;

    private MotherDetails motherDetails;

    private MotherBornChildDetails motherBornChildDetails;

    private MotherPensionDetails motherPensionDetails;

    private MotherPregnancyDetails pregnancyDetails;

}
