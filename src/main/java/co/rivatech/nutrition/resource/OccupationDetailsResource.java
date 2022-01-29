package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.OccupationDetails;
import co.rivatech.nutrition.service.OccupationDetailsService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * @created 08/08/2021
 */
@RestController
@RequestMapping("/v1/occupation")
public class OccupationDetailsResource {

    @Autowired
    private OccupationDetailsService occupationDetailsService;


    @GetMapping("/findOccupationByFamilyId/{familyId}")
    @ApiOperation(value = "Get details of location or throw exception")
    public OccupationDetails getOccupationByFamilyId(@Nonnull @PathVariable int familyId) {
        return occupationDetailsService.getOccupationByFamilyId(familyId);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add a occupation details to a family.")
    public OccupationDetails addOccupationDetails(@Nonnull @RequestBody OccupationDetails occupationDetails) {
        return occupationDetailsService.save(occupationDetails);
    }

}
