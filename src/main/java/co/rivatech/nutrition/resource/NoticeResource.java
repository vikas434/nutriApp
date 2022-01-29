package co.rivatech.nutrition.resource;

import co.rivatech.nutrition.enums.SortBy;
import co.rivatech.nutrition.service.AWSS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.Notice;
import co.rivatech.nutrition.service.NoticeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author vranjan
 * created 29/08/2021
 */
@RestController
@RequestMapping("/v1/notice")
public class NoticeResource {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private AWSS3Service awss3Service;

    @PostMapping("/uploadNoticeImage")
    @ApiOperation(value = "Upload Notice image", notes = "Use this API first to get the notice image link" +
            "and use this link to upload image.")
    public String uploadNoticeImage(@RequestParam(value = "file") MultipartFile file) {
        return awss3Service.uploadFile(file);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add notice details")
    public Notice addNotice(@Nonnull @RequestBody Notice notice) {
        return noticeService.save(notice);
    }

    @GetMapping("/getNotice")
    @ApiOperation(value = "Currently it returns all the notices, later on we may need to divide based on district etc.")
    public List<Notice> getNotice(@RequestParam(defaultValue = "0") Integer pageNo,
                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                  @RequestParam(defaultValue = "id") String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Notice> pagedResult = noticeService.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return Collections.emptyList();
        }
    }

    @GetMapping("/getNoticeForRole/{role}")
    @ApiOperation(value = "Get notice for role. Role type can be " +
            "ROLE_SUPER_ADMIN," +
            "            \"    ROLE_DISTRICT," +
            "            \"    ROLE_BLOCK," +
            "            \"    ROLE_ANGANWADI," +
            "            \"    ROLE_SURVEYOR\"")
    public List<Notice> getNoticesForRole(@PathVariable @Nonnull String role, @RequestParam SortBy sortBy ) {
        return noticeService.getNoticeByRole(role, sortBy);
    }

    @GetMapping("/findNoticeByTitleKeyword/{keyword}")
    @ApiOperation(value = "Get notice by title")
    public List<Notice> findNoticeByTitleKeyword(@PathVariable @Nonnull String keyword) {
        return noticeService.findNoticeByTitleKeyword(keyword);
    }

    @DeleteMapping("/deleteById/{noticeId}")
    @ApiOperation(value = "Delete notice by id.",
            notes = "Successfully deletes notice data or throws exception")
    public ResponseEntity<?> deleteByFamilyId(@PathVariable int noticeId) {
        noticeService.deleteById(noticeId);
        return ResponseEntity.ok().build();
    }


}
