package com.konex.messenger.service;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.stream.Stream;

/**
 * created by user violence
 * created on 19.10.2018
 * class created for project messenger
 */


public interface BaseMethods<T> {

    List<T> findAll();

    List<T> findAll(Specification specification);

    T findById(Long id);

    void delete(Long id);

    void save(T t);

    void update(T t);

    void saveList(List<T> elementList);

    Stream<T> streamAll();

    void deleteAll();
}
