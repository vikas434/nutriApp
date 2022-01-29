package co.rivatech.nutrition.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @author vranjan
 * created 29/08/2021
 */
@Data
@Builder
@AllArgsConstructor
@Entity(name = "lms_qna")
public class LMSQnA {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "lms_id")
    @ApiModelProperty(value = "lms id", notes = "This is unique. No duplicate entry allowed", required = true)
    private int lmsId;

    @Column(name = "created_at")
    private Date createdAt = new Date();

    @ApiModelProperty(value = "User id of the surveyor/anganwadi", required = true)
    @Column(name = "user_id")
    private int userId;

    @Type(type = "jsonb")
    @Column(name = "questions", columnDefinition = "jsonb")
    @ApiModelProperty(value = "question list", required = true)
    private List<Question> questionList;

    public LMSQnA() {

    }
}
