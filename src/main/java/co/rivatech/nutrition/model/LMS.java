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
@Entity(name = "lms")
public class LMS {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "title")
    @ApiModelProperty(value = "Title of the LMS", required = true)
    private String title;

    @Column(name = "short_description")
    @ApiModelProperty(value = "Short description of the LMS", required = true)
    private String shortDescription;

    @Column(name = "video_url")
    @ApiModelProperty(value = "Video URL of the LMS", required = true,
            notes = "Please share youtube URL")
    private String videoUrl;

    @Column(name = "thumbnail_url")
    @ApiModelProperty(value = "Thumbnail URL of the LMS, taken from youtube", required = true)
    private String thumbnailUrl;

    @Column(name = "created_at")
    private Date createdAt = new Date();

}
