package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import co.rivatech.nutrition.model.LocationDetails;

/**
 * @author vranjan
 * created 19/08/2021
 */
@Repository
public interface LocationDetailsRepository extends CrudRepository<LocationDetails, Integer> {
    Optional<LocationDetails> findByFamilyId(final int familyId);
}
