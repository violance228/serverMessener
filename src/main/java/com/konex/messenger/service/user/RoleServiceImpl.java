package com.konex.messenger.service.user;

import com.konex.messenger.entity.user.Role;
import com.konex.messenger.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepositry;

    @Override
    public List<Role> findAll() {
        return roleRepositry.findAll();
    }

    @Override
    public List<Role> findAll(Specification specification) {
        return null;
    }

    @Override
    public Role findById(Long id) {
        return roleRepositry.getOne(id);
    }

    @Override
    public void delete(Long id) {
        roleRepositry.deleteById(id);
    }

    @Override
    public void save(Role role) {
        roleRepositry.save(role);
    }

    @Override
    public void update(Role role) {

    }

    @Override
    public void saveList(List<Role> elementList) {

    }

    @Override
    public Stream<Role> streamAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
