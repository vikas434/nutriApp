package co.rivatech.nutrition.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vranjan
 * @created 28/07/2021
 *
 * id SERIAL PRIMARY KEY,
 *     name character varying,
 *     name_hi character varying,
 *     short_name character varying,
 *     created_at date DEFAULT CURRENT_DATE
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(value = "District Id")
    private int id;

    @Column(name = "name")
    @ApiModelProperty(value = "District name" , required = true)
    private String name;

    @Column(name = "name_hi")
    @ApiModelProperty(value = "District name in hindi" , required = true)
    private String nameHindi;

    @Column(name = "short_name")
    @ApiModelProperty(value = "Short name for abbrevivaton. This has to be unique." , required = true)
    private String shortName;

    @Column(name = "created_at")
    @ApiModelProperty(value = "Created at")
    private Date createdAt = new Date();
}
