package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 11/09/2021
 */
public enum MotherChildFirstFood {
    MOTHER_MILK("माँ का दूध"),
    TRADITIONAL_FOOD("पारम्परिक खाना(शहद, चीनी, पानी)"),
    FIRST_BREAST_FEEDING("अन्य");

    private String hindiString;

    MotherChildFirstFood(String hindiString) {

        this.hindiString = hindiString;
    }

    public static String valueOf(final MotherChildFirstFood motherChildFirstFood) {
        return motherChildFirstFood.hindiString;
    }

}
