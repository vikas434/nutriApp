package co.rivatech.nutrition.resource;

import co.rivatech.nutrition.model.User;
import co.rivatech.nutrition.service.UsersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nonnull;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

/**
 * @author vranjan
 * created 07/08/2021
 */
@RestController
@RequestMapping("/v1/users")
public class UsersResource {

    @Autowired
    private UsersService usersService;

    @GetMapping("/")
    @ApiOperation(value = "Get all users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add/update a system user")
    public ResponseEntity<User> addSystemUser(@Nonnull @RequestBody User user) {
        return ResponseEntity.ok(usersService.addUser(user));
    }

    @GetMapping("/findByMobile/{mobile}")
    @ApiOperation(value = "Returns user details by mobile number or else throw 404.")
    public ResponseEntity<User> findByMobileNumber(@RequestParam BigInteger mobile) {
        return ResponseEntity.ok(usersService.findByMobile(mobile));
    }

    @DeleteMapping("/deleteById/{userId}")
    @ApiOperation(value = "Delete user by id.",
            notes = "Successfully deletes user data or throws exception")
    public ResponseEntity<?> deleteByUserId(@PathVariable int userId) {
        usersService.deleteById(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/searchUserByName/{name}")
    @ApiOperation(value = "Returns user details of the user by its name in english.")
    public List<User> searchUserByName(@RequestParam @Nonnull String name) {
        return usersService.searchByUserName(name);
    }

    @GetMapping("/searchUserByNameHindi/{nameHindi}")
    @ApiOperation(value = "Returns user details of the user by its name in hindi.")
    public List<User> searchUserByNameHindi(@RequestParam @Nonnull String nameHindi) {
        return usersService.searchByUserNameHindi(nameHindi);
    }

    @GetMapping("/searchAnganwadiByName/{name}")
    @ApiOperation(value = "Returns user details of the anganwadi by its name in english.")
    public List<User> searchAnganwadiByName(@RequestParam @Nonnull String name) {
        return usersService.searchByAnganwadiName(name);
    }

    @GetMapping("/searchAnganwadiHindiByName/{nameHindi}")
    @ApiOperation(value = "Returns user details of the anganwadi by its name in hindi.")
    public List<User> searchAnganwadiHindiByName(@RequestParam @Nonnull String nameHindi) {
        return usersService.searchByAnganwadiNameHindi(nameHindi);
    }

    @GetMapping("/getAllDistrictUser")
    @ApiOperation(value = "Returns all district users")
    public List<User> getAllDistrictUsers() {
        return usersService.getAllDistrictUsers();
    }

    @GetMapping("/searchUserByParams")
    @ApiOperation(value = "Search users by different query params like mobile, name, district, block , anganwadi name")
    public List<User> getUserData(
            @RequestParam(required = false) BigInteger mobile,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String nameHindi,
            @RequestParam(required = false) String districtName,
            @RequestParam(required = false) String anganwadiName,
            @RequestParam(required = false) String anganwadiNameHindi,
            @RequestParam(required = false) String blockName,
            @RequestParam(required = false) String role) {
        if (null != mobile) {
            return Collections.singletonList(usersService.findByMobile(mobile));
        }

        if (StringUtils.hasLength(name)) {
            return usersService.searchByUserName(name);
        }

        if (StringUtils.hasLength(nameHindi)) {
            return usersService.searchByUserNameHindi(nameHindi);
        }

        if (StringUtils.hasLength(districtName)) {
            return usersService.searchByDistrictName(districtName);
        }

        if (StringUtils.hasLength(anganwadiName)) {
            return usersService.searchByAnganwadiName(anganwadiName);
        }

        if (StringUtils.hasLength(anganwadiNameHindi)) {
            return usersService.searchByAnganwadiNameHindi(anganwadiNameHindi);
        }

        if (StringUtils.hasLength(blockName)) {
            return usersService.searchByBlockName(blockName);
        }

        if (StringUtils.hasLength(role)) {
            return usersService.searchByRole(role);
        }

        return Collections.emptyList();
    }
}
