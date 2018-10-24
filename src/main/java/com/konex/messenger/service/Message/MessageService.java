package com.konex.messenger.service.Message;

import com.konex.messenger.entity.user.Message;
import com.konex.messenger.entity.user.User;
import com.konex.messenger.service.BaseMethods;

import java.util.List;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */


public interface MessageService extends BaseMethods<Message> {
    List<Message> getAllMessageWithUser(Long forUser, Long fromUser);
}
