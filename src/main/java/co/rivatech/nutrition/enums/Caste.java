package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 02/09/2021
 */
public enum Caste {
    GENERAL("सामान्य"),
    OBC("पिछड़ी जाति"),
    SC("अनुसूचित जाति"),
    ST("अनुसूचित जनजाति"),
    PVTG("आदिम जनजाति");

    private String hindiString;

    Caste(String hindiString) {

        this.hindiString = hindiString;
    }

    public static String valueOf(final Caste caste) {
        return caste.hindiString;
    }
}
