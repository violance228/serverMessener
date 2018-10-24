package com.konex.messenger.repository;

import com.konex.messenger.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */


public interface RoleRepository extends JpaRepository<Role, Long> {
}
