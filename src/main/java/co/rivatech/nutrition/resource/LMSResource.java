package co.rivatech.nutrition.resource;

import co.rivatech.nutrition.model.LMS;
import co.rivatech.nutrition.model.LMSEvaluation;
import co.rivatech.nutrition.model.LMSQnA;
import co.rivatech.nutrition.service.LMSService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author vranjan
 * created 29/08/2021
 */
@RestController
@RequestMapping("/v1/lms")
public class LMSResource {

    @Autowired
    private LMSService lmsService;


    @PostMapping("/add")
    @ApiOperation(value = "Add LMS details")
    public LMS addLMS(@Nonnull @RequestBody LMS lms) {
        return lmsService.addLMS(lms);
    }

    @GetMapping("/getLMS")
    @ApiOperation(value = "Currently it returns all the notices, later on we may need to divide based on district etc.")
    public List<LMS> getLMSData(@RequestParam(defaultValue = "0") Integer pageNo,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "id") String sortBy,
                                @RequestParam(required = false) String searchByTitle) {
        if (StringUtils.hasLength(searchByTitle)) {
            return lmsService.searchLMSByTitle(searchByTitle);
        }
        return lmsService.getPaginatedLMS(pageNo, pageSize, sortBy);
    }

    @GetMapping("/getLMSEvaluationForUser/{userId}")
    @ApiOperation(value = "It returns lms evaluation details for a user id.")
    public List<LMSEvaluation> getLMSData(@PathVariable int userId) {
        return lmsService.getLmsEvaluationsForAUser(userId);
    }

    @PostMapping("/addLMSEvaluationForUser")
    @ApiOperation(value = "It adds lms evaluation for a user")
    public LMSEvaluation addLMSEvaluation(@RequestBody LMSEvaluation lmsEvaluation) {
        return lmsService.saveLmsEvaluation(lmsEvaluation);
    }

    @PostMapping("/addLMSQnA")
    @ApiOperation(value = "It adds lms Qustion and answer for a given LMS")
    public LMSQnA addLMSQnA(@RequestBody LMSQnA lmsQnA, @RequestParam(required = false) boolean edit) {
        return lmsService.saveLmsQnA(lmsQnA, edit);
    }

    @GetMapping("/getLMSQnAByLmsId/{lmsId}")
    @ApiOperation(value = "Gets list of all LMS qustion and answer to be used for evaluation.")
    public LMSQnA getLmsQnAByLmsId(@PathVariable int lmsId) {
        return lmsService.geLMSQnAByLmsId(lmsId);
    }

    @GetMapping("/searchLMSByTitle/{keyword}")
    @ApiOperation(value = "Search LMS details by the title keyword.")
    public List<LMS> searchLMSByTitle(@Nonnull @PathVariable String keyword) {
        return lmsService.searchLMSByTitle(keyword);
    }

    @GetMapping("/getEvaluationDoneForLoggedInUser/{lmsId}/{userId}")
    @ApiOperation(value = "Get evaluation details for given lms id and user id.")
    public List<LMSEvaluation> isEvaluationDoneForLoggedInUser(@PathVariable int lmsId, @PathVariable int userId) {
        return lmsService.getByLmsIdAndUserId(lmsId, userId);
    }
}
