package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 11/09/2021
 */
public enum MotherMaritalStatus {
    UNMARRIED("अविवाहित"),
    MARRIED("विवाहित"),
    WIDOW("विधवा");
    private String hindiString;

    MotherMaritalStatus(String hindiString) {

        this.hindiString = hindiString;
    }

    public static String valueOf(final MotherMaritalStatus motherMaritalStatus) {
        return motherMaritalStatus.hindiString;
    }

}
