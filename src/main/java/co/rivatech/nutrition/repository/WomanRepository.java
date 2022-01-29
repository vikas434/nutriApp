package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import co.rivatech.nutrition.model.Woman;

/**
 * @author vranjan
 * created 18/08/2021
 */
@Repository
public interface WomanRepository extends CrudRepository<Woman, Integer> {

    List<Woman> findByFamilyId(final int familyId);
}
