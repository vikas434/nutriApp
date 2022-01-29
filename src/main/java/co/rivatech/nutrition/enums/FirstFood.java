package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 11/09/2021
 */
public enum FirstFood {
    BEFORE_3_MONTH("३ माह से पहले"),
    THREE_SIX_MONTH("३-६ माह"),
    SEVEN_TWELVE_MONTH("७-१२ माह"),
    AFTER_TWELVE_MONTH("१२ माह के बाद");

    private String hindiString;

    FirstFood(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final FirstFood firstFood) {
        return firstFood.hindiString;
    }

}
