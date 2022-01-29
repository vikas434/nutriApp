package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 09/08/2021
 */
public enum Sex {
    MALE("पुरुष"),
    FEMALE("स्त्री");

    private String hindiString;

    Sex(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final Sex sex) {
        return sex.hindiString;
    }
}
