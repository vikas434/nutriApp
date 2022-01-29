package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.LocationDetails;
import co.rivatech.nutrition.service.LocationDetailsService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * @created 08/08/2021
 */
@RestController
@RequestMapping("/v1/location")
public class LocationDetailsResource {

    @Autowired
    private LocationDetailsService locationDetailsService;


    @GetMapping("/findLocationByFamilyId/{familyId}")
    @ApiOperation(value = "Get details of location or throw exception")
    public LocationDetails getLocationByFamilyId(@Nonnull @PathVariable int familyId) {
        return locationDetailsService.getLocationByFamilyId(familyId);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add a location details to a family.")
    public LocationDetails addLocationDetails(@Nonnull @RequestBody LocationDetails locationDetails) {
        return locationDetailsService.save(locationDetails);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update location details to a family.")
    public LocationDetails updateLocationDetails(@Nonnull @RequestBody LocationDetails locationDetails) {
        return locationDetailsService.updateLocation(locationDetails);
    }

}
