package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.Family;
import co.rivatech.nutrition.model.LocationDetails;
import co.rivatech.nutrition.repository.FamilyRepository;
import co.rivatech.nutrition.repository.LocationDetailsRepository;

/**
 * @author vranjan
 * created 19/08/2021
 */
@Service
public class LocationDetailsService {
    @Autowired
    private LocationDetailsRepository locationDetailsRepository;

    @Autowired
    private FamilyRepository familyRepository;

    public LocationDetails getLocationByFamilyId(final int familyId) {
        return locationDetailsRepository.findByFamilyId(familyId)
                                        .orElseThrow(() -> new ResourceNotFoundException(String.format(
                                                "No location details found for familyId %s",
                                                familyId)));
    }

    public LocationDetails save(final LocationDetails locationDetails) {
        return locationDetailsRepository.save(locationDetails);
    }

    public LocationDetails updateLocation(final LocationDetails locationDetails) {
        final LocationDetails details = locationDetailsRepository.save(locationDetails);
        Optional<Family> familyOptional = familyRepository.findById(locationDetails.getFamilyId());
        if(familyOptional.isPresent()) {
            final Family family = familyOptional.get();
            family.getDetails().setLocation(locationDetails.getDetails());
            familyRepository.save(family);
        }
        return details;
    }
}
