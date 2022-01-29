package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.Village;
import co.rivatech.nutrition.repository.VillageRepository;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Service
public class VillageService {

    @Autowired
    private VillageRepository villageRepository;

    //@Cacheable("villages")
    public List<Village> getAllVillages() {
        List<Village> panchayats = new ArrayList<>();
        Iterable<Village> items = villageRepository.findAll();
        items.forEach(panchayats::add);
        return panchayats;
    }

    public Village addVillage(final Village village) {
        villageRepository.save(village);
        return village;
    }

    public List<Village> getAllVillagesByPanchayatId(final int panchayatId) {
        final List<Village> villages =  villageRepository.findVillageByPanchayatId(panchayatId);
        if(villages.isEmpty()) {
            throw new ResourceNotFoundException(String.format("No village found with panchayat id %s", panchayatId));
        }
        return villages;
    }
}
