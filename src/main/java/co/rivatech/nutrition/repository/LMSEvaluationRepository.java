package co.rivatech.nutrition.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import co.rivatech.nutrition.model.LMSEvaluation;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Repository
public interface LMSEvaluationRepository extends PagingAndSortingRepository<LMSEvaluation, Integer> {

    List<LMSEvaluation> findByUserId(final int userId);

    List<LMSEvaluation> findByLmsIdAndUserId(final int lmsId, final int userId);
}
