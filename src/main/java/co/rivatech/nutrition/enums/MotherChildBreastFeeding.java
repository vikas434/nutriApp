package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 11/09/2021
 */
public enum MotherChildBreastFeeding {
    ONE_HOUR("१ घंटा"),
    ONE_DAY("१ दिन"),
    THREE_DAY("३ दिन"),
    MORE_THAN_THREE_DAY("३ दिन से ज्यादा"),
    NO_BREAST_FEEDING("स्तनपान हुआ ही नहीं");
    private String hindiString;

    MotherChildBreastFeeding(String hindiString) {

        this.hindiString = hindiString;
    }

    public static String valueOf(final MotherChildBreastFeeding motherChildBreastFeeding) {
        return motherChildBreastFeeding.hindiString;
    }

}
