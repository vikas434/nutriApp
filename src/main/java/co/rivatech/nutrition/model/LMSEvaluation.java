package co.rivatech.nutrition.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author vranjan
 * created 29/08/2021
 */
@Data
@Entity(name = "lms_evaluation")
public class LMSEvaluation extends LMSDetails {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "lms_id")
    @ApiModelProperty(value = "LMS Id, linked from LMS table",
                      required = true)
    private int lmsId;

    @Column(name = "status")
    @ApiModelProperty(value = "IN_PROGRESS or COMPLETED",
                      required = true)
    private String status;

    @Column(name = "marks")
    @ApiModelProperty(value = "Marks of the user if attempted or zero.",
                      required = true)
    private int marks;

    @Column(name = "user_id")
    @ApiModelProperty(value = "User id to update the score",
                      required = true)
    private Integer userId;

    @Column(name = "created_at")
    private Date createdAt = new Date();

}
