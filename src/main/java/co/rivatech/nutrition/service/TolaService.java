package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.Tola;
import co.rivatech.nutrition.repository.TolaRepository;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Service
public class TolaService {

    @Autowired
    private TolaRepository tolaRepository;

    //@Cacheable("tolas")
    public List<Tola> getAllTola() {
        List<Tola> tolas = new ArrayList<>();
        Iterable<Tola> items = tolaRepository.findAll();
        items.forEach(tolas::add);
        return tolas;
    }

    public Tola addTola(final Tola tola) {
        tolaRepository.save(tola);
        return tola;
    }

    public List<Tola> getAllTolasByVillageId(final int villageId) {
        final List<Tola> tolas = tolaRepository.findTolaByVillageId(villageId);
        if (tolas.isEmpty()) {
            throw new ResourceNotFoundException(String.format("No tola found with village id %s", villageId));
        }
        return tolas;
    }
}
