package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.District;
import co.rivatech.nutrition.repository.DistrictRepository;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    //@Cacheable("districts")
    public List<District> getAllDistricts() {
        List<District> districts = new ArrayList<>();
        Iterable<District> items = districtRepository.findAll();
        items.forEach(districts::add);
        return districts;
    }

    public District addDistrict(final District district) {
        districtRepository.save(district);
        return district;
    }

    public District getDistrictById(final int districtId) {
        return districtRepository.findById(districtId).orElseThrow(() -> new ResourceNotFoundException(String.format("No district found with id %s ", districtId)));
    }
}
