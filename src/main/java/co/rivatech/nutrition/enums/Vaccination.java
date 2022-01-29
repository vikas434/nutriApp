package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 11/09/2021
 */
public enum Vaccination {
    BCG("BCG"),
    DPT_FIRST_BOOSTER("DPT First Booster"),
    DPT_16_24_MONTHS("DPT 16-24 months"),
    DPT_SECOND_BOOSTER("DPT second booster"),
    HEPATITIS("Hepatitis"),
    OPV_AT_BIRTH("OPV - at birth"),
    OPV_6_WEEKS("OPV - 6 weeks"),
    OPV_10_WEEKS("OPV - 10 weeks"),
    OPV_14_WEEKS("OPV - 14 weeks"),
    OPV_BOOSTER_16_24_MONTH("OPV Booster 16-24 monthS"),
    IPV_POLIO("IPV(Polio)"),
    PENTAVALENT_6_WEEKS("Pentavalent - 6 weeks"),
    PENTAVALENT_10_WEEKS("Pentavalent - 10 weeks"),
    PENTAVALENT_14_WEEKS("Pentavalent - 14 weeks"),
    ROTAVIRUS_6_WEEKS("Rotavirus - 6 weeks"),
    ROTAVIRUS_10_WEEKS("Rotavirus - 10 weeks"),
    ROTAVIRUS_14_WEEKS("Rotavirus - 14 weeks"),
    MEASLES("Measles"),
    MEASLES_2ND_DOSE("Measles 2nd Dose"),
    MEASLES_16_24_MONTHS("Measles 16-24 months"),
    VITAMIN_A_1_DOSE("Vitamin A 1st dose"),
    VITAMIN_A_2_DOSE("Vitamin A 2nd dose"),
    VITAMIN_A_3_DOSE("Vitamin A 3rd dose"),
    VITAMIN_A_4_DOSE("Vitamin A 4th dose"),
    VITAMIN_A_5_DOSE("Vitamin A 5th dose"),
    VITAMIN_A_6_DOSE("Vitamin A 6th dose"),
    VITAMIN_A_7_DOSE("Vitamin A 7th dose"),
    VITAMIN_A_8_DOSE("Vitamin A 8th dose"),
    VITAMIN_A_9_DOSE("Vitamin A 9th dose");

    private String hindiString;

    Vaccination(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final Vaccination vaccination) {
        return vaccination.hindiString;
    }

}
