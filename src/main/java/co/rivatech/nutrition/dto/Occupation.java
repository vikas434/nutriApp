package co.rivatech.nutrition.dto;

import co.rivatech.nutrition.enums.MemberWorkingOut;
import co.rivatech.nutrition.enums.RationColor;
import co.rivatech.nutrition.enums.WorkDuration;
import co.rivatech.nutrition.enums.WorkLocation;
import lombok.Data;

/**
 * @author vranjan
 * created 22/08/2021
 */
@Data
public class Occupation {
    private Boolean havingRationCard;

    private RationColor rationCardColor;

    private String rationCardColorHindi;

    private Boolean havingAgriLand;

    private Boolean havingMnregaCard;

    private Boolean havingWork;

    private Boolean goingOutToWork;

    private WorkLocation workLocation;

    private String workLocationHindi;

    private WorkDuration workDuration;

    private String workDurationHindi;

    private Boolean SHGConnection;

    private MemberWorkingOut memberWorkingOut;

    private String memberWorkingOutHindi;
}
