package com.konex.messenger.repository;

import com.konex.messenger.entity.user.Message;
import com.konex.messenger.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */


public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> getAllByUserAndForUserOrderByWasSentAsc(User fromUser, Long forUser);
//    List<Message> getAllByForUserAndUserOrderByWasSentAsc( Long forUser, User fromUser);
}