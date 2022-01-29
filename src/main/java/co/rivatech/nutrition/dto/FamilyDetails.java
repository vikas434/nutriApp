package co.rivatech.nutrition.dto;

import java.io.Serializable;
import java.util.List;

import co.rivatech.nutrition.enums.Caste;
import co.rivatech.nutrition.enums.Religion;
import co.rivatech.nutrition.enums.Sex;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author vranjan
 * created 09/08/2021
 */
@Data
public class FamilyDetails implements Serializable {

    private Sex sex;

    private String sexHindi;

    private Caste caste;

    private String casteHindi;

    private Religion religion;

    private String religionHindi;

    private String otherReligion;

    private String otherReligionHindi;

    private int totalMembers;

    private int totalChildren;

    private int totalWomen;

    private int mamChild;

    private int anaemicWomen;

    @ApiModelProperty(value = "districtId",
                      required = true)
    private int districtId;

    @ApiModelProperty(value = "blockId",
                      required = true)
    private int blockId;

    @ApiModelProperty(value = "panchayatId",
                      required = true)
    private int panchayatId;

    @ApiModelProperty(value = "villageId",
                      required = true)
    private int villageId;

    private List<Children> childrenList;

    private List<Women> womenList;

    private Location location;

    private Occupation occupation;

    private Finance finance;

}
