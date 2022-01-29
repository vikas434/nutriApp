package co.rivatech.nutrition.dto;

import lombok.Data;

/**
 * @author vranjan
 * created 19/08/2021
 */
@Data
public class Location {
    private String district;

    private String districtHindi;

    private String block;

    private String blockHindi;

    private String panchayat;

    private String panchayatHindi;

    private String village;

    private String villageHindi;

    private String tola;

    private String tolaHindi;
}
