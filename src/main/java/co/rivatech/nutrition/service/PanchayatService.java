package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.Panchayat;
import co.rivatech.nutrition.repository.PanchayatRepository;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Service
public class PanchayatService {

    @Autowired
    private PanchayatRepository panchayatRepository;

    //@Cacheable("panchayats")
    public List<Panchayat> getAllPanchayats() {
        List<Panchayat> panchayats = new ArrayList<>();
        Iterable<Panchayat> items = panchayatRepository.findAll();
        items.forEach(panchayats::add);
        return panchayats;
    }

    public Panchayat addPanchayat(final Panchayat panchayat) {
        panchayatRepository.save(panchayat);
        return panchayat;
    }

    public Panchayat getPanchayatById(final int panchayatId) {
        return panchayatRepository.findById(panchayatId).orElseThrow(() ->new ResourceNotFoundException(String.format("No Panchayat found with panchayatId %s",
                                                                                                                 panchayatId)));
    }

    public List<Panchayat> findPanchayatByBlockId(final int blockId) {
        final List<Panchayat> panchayats = panchayatRepository.findPanchayatByBlockId(blockId);
        if (panchayats.isEmpty()) {
            throw new ResourceNotFoundException(String.format("No Panchayat found with block id %s",
                                                              blockId));
        }
        return panchayats;
    }
}
