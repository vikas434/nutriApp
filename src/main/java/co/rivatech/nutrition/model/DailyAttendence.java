package co.rivatech.nutrition.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import co.rivatech.nutrition.dto.ChildData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author vranjan
 * created 29/08/2021
 */
@Data
@Entity(name = "daily_attendence")
@TypeDef(name = "jsonb",
         typeClass = JsonBinaryType.class)
public class DailyAttendence {

    @Id
    @GeneratedValue
    @ApiModelProperty(value = "id")
    private BigInteger id;

    @Column(name = "date")
    @ApiModelProperty(value = "Today's date")
    private Date date;

    @Type(type = "jsonb")
    @Column(name = "student_data")
    @ApiModelProperty(value = "Student data")
    private List<ChildData> childDataList;

    @ApiModelProperty(value = "User id of the surveyor/anganwadi",
                      required = true)
    @Column(name = "user_id")
    private int userId;

}
