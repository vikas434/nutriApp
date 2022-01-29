package co.rivatech.nutrition.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import co.rivatech.nutrition.dto.ChildDetailsJson;
import co.rivatech.nutrition.dto.DetailsWithFamilyName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author vranjan
 * created 18/08/2021
 *
 */
@Data
@Entity(name = "child_details")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ChildDetails extends DetailsWithFamilyName {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(value = "Child details Id")
    private int id;

    @Column(name = "child_id")
    @ApiModelProperty(value = "Child id", required = true)
    private int childId;

    @Column(name = "family_id")
    @ApiModelProperty(value = "Family id", required = true)
    private int familyId;

    @Type(type = "jsonb")
    @Column(name = "child_details", columnDefinition = "jsonb")
    @ApiModelProperty(value = "Child details like birth, nutrition etc.", required = true)
    private ChildDetailsJson childDetailsJson;

    @JsonIgnore
    @Column(name = "created_at")
    private Date createdAt = new Date();

    @ApiModelProperty(value = "User id of the surveyor/anganwadi",
                      required = true)
    @Column(name = "user_id")
    private int userId;

}
