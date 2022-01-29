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
 * created 08/08/2021
 *
 * CREATE TABLE tola (
 *     id SERIAL PRIMARY KEY,
 *     district_id SERIAL REFERENCES district(id),
 *     block_id SERIAL REFERENCES block(id),
 *     panchayat_id SERIAL REFERENCES panchayat(id),
 *     village_id integer REFERENCES village(id),
 *     name character varying,
 *     name_hi character varying,
 *     short_name character varying,
 *     created_at date DEFAULT CURRENT_DATE
 * );
 */
@Data
@Entity(name = "tola")
public class Tola {

    @Id
    @GeneratedValue
    @ApiModelProperty(value = " id")
    private int id;

    @Column(name = "district_id")
    @ApiModelProperty(value = "District Id", required = true)
    private int districtId;

    @Column(name = "block_id")
    @ApiModelProperty(value = "Block Id", required = true)
    private int blockId;

    @Column(name = "panchayat_id")
    @ApiModelProperty(value = "Panchayat Id", required = true)
    private int panchayatId;

    @Column(name = "village_id")
    @ApiModelProperty(value = "Village Id", required = true)
    private int villageId;

    @ApiModelProperty(value = "Name", required = true)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "Name in hindi", required = true)
    @Column(name = "name_hi")
    private String nameHindi;

    @Column(name = "short_name")
    @ApiModelProperty(value = "Short name for abbrevivaton. This has to be unique." , required = true)
    private String shortName;

    @ApiModelProperty(value = "Created at time")
    @Column(name = "created_at")
    private Date createdAt = new Date();
}
