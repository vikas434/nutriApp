package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import co.rivatech.nutrition.model.FinancialDetails;

/**
 * @author vranjan
 * created 19/08/2021
 */
@Repository
public interface FinanceDetailsRepository extends CrudRepository<FinancialDetails, Integer> {
    Optional<FinancialDetails> findByFamilyId(final int familyId);
}
