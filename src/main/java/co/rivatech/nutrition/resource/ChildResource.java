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

import co.rivatech.nutrition.model.Child;
import co.rivatech.nutrition.model.ChildDetails;
import co.rivatech.nutrition.service.ChildService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * created 18/08/2021
 */
@RestController
@RequestMapping("/v1/child")
public class ChildResource {

    @Autowired
    private ChildService childService;

    @PostMapping("/add")
    @ApiOperation(value = "Adds a child to the family")
    public Child addChild(@Nonnull @RequestBody Child child) {
        return childService.addChild(child);
    }

    @PostMapping("/add_details")
    @ApiOperation(value = "Adds a child details to the family")
    public ChildDetails addChildDetails(@Nonnull @RequestBody ChildDetails childDetails) {
        return childService.addChildDetails(childDetails);
    }

    //Update children

    @GetMapping("/getByFamilyId/{familyId}")
    @ApiOperation(value = "Gets details of the child by familyId, e.g. ")
    public List<Child> getChildByFamilyId(@Nonnull @PathVariable int familyId) {
    return childService.getChildByFamilyId(familyId);
    }
}
