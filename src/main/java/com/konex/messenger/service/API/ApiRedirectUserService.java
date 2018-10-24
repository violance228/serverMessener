package com.konex.messenger.service.API;

/**
 * created by user violence
 * created on 19.10.2018
 * class created for project messenger
 */


public interface ApiRedirectUserService {

    String getUserByLoginOrMobile(String loginOrMobile) throws Exception;

    String updateUserById(Long id) throws Exception;
}
