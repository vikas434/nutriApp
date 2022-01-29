package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import co.rivatech.nutrition.model.ChildDetails;

/**
 * @author vranjan
 * created 18/08/2021
 */
@Repository
public interface ChildDetailsRepository extends CrudRepository<ChildDetails, Integer> {
    List<ChildDetails> findByFamilyId(int familyId);
}
