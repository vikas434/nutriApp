package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import co.rivatech.nutrition.model.Block;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Repository
public interface BlockRepository extends CrudRepository<Block, Integer> {

    List<Block> findByDistrictId(final int districtId);
}
