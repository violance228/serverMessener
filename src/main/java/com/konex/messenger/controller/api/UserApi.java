package com.konex.messenger.controller.api;

import com.konex.messenger.service.API.ApiRedirectUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import io.netty.handler.codec.http.HttpResponseStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * created by user violence
 * created on 19.10.2018
 * class created for project messenger
 */

@Controller
@SessionScope
@RequestMapping("/api/user")
public class UserApi {

    @Autowired
    private ApiRedirectUserService apiUserService;

    @RequestMapping("/findUserByPartUserNameOrMobile")
    public @ResponseBody
    String findUserByNameOrMobile(
            @RequestParam(value = "nameOrMobile", required = true) String nameOrMobile,
            HttpServletResponse response){

        String apiResult=null;
        try {
            apiResult = apiUserService.getUserByLoginOrMobile(nameOrMobile);
        }catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpResponseStatus.NOT_ACCEPTABLE.code());
        }

        return apiResult;
    }


}
