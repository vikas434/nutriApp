package co.rivatech.nutrition.repository;

import co.rivatech.nutrition.model.LMSQnA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Repository
public interface LMSQnARepository extends CrudRepository<LMSQnA, Integer> {

    LMSQnA findByLmsId(int lmsId);
}
