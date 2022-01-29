package co.rivatech.nutrition.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import co.rivatech.nutrition.dto.Finance;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author vranjan
 * created 08/08/2021
 *
 *
 */
@Data
@Entity(name = "financial_details")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class FinancialDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "family_id")
    @ApiModelProperty(value = "familyId", required = true)
    private int familyId;


    @Type(type = "jsonb")
    @Column(name = "details_json", columnDefinition = "jsonb")
    @ApiModelProperty(value = "details_json",
                      required = true)
    private Finance details;

    @Column(name = "created_at")
    @ApiModelProperty(value = "createdAt")
    private Date createdAt = new Date();

    @Column(name = "updated_at")
    @ApiModelProperty(value = "updatedAt")
    private Date updatedAt;

    @ApiModelProperty(value = "User id of the surveyor/anganwadi",
                      required = true)
    @Column(name = "user_id")
    private int userId;
}
