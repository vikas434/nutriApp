package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.Woman;
import co.rivatech.nutrition.model.WomanDetailsWithFamilyName;
import co.rivatech.nutrition.service.WomanService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * created 18/08/2021
 */
@RestController
@RequestMapping("/v1/woman")
public class WomanResource {

    @Autowired
    private WomanService womanService;

    @PostMapping("/add")
    @ApiOperation(value = "Adds a woman to the family")
    public Woman addWoman(@Nonnull @RequestBody Woman woman) {
        return womanService.addWoman(woman);
    }

    @PostMapping("/add_details")
    @ApiOperation(value = "Adds woman details to the family")
    public WomanDetailsWithFamilyName addWomanDetails(@Nonnull @RequestBody WomanDetailsWithFamilyName womanDetails) {
        return womanService.addWomanDetails(womanDetails);
    }

    @GetMapping("/getByFamilyId/{familyId}")
    @ApiOperation(value = "Gets details of the woman by familyId, e.g. ")
    public List<Woman> getWomanByFamilyId(@Nonnull @PathVariable int familyId) {
    return womanService.getWomanByFamilyId(familyId);
    }
}
