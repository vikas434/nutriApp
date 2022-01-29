package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 22/08/2021
 */
public enum RationColor {
    PINK("गुलाबी"),
    YELLOW("पीला"),
    WHITE("उजला"),
    GREEN("हरा");

    private String hindiString;

    RationColor(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final RationColor rationColor) {
        return rationColor.hindiString;
    }
}
