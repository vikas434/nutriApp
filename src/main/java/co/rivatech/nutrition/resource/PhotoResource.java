package co.rivatech.nutrition.resource;

import co.rivatech.nutrition.dto.UploadImageResponse;
import co.rivatech.nutrition.enums.MEALTYPE;
import co.rivatech.nutrition.exception.NoPhotoFoundException;
import co.rivatech.nutrition.service.AWSS3Service;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Nonnull;

/**
 * @author vranjan
 * created 29/08/2021
 */
@RestController
@RequestMapping("/v1/photo")
public class PhotoResource {

    public static final String S3_PREFIX = "https://vatsalya-photo.s3.ap-south-1.amazonaws.com";
    private static final String SEPERATOR = "/";


    @Autowired
    private AWSS3Service awss3Service;

    @PostMapping("/beforeMeal")
    @ApiOperation(value = "Upload photo before meal.",
            notes = "Upload today's photo. Also, please pass the tola Id.")
    public UploadImageResponse uploadPhotoBeforeMeal(@RequestParam(value = "file") MultipartFile file,
                                                     @RequestParam(value = "tolaId") int tolaId) {
        return awss3Service.uploadFile(file, tolaId, MEALTYPE.BEFORE_MEAL);
    }

    @PostMapping("/duringMeal")
    @ApiOperation(value = "Upload photo before meal.",
            notes = "Upload today's photo. Also, please pass the tola Id.")
    public UploadImageResponse uploadPhotoAfterMeal(@RequestParam(value = "file") MultipartFile file,
                                                    @RequestParam(value = "tolaId") int tolaId) {
        return awss3Service.uploadFile(file, tolaId, MEALTYPE.AFTER_MEAL);
    }

    @GetMapping("/getPhotosByTolaAndDate/{tolaId}/{type}/{dateYear}/{dateMonth}/{dateDay}")
    @ApiOperation(value = "Get photo by anganwadi id date year e.g. 2021, date month e.g. 06, date day e.g. 12, type = BEFORE_MEAL/AFTER_MEAL, ")
    public String getListOfPhotos(@Nonnull @PathVariable int tolaId,
                                  @PathVariable String type,
                                  @PathVariable int dateYear,
                                  @PathVariable int dateMonth,
                                  @PathVariable int dateDay) {
        String dateDayString;
        String dateMonthString;

        if(dateDay < 10) {
            dateDayString = String.format("0%d", dateDay);
        } else {
            dateDayString = String.valueOf(dateDay);
        }

        if(dateMonth < 10) {
            dateMonthString = String.format("0%d", dateMonth);
        } else {
            dateMonthString = String.valueOf(dateMonth);
        }
        final String url = S3_PREFIX + SEPERATOR + tolaId + SEPERATOR + type + SEPERATOR + dateYear + SEPERATOR + dateMonthString + SEPERATOR + dateDayString;
        if (!awss3Service.urlExists(url)) {
            throw new NoPhotoFoundException("No photo found ");
        }
        return url;
    }
}
