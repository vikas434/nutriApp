package co.rivatech.nutrition.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import co.rivatech.nutrition.dto.FamilyDetails;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author vranjan
 * created 08/08/2021
 *
 * CREATE TABLE family (
 *     id SERIAL PRIMARY KEY,
 *     family_id character varying UNIQUE,
 *     name character varying,
 *     name_hi character varying,
 *     age integer,
 *     mobile bigint,
 *     district_id SERIAL REFERENCES district(id),
 *     block_id SERIAL REFERENCES block(id),
 *     panchayat_id SERIAL REFERENCES panchayat(id),
 *     village_id SERIAL REFERENCES village(id),
 *     created_at date DEFAULT CURRENT_DATE,
 *     updated_at date DEFAULT CURRENT_DATE,
 *     details_json json
 * );
 */
@Data
@Entity(name = "family")
@TypeDef(name = "jsonb",
         typeClass = JsonBinaryType.class)
public class Family extends FamilyFullDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "family_id")
    @ApiModelProperty(value = "Generated family id, no need to pass in param")
    private String familyId;

    @Column(name = "name")
    @ApiModelProperty(value = "name",
                      required = true)
    private String name;

    @Column(name = "name_hi")
    @ApiModelProperty(value = "name in hindi",
                      required = true)
    private String nameHindi;

    @Column(name = "age")
    @ApiModelProperty(value = "age",
                      required = true)
    private int age;

    @Column(name = "mobile")
    @ApiModelProperty(value = "mobile",
                      required = true)
    private BigInteger mobile;

    @Type(type = "jsonb")
    @Column(name = "details_json",
            columnDefinition = "jsonb")
    @ApiModelProperty(value = "details_json",
                      required = true)
    private FamilyDetails details;

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
