package co.rivatech.nutrition.dto;

import java.util.Date;

import co.rivatech.nutrition.enums.Sex;
import lombok.Data;

/**
 * @author vranjan
 * created 11/09/2021
 */
@Data
public class ChildDetailsJson {
    private Date dob;

    private int ageYears;

    private int ageMonths;

    private Sex sex;

    private String sexHindi;

    private int weight;

    private int height;

    private Boolean CMSSY; // Chief minisiter sukanya samridhi yojan

    private HealthDetails healthDetails;

    private BirthDetails birthDetails;

    private FirstFoodDetails firstFoodDetails;

    private ChildOtherDetails childOtherDetails;

}
