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
 * CREATE TABLE panchayat (
 *     id SERIAL PRIMARY KEY,
 *     district_id SERIAL REFERENCES district(id),
 *     block_id SERIAL REFERENCES block(id),
 *     name character varying,
 *     name_hi character varying,
 *     created_at date DEFAULT CURRENT_DATE
 * );
 */
@Data
@Entity(name = "panchayat")
public class Panchayat {

    @Id
    @GeneratedValue
    @ApiModelProperty(value = "Panchayat id")
    private int id;

    @Column(name = "district_id")
    @ApiModelProperty(value = "District Id", required = true)
    private int districtId;

    @Column(name = "block_id")
    @ApiModelProperty(value = "Block Id", required = true)
    private int blockId;

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
