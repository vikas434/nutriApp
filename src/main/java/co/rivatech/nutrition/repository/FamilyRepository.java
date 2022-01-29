package co.rivatech.nutrition.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import co.rivatech.nutrition.model.Family;

/**
 * @author vranjan
 * created 09/08/2021
 */
@Repository
public interface FamilyRepository extends PagingAndSortingRepository<Family, Integer> {
    Optional<Family> findTopByOrderByIdDesc();

    Optional<Family> findByMobile(final BigInteger mobile);

    Optional<Family> findById(final int id);

    Optional<Family> findByFamilyId(final String familyId);

    List<Family> findByNameHindiContaining(final String nameHindi);

    List<Family> findByNameContaining(final String familyHead);

    //List<Family> findByNameContainingOrNameHindiContaining(final String name);
}