package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import co.rivatech.nutrition.constatnts.DateUtil;
import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.Family;
import co.rivatech.nutrition.model.Woman;
import co.rivatech.nutrition.model.WomanDetailsWithFamilyName;
import co.rivatech.nutrition.repository.FamilyRepository;
import co.rivatech.nutrition.repository.WomanDetailsRepository;
import co.rivatech.nutrition.repository.WomanRepository;

/**
 * @author vranjan
 * created 18/08/2021
 */
@Service
public class WomanService {

    @Autowired
    private WomanRepository womanRepository;

    @Autowired
    private WomanDetailsRepository womanDetailsRepository;

    @Autowired
    private FamilyRepository familyRepository;

    public Woman addWoman(final Woman woman) {
        return womanRepository.save(woman);
    }

    public void addAllWomen(final List<Woman> women) {
        womanRepository.saveAll(women);
    }

    public List<Woman> getWomanByFamilyId(final int familyId) {
        final List<Woman> woman = womanRepository.findByFamilyId(familyId);
        if (woman.isEmpty()) {
            throw new ResourceNotFoundException(String.format("No woman details found for family id %s", familyId));
        }
        return woman;
    }

    public WomanDetailsWithFamilyName addWomanDetails(final WomanDetailsWithFamilyName womanDetails) {
        final WomanDetailsWithFamilyName womanDetailsWithFamilyName = womanDetailsRepository.save(womanDetails);
        final Date dob = womanDetailsWithFamilyName.getWomanDetailsJson().getDob();
        womanDetailsWithFamilyName.setDobFormatted(DateUtil.getFormat().format(dob));
        final Optional<Family> familyOptional = familyRepository.findById(womanDetails.getFamilyId());
        familyOptional.ifPresent(family -> womanDetailsWithFamilyName.setFullFamilyId(family.getFamilyId()));
        return womanDetailsWithFamilyName;
    }

    public List<WomanDetailsWithFamilyName> getWomanDetailsByFamilyId(final int familyId) {
        return womanDetailsRepository.findByFamilyId(familyId);
    }

}
