package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.rivatech.nutrition.model.DailyAttendence;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Repository
public interface AttendenceRepository extends CrudRepository<DailyAttendence, Integer> {

    DailyAttendence findTopByOrderByIdDesc();
}
