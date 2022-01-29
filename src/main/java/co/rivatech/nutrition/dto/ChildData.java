package co.rivatech.nutrition.dto;

import co.rivatech.nutrition.enums.AttendanceStatus;
import lombok.Data;

/**
 * @author vranjan
 * created 29/08/2021
 */
@Data
public class ChildData {
    private String name;

    private String nameHindi;

    private int childId;

    private AttendanceStatus status;
}
