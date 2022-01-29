package co.rivatech.nutrition.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import co.rivatech.nutrition.model.Notice;

/**
 * @author vranjan
 * created 09/08/2021
 */
@Repository
public interface NoticeRepository extends PagingAndSortingRepository<Notice, Integer> {

    List<Notice> findByEnabledTrueAndForDistrictTrueOrderByCreatedAtDesc();

    List<Notice> findByEnabledTrueAndForDistrictTrueOrderByCreatedAtAsc();

    List<Notice> findByEnabledTrueAndForBlockTrueOrderByCreatedAtDesc();

    List<Notice> findByEnabledTrueAndForBlockTrueOrderByCreatedAtAsc();

    List<Notice> findByEnabledTrueAndForAnganwadiTrueOrderByCreatedAtDesc();

    List<Notice> findByEnabledTrueAndForAnganwadiTrueOrderByCreatedAtAsc();

    List<Notice> findByEnabledTrueAndForSurveyorTrueOrderByCreatedAtDesc();

    List<Notice> findByEnabledTrueAndForSurveyorTrueOrderByCreatedAtAsc();

    List<Notice> findByEnabledTrueOrderByCreatedAtDesc();

    List<Notice> findByEnabledTrueOrderByCreatedAtAsc();

    List<Notice> findByTitleContainingIgnoreCase(final String title);

}