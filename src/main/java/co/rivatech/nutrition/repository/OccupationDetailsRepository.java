package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import co.rivatech.nutrition.model.OccupationDetails;

/**
 * @author vranjan
 * created 19/08/2021
 */
@Repository
public interface OccupationDetailsRepository extends CrudRepository<OccupationDetails, Integer> {
    Optional<OccupationDetails> findByFamilyId(final int familyId);
}
