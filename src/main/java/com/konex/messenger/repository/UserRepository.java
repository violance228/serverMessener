package com.konex.messenger.repository;

import com.konex.messenger.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by user violence
 * created on 19.10.2018
 * class created for project messenger
 */


public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsername(String username);
    User getByMobile(String mobile);
    List<User> getAllById(List<Long> longs);
    List<User> findByUsernameIgnoreCaseOrMobile(String name, String mobile);
}
