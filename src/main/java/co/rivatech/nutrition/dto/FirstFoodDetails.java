package co.rivatech.nutrition.dto;

import java.util.List;

import co.rivatech.nutrition.enums.FirstFood;
import co.rivatech.nutrition.enums.FirstWater;
import co.rivatech.nutrition.enums.FirstWaterReason;
import co.rivatech.nutrition.enums.Vaccination;
import lombok.Data;

/**
 * @author vranjan
 * created 11/09/2021
 */
@Data
public class FirstFoodDetails {
    private FirstWater firstWater;

    private String firstWaterHindi;

    private FirstWaterReason firstWaterReason;

    private String firstWaterReasonHindi;

    private FirstFood firstFood;

    private String firstFoodHindi;

    private List<Vaccination> vaccinations;

    private List<String> vaccinationsHindi;
}
