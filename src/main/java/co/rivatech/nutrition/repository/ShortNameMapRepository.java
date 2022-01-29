package co.rivatech.nutrition.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import co.rivatech.nutrition.enums.Entity;

/**
 * @author vranjan
 * created 16/08/2021
 */
@Repository
public class ShortNameMapRepository {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private PanchayatRepository panchayatRepository;

    @Autowired
    private VillageRepository villageRepository;

    //@Cacheable("getShortNameMap")
    public Map<Entity, Map<Integer, String>> getShortNameMap() {
        final Map<Entity, Map<Integer, String>> shortNameMap = new HashMap<>();

        // District map.
        final Map<Integer, String> districtMap = new HashMap<>();
        districtRepository.findAll().forEach(i -> {
            districtMap.put(i.getId(), i.getShortName());
        });

        // Block Map
        final Map<Integer, String> blockMap = new HashMap<>();
        blockRepository.findAll().forEach(i -> {
            blockMap.put(i.getId(), i.getShortName());
        });

        // Panchayat Map
        final Map<Integer, String> panchayatMap = new HashMap<>();
        panchayatRepository.findAll().forEach(i -> {
            panchayatMap.put(i.getId(), i.getShortName());
        });

        // Village Map
        final Map<Integer, String> villageMap = new HashMap<>();
        villageRepository.findAll().forEach(i -> {
            villageMap.put(i.getId(), i.getShortName());
        });

        shortNameMap.put(Entity.DISTRICT, villageMap);
        shortNameMap.put(Entity.BLOCK, blockMap);
        shortNameMap.put(Entity.PANCHAYAT, panchayatMap);
        shortNameMap.put(Entity.VILLAGE, villageMap);
        return shortNameMap;
    }

}
