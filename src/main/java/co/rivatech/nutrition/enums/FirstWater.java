package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 11/09/2021
 */
public enum FirstWater {
    FIRST_HOUR("एक घंटा"),
    FIRST_SIX_MONTH("१-६ माह"),
    SEVEN_TWELEVE_MONTH("७-१२ माह"),
    NOT_YET("अभी तक नहीं दिए हैं");

    private String hindiString;

    FirstWater(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final FirstWater firstWater) {
        return firstWater.hindiString;
    }
}
