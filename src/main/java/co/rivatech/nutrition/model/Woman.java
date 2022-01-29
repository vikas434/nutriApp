package co.rivatech.nutrition.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author vranjan
 * created 18/08/2021
 *
 */
@Data
@Entity(name = "woman")
public class Woman {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(value = "Woman Id")
    private int id;

    @Column(name = "family_id")
    @ApiModelProperty(value = "Family id", required = true)
    private int familyId;

    @Column(name = "created_at")
    private Date createdAt = new Date();

    @ApiModelProperty(value = "Name of the woman", required = true)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "Name of the woman in hindi", required = true)
    @Column(name = "name_hi")
    private String nameHindi;

    @ApiModelProperty(value = "User id of the surveyor/anganwadi",
                      required = true)
    @Column(name = "user_id")
    private int userId;
}
