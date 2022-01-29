package co.rivatech.nutrition.service;

import co.rivatech.nutrition.dto.UploadImageResponse;
import co.rivatech.nutrition.enums.MEALTYPE;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static co.rivatech.nutrition.resource.PhotoResource.S3_PREFIX;

/**
 * @author vranjan
 * created 19/09/2021
 */
@Service
@Slf4j
public class AWSS3Service {
    private static final String DIV = "/";
    private static final DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("uuuu/MM/dd");
    private static final String NOTICES = "notices";

    @Value("${app.awsServices.bucketName}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    public UploadImageResponse uploadFile(final MultipartFile file, int tolaId, MEALTYPE mealtype) {
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = dtfDate.format(LocalDate.ofInstant(Instant.now(),
                ZoneId.systemDefault()));
        s3Client.putObject(new PutObjectRequest(bucketName + DIV + tolaId + DIV + mealtype, fileName, fileObj));
        fileObj.delete();
        return new UploadImageResponse(fileName, tolaId, mealtype);
    }

    private File convertMultiPartFileToFile(final MultipartFile file) {
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }

    public String uploadFile(final MultipartFile file) {
        File fileObj = convertMultiPartFileToFile(file);
        final String fileName = String.valueOf(System.currentTimeMillis());
        s3Client.putObject(new PutObjectRequest(bucketName + DIV + NOTICES, fileName, fileObj));
        fileObj.delete();
        return S3_PREFIX + DIV + NOTICES + DIV + fileName;
    }

    public boolean urlExists(final String url) {
        URL imageUrl;
        try {
            imageUrl = new URL(url);
            HttpURLConnection huc = (HttpURLConnection) imageUrl.openConnection();
            int responseCode = huc.getResponseCode();
            return responseCode == 200;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
