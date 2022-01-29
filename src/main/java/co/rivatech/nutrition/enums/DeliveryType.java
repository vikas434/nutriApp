package co.rivatech.nutrition.enums;

/**
 * @author vranjan
 * created 11/09/2021
 */
public enum DeliveryType {
    OPERATION("ऑपरेशन"),
    PRE_TERM_DELIVERY("pre टर्म डिलीवरी"),
    GENERAL_DELIVERY("सामान्य डिलीवरी ");

    private String hindiString;


    DeliveryType(String hindiString) {
        this.hindiString = hindiString;
    }

    public static String valueOf(final DeliveryType deliveryType) {
        return deliveryType.hindiString;
    }
}
