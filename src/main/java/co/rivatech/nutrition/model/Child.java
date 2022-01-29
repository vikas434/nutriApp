package co.rivatech.nutrition.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Entity(name = "child")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(value = "Child Id")
    private int id;

    @Column(name = "family_id")
    @ApiModelProperty(value = "Family id", required = true)
    private int familyId;

    @Column(name = "tola_id")
    @ApiModelProperty(value = "Anganwadi id", required = true)
    private int tolaId;

    @JsonIgnore
    @Column(name = "created_at")
    private Date createdAt = new Date();

    @ApiModelProperty(value = "Name of the child", required = true)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "Name of the child in hindi", required = true)
    @Column(name = "name_hi")
    private String nameHindi;

    @ApiModelProperty(value = "User id of the surveyor/anganwadi",
                      required = true)
    @Column(name = "user_id")
    private int userId;
}
