package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import co.rivatech.nutrition.model.Child;

/**
 * @author vranjan
 * created 18/08/2021
 */
@Repository
public interface ChildRepository extends CrudRepository<Child, Integer> {

    List<Child> findByFamilyId(final int familyId);

    List<Child> findByTolaId(final int tolaId);

    List<Child> findByNameContaining(final String name);

    List<Child> findByNameHindiContaining(final String name);

    List<Child> findByTolaIdAndId(final int tolaId, final int childId);

    List<Child> findByTolaIdAndNameContaining(final int tolaId, final String name);

    List<Child> findByTolaIdAndNameHindiContaining(final int tolaId, final String nameHindi);

}
