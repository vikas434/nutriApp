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
 * created 29/08/2021
 */
@Data
@Entity(name = "notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(value = "Notice id")
    private int id;

    @Column(name = "title")
    @ApiModelProperty(value = "title",
            required = true)
    private String title;

    @Column(name = "content")
    @ApiModelProperty(value = "content",
            notes = "in HTML formatted value",
            required = true)
    private String content;

    @Column(name = "image")
    @ApiModelProperty(value = "image",
            notes = "Uploaded image url or default image")
    private String image;

    @Column(name = "created_at")
    @ApiModelProperty(value = "createdAt")
    private Date createdAt = new Date();

    @ApiModelProperty(value = "User id of the person adding the notice",
            required = true)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "enabled")
    @ApiModelProperty(value = "enabled", notes = "default true")
    private boolean enabled = true;

    @ApiModelProperty(value = "forDistrict", notes = "default true")
    @Column(name = "for_district")
    private boolean forDistrict = true;

    @ApiModelProperty(value = "forBlock",
            notes = "default true")
    @Column(name = "for_block")
    private boolean forBlock = true;

    @ApiModelProperty(value = "forAnganwadi",
            notes = "default true")
    @Column(name = "for_anganwadi")
    private boolean forAnganwadi = true;

    @ApiModelProperty(value = "forSurveyor",
            notes = "default true")
    @Column(name = "for_surveyor")
    private boolean forSurveyor = true;
}
