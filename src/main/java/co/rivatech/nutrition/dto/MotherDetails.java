package co.rivatech.nutrition.dto;

import co.rivatech.nutrition.enums.MotherHigherEducation;
import co.rivatech.nutrition.enums.MotherMaritalStatus;
import lombok.Data;

/**
 * @author vranjan
 * created 11/09/2021
 */
@Data
public class MotherDetails {
    private MotherHigherEducation higherEducation;

    private String higherEducationHindi;

    private int ageAtFirstBirth;

    private Boolean isAnaemic;

    private MotherMaritalStatus motherMaritalStatus;

    private String maritalStatusHindi;

    private Boolean midDayMealBenefit;

    private int totalKids;

    private int totalKidsUpTo60Months;

    private Boolean PMVY;

}
