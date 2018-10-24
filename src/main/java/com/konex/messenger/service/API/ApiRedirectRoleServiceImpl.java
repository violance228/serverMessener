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
public class ApiRedirectRoleServiceImpl implements ApiRedirectRoleService {

    @Autowired
    private ApiRedirectService apiRedirectService;

    private RestTemplate template = new RestTemplate();

    @Override
    public String getAllPharmRole() {
        String result="";
        String url= Constants.REDIRECT_URL + "/redirection/api/role/konex/getAllPharmRole";
        //String url= "http://localhost:8080/api/role/konex/getAllPharmRole";
        result=apiRedirectService.send_get_request(url);
        return result;
    }

}
