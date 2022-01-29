package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import co.rivatech.nutrition.model.User;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {

    Optional<User> findByMobile(BigInteger mobile);

    //TODO change string to enum
    List<User> findByRoleEqualsAndAndBlockId(final String role, final int blockId);

    List<User> findByRoleEqualsAndAndDistrictId(final String role, final int blockId);

    List<User> findByRoleEquals(final String role);

    List<User> findByAnganwadiNameContainingIgnoreCase(final String name);

    List<User> findByAnganwadiNameHindiContaining(final String hindiName);

    List<User> findByNameContainingIgnoreCase(final String name);

    List<User> findByNameHindiContaining(final String hindiName);

    List<User> findByDistrictNameContainingIgnoreCase(final String name);

    List<User> findByBlockNameContainingIgnoreCase(final String name);

}
