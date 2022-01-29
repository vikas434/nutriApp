package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import co.rivatech.nutrition.model.Tola;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Repository
public interface TolaRepository extends CrudRepository<Tola, Integer> {

    List<Tola> findTolaByVillageId(final int villageId);
}
