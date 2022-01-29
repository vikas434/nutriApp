package co.rivatech.nutrition.model;

import java.math.BigInteger;
import java.util.Date;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author vranjan
 * created 07/08/2021
 * <p>
 * CREATE TABLE users (
 * id SERIAL PRIMARY KEY,
 * email character varying,
 * mobile bigint,
 * created_at date DEFAULT CURRENT_DATE,
 * updated_at date DEFAULT CURRENT_DATE,
 * name character varying,
 * name_hi character varying
 * );
 */
@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(value = "User Id")
    private int id;

    @Column(name = "email")
    @ApiModelProperty(value = "Email id of the user")
    private String email;

    @ApiModelProperty(value = "mobile the user",
            required = true)
    @Column(name = "mobile")
    private BigInteger mobile;

    @Column(name = "created_at")
    private Date createdAt = new Date();

    @Column(name = "updated_at")
    private Date updatedAt = new Date();

    @ApiModelProperty(value = "Name of the user",
            required = true)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "Name of the user in hindi",
            required = true)
    @Column(name = "name_hi")
    private String nameHindi;

    @ApiModelProperty(value = "ROLE_SUPER_ADMIN,\n" +
            "    ROLE_DISTRICT,\n" +
            "    ROLE_BLOCK,\n" +
            "    ROLE_ANGANWADI,\n" +
            "    ROLE_SURVEYOR",
            required = true)
    @Column(name = "role")
    private String role;


    @ApiModelProperty(value = "District attached to the user, else pass null",
            required = true)
    @Column(name = "district_id")
    @Nullable
    private Integer districtId;

    @ApiModelProperty(value = "Name of the district, e.g. Jhajhhar, ")
    @Column(name = "district_name")
    private String districtName;

    @ApiModelProperty(value = "Block attached to the user, else pass null")
    @Column(name = "block_id")
    @Nullable
    private Integer blockId;

    @ApiModelProperty(value = "Name of the block ")
    @Column(name = "block_name")
    private String blockName;

    @ApiModelProperty(value = "panchayat attached to the user, else pass null")
    @Column(name = "panchayat_id")
    @Nullable
    private Integer panchayatId;

    @ApiModelProperty(value = "Name of the panchayat")
    @Column(name = "panchayat_name")
    private String panchayatName;

    @ApiModelProperty(value = "village attached to the user, else pass null")
    @Column(name = "village_id")
    @Nullable
    private Integer villageId;

    @ApiModelProperty(value = "Name of the village")
    @Column(name = "village_name")
    private String villageName;

    @ApiModelProperty(value = "Anganwadi attached to the user(for surveyor and anganwadi user), else pass null")
    @Column(name = "tola_id")
    @Nullable
    private Integer tolaId;

    @ApiModelProperty(value = "Name of the anganwadi, e.g. jhargram, " +
            "it will be null for every users except anganwadi")
    @Column(name = "anganwadi_name")
    private String anganwadiName;

    @ApiModelProperty(value = "Name of the anganwadi in hindi" +
            "can be null too")
    @Column(name = "anganwadi_name_hi")
    private String anganwadiNameHindi;

}
