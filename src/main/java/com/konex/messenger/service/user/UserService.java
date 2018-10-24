package com.konex.messenger.service.user;

import com.konex.messenger.entity.user.User;
import com.konex.messenger.service.BaseMethods;

import java.util.List;

/**
 * created by user violence
 * created on 19.10.2018
 * class created for project messenger
 */


public interface UserService extends BaseMethods<User> {

    User findUserByUsername(String name);
    User findUserByMobile(String mobile);
    List<User> findUserByListId(List<Long> longs);
}
