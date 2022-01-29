package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.OccupationDetails;
import co.rivatech.nutrition.repository.OccupationDetailsRepository;

/**
 * @author vranjan
 * created 19/08/2021
 */
@Service
public class OccupationDetailsService {
    @Autowired
    private OccupationDetailsRepository occupationDetailsRepository;

    public OccupationDetails getOccupationByFamilyId(final int familyId) {
        return occupationDetailsRepository.findByFamilyId(familyId)
                                          .orElseThrow(() -> new ResourceNotFoundException(String.format(
                                                "No Occupation details found for familyId %s",
                                                familyId)));
    }

    public OccupationDetails save(final OccupationDetails occupationDetails) {
        return occupationDetailsRepository.save(occupationDetails);
    }
}
