package co.rivatech.nutrition.model;

import co.rivatech.nutrition.dto.Options;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Question {
    @ApiModelProperty(value = "Question no.",
            required = true)
    private int questionNo;

    @ApiModelProperty(value = "Question title",
            required = true)
    private String questionTitle;

    @ApiModelProperty(value = "options for the question",
            required = true)
    private Options options;

    @ApiModelProperty(value = "Right option for the question",
            required = true)
    private int rightOption;

    @ApiModelProperty(value = "maximum marks of the question",
            required = true)
    private int marks;

}
