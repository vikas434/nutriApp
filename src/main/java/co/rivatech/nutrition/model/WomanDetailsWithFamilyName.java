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

import co.rivatech.nutrition.dto.WomanDetailsJson;
import co.rivatech.nutrition.dto.DetailsWithFamilyName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author vranjan
 * created 11/09/2021
 */
@Data
@Entity(name = "woman_details")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class WomanDetailsWithFamilyName extends DetailsWithFamilyName {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(value = "Woman details Id")
    private int id;

    @Column(name = "woman_id")
    @ApiModelProperty(value = "woman id", required = true)
    private int womanId;

    @Column(name = "family_id")
    @ApiModelProperty(value = "Family id", required = true)
    private int familyId;

    @Type(type = "jsonb")
    @Column(name = "woman_details", columnDefinition = "jsonb")
    @ApiModelProperty(value = "Woman details like kids, anaemic etc.", required = true)
    private WomanDetailsJson womanDetailsJson;

    @JsonIgnore
    @Column(name = "created_at")
    private Date createdAt = new Date();

    @ApiModelProperty(value = "User id of the surveyor/anganwadi",
                      required = true)
    @Column(name = "user_id")
    private int userId;
}
