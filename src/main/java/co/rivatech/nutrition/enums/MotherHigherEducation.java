package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 11/09/2021
 */
public enum MotherHigherEducation {
    EIGHTH("आठवीं"),
    TENTH("दसवीं"),
    TWELTH("बारहवीं"),
    GRADUATE("स्नातक");

    private String hindiString;

    MotherHigherEducation(String hindiString) {

        this.hindiString = hindiString;
    }

    public static String valueOf(final MotherHigherEducation higherEducation) {
        return higherEducation.hindiString;
    }
}
