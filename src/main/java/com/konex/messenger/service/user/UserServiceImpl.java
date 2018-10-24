package com.konex.messenger.service.user;

import com.konex.messenger.entity.user.User;
import com.konex.messenger.repository.UserRepository;
import com.konex.messenger.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

/**
 * created by user violence
 * created on 19.10.2018
 * class created for project messenger
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAll(Specification specification) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void save(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void saveList(List<User> elementList) {
        userRepository.saveAll(elementList);
    }

    @Override
    public Stream<User> streamAll() {
        return findAll().stream();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public User findUserByUsername(String name) {
        return userRepository.getByUsername(name);
    }

    @Override
    public User findUserByMobile(String mobile) {
        return userRepository.getByMobile(mobile);
    }

    @Override
    public List<User> findUserByListId(List<Long> longs) {
        return userRepository.getAllById(longs);
    }

}
