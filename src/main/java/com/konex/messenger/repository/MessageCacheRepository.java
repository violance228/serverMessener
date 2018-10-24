package com.konex.messenger.repository;

import com.konex.messenger.entity.MessageCache;
import com.konex.messenger.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */


public interface MessageCacheRepository extends JpaRepository<MessageCache, Long> {
    List<MessageCache> getAllByFromUserAndForUserOrderByWasSentAsc(User fromUser, Long forUser);
    List<MessageCache> getAllByForUserAndFromUserOrderByWasSentAsc( Long forUser, User fromUser);
}
