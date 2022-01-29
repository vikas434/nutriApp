package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 11/09/2021
 */
public enum PlaceOfBirth {
    HOSPITAL("अस्पताल"),
    HOME("घर में");


    private String hindiString;


    PlaceOfBirth(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final PlaceOfBirth placeOfBirth) {
        return placeOfBirth.hindiString;
    }
}
