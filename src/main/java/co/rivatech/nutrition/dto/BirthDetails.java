package co.rivatech.nutrition.dto;

import co.rivatech.nutrition.enums.DeliveryType;
import co.rivatech.nutrition.enums.PlaceOfBirth;
import lombok.Data;

/**
 * @author vranjan
 * created 11/09/2021
 */
@Data
public class BirthDetails {
    private PlaceOfBirth placeOfBirth;

    private String placeOfBirthHindi;

    private DeliveryType deliveryType;

    private String deliveryTypeHindi;
}
