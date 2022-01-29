package co.rivatech.nutrition.resource;

import co.rivatech.nutrition.model.Child;
import co.rivatech.nutrition.model.DailyAttendence;
import co.rivatech.nutrition.service.AttendenceService;
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
@RequestMapping("/v1/attendence")
public class AttendenceResource {

    @Autowired
    private AttendenceService attendenceService;


    @PostMapping("/add")
    @ApiOperation(value = "Add a new attendance",
            notes = "The attendance value will be uploaded on daily basis")
    public DailyAttendence addAttendance(@Nonnull @RequestBody DailyAttendence dailyAttendence) {
        return attendenceService.save(dailyAttendence);
    }

    @GetMapping("/getTodayAttendenceStatus")
    @ApiOperation(value = "Gets status for todays attendence",
            notes = "This API can be useful to know, if the attendence" +
                    "is already submitted or not")
    public Boolean getTodaysAttendence() {
        return attendenceService.getTodaysAttendenceStatus();
    }

    @GetMapping("/getAttendenceList/{tolaId}")
    @ApiOperation(value = "Gets students details which are eligible for the attendence. Additional filters can be applied on child id, name and namehindi." +
            "Please note, only one of the param will work, not all 3")
    public List<Child> getStudentData(@PathVariable int tolaId,
                                      @RequestParam(required = false) Integer childId,
                                      @RequestParam(required = false) String name,
                                      @RequestParam(required = false) String nameHindi) {
        if (null != childId) {
            return attendenceService.getChildByTolaIdAndChildId(tolaId, childId);
        } else if (StringUtils.hasLength(name)) {
            return attendenceService.getChildByTolaIdAndNameContaining(tolaId, name);
        } else if (StringUtils.hasLength(nameHindi)) {
            return attendenceService.getChildByTolaIdAndNameContainingHindi(tolaId, nameHindi);
        }
        return attendenceService.getStudentData(tolaId);
    }

    @GetMapping("/getChildById/{id}")
    @ApiOperation(value = "Get child data by child id.")
    public Child getChildById(@PathVariable int id) {
        return attendenceService.getChildById(id);
    }

    @GetMapping("/getChildByName/{name}")
    @ApiOperation(value = "Get child data by child name.")
    public List<Child> getChildByName(@PathVariable String name) {
        return attendenceService.getChildByName(name);
    }

    @GetMapping("/getChildByName/{nameHindi}")
    @ApiOperation(value = "Get child data by child name.")
    public List<Child> getChildByNameHindi(@PathVariable String nameHindi) {
        return attendenceService.getChildByNameHindi(nameHindi);
    }
}
