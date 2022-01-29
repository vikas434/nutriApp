package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import co.rivatech.nutrition.model.Panchayat;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Repository
public interface PanchayatRepository extends CrudRepository<Panchayat, Integer> {

    List<Panchayat> findPanchayatByBlockId(final int districtId);
}
