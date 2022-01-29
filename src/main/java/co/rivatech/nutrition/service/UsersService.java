package co.rivatech.nutrition.service;

import co.rivatech.nutrition.exception.MobileAlreadyExistsException;
import co.rivatech.nutrition.exception.UserDataMissingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import co.rivatech.nutrition.exception.InvalidResourceException;
import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.User;
import co.rivatech.nutrition.repository.UsersRepository;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Iterable<User> iterable = usersRepository.findAll();
        iterable.forEach(users::add);
        return users;
    }

    public User addUser(final User user) {
        if (null != user.getBlockId() && user.getBlockId() == 0
                || null != user.getDistrictId() && user.getDistrictId() == 0
                || null != user.getTolaId() && user.getTolaId() == 0) {
            throw new InvalidResourceException(
                    "One of the values of the user block,district or tola is passed as 0 which " +
                            "violate the foreign id constraint. Please pass null.");
        }
        final BigInteger mobileNo = user.getMobile();
        if (null == mobileNo) {
            throw new UserDataMissingException("Mobile number not passed for user");
        }
        if (usersRepository.findByMobile(mobileNo).isPresent()) {
            throw new MobileAlreadyExistsException(String.format("Mobile number already exists %s", user.getMobile()));
        }
        usersRepository.save(user);
        return user;
    }

    public User findByMobile(final BigInteger mobile) {
        return usersRepository.findByMobile(mobile)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(
                        "User not found with mobile number %s",
                        mobile)));
    }

    public void deleteById(final int userId) {
        usersRepository.deleteById(userId);
    }

    public List<User> getAnganwadiUsersByBlock(final int blockId) {
        return usersRepository.findByRoleEqualsAndAndBlockId("ROLE_ANGANWADI", blockId);
    }

    public List<User> getSurveyorUsersByBlock(final int blockId) {
        return usersRepository.findByRoleEqualsAndAndBlockId("ROLE_SURVEYOR", blockId);
    }

    public List<User> getBlockUserByDistrict(final int districtId) {
        return usersRepository.findByRoleEqualsAndAndDistrictId("ROLE_BLOCK", districtId);
    }

    public List<User> searchByAnganwadiName(final String name) {
        return usersRepository.findByAnganwadiNameContainingIgnoreCase(name);
    }

    public List<User> searchByAnganwadiNameHindi(final String name) {
        return usersRepository.findByAnganwadiNameHindiContaining(name);
    }

    public List<User> searchByUserName(final String name) {
        return usersRepository.findByNameContainingIgnoreCase(name);
    }

    public List<User> searchByUserNameHindi(final String nameHindi) {
        return usersRepository.findByNameHindiContaining(nameHindi);
    }

    public List<User> getAllDistrictUsers() {
        return usersRepository.findByRoleEquals("ROLE_DISTRICT");
    }

    public List<User> searchByDistrictName(final String districtName) {
        return usersRepository.findByDistrictNameContainingIgnoreCase(districtName);
    }

    public List<User> searchByBlockName(final String blockName) {
        return usersRepository.findByBlockNameContainingIgnoreCase(blockName);
    }

    public List<User> searchByRole(final String role) {
        return usersRepository.findByRoleEquals(role);
    }
}
