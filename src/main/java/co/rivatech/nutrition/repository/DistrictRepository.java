package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.rivatech.nutrition.model.District;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Repository
public interface DistrictRepository extends CrudRepository<District, Integer> {

}
