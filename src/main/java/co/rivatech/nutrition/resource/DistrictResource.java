package co.rivatech.nutrition.resource;

import co.rivatech.nutrition.model.User;
import co.rivatech.nutrition.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.District;
import co.rivatech.nutrition.service.DistrictService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * @created 28/07/2021
 */
@RestController
@RequestMapping("/v1/district")
public class DistrictResource {

    //TODO TDD based validations and exceptions

    @Autowired
    private DistrictService districtService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/")
    @ApiOperation(value = "Get lists of all the district")
    public List<District> getAllDistrict() {
        return districtService.getAllDistricts();
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "Find the district details by id.", notes = "Returns district details if found else 404.")
    public District getDistrictById(@Nonnull @PathVariable int id) {
        return districtService.getDistrictById(id);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add a district")
    public ResponseEntity<District> addDistrict(@Nonnull @RequestBody District district) {
        return ResponseEntity.ok(districtService.addDistrict(district));
    }

    @GetMapping("/blockUsers/{districtId}")
    @ApiOperation(value = "Get list of all the block users, tied to that district. ")
    public List<User> getListOfBlockUsersForADistrict(@Nonnull @PathVariable int districtId) {
        return usersService.getBlockUserByDistrict(districtId);
    }

}
