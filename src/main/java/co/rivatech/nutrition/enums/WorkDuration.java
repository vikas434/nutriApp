package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 22/08/2021
 */
public enum WorkDuration {
    LESS_THAN_THREE_MONTH("३ महीने से कम"),
    THREE_TO_SIX_MONTH("३-६ महीने"),
    MORE_THAN_SIX_MONTH("६ महीने से अधिक");

    private String hindiString;

    WorkDuration(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final WorkDuration workDuration) {
        return workDuration.hindiString;
    }
}
