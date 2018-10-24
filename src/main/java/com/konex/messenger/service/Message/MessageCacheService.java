package com.konex.messenger.service.Message;

import com.konex.messenger.entity.MessageCache;
import com.konex.messenger.entity.user.User;
import com.konex.messenger.service.BaseMethods;

import java.util.List;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */


public interface MessageCacheService extends BaseMethods<MessageCache> {
    List<MessageCache> getAllByFromUserAndForUserOrderByWasSentAsc(User fromUser, Long forUser);
}
