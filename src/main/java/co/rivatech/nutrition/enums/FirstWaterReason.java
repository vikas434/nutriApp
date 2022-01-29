package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 11/09/2021
 */
public enum FirstWaterReason {
    MOTHER_SICK("माँ बीमार थी"),
    FAMILY_TRADITION("पारिवारिक परंपरा"),
    DOCTORS_ADVICE("चिकित्सक की सलाह"),
    NO_MOHTER_MILK("माँ का दूध उपलब्ध नहीं");


    private String hindiString;

    FirstWaterReason(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final FirstWaterReason firstWaterReason) {
        return firstWaterReason.hindiString;
    }

    }
