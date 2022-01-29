package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 22/08/2021
 */
public enum MemberWorkingOut {
    ADULT_MALE("सिर्फ वयस्क पुरुष"),
    ALL_ADULTS("सिर्फ वयस्क सदस्य"),
    ALL_MEMBERS("सभी सदस्य");

    private String hindiString;

    MemberWorkingOut(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final MemberWorkingOut memberWorkingOut) {
        return memberWorkingOut.hindiString;
    }
}
