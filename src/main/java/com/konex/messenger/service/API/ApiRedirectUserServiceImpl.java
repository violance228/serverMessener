package com.konex.messenger.service.API;

import com.konex.messenger.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * created by user violence
 * created on 19.10.2018
 * class created for project messenger
 */

@Service
public class ApiRedirectUserServiceImpl implements ApiRedirectUserService {

    @Autowired
    private ApiRedirectService apiRedirectService;

    private RestTemplate template = new RestTemplate();

    @Override
    public String getUserByLoginOrMobile(String loginOrMobile) throws Exception {
        String url=Constants.REDIRECT_URL + "/redirection/api/user/konex/findUserByPartUserNameOrMobile?nameOrMobile=" + loginOrMobile;
        String result=null;
        result=apiRedirectService.send_get_request(url);
        return result;
    }

    @Override
    public String updateUserById(Long id) throws Exception {
        String url=Constants.REDIRECT_URL + "/redirection/api/user/konex/updateById/" + id;
        String result=null;
        result=apiRedirectService.send_get_request(url);
        return result;
    }
}
