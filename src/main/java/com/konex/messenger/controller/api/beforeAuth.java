package com.konex.messenger.controller.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.konex.messenger.entity.user.User;
import com.konex.messenger.service.user.UserService;
import com.konex.messenger.utils.API.UsersAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */

@Controller
@RequestMapping("/beforeAuth")
public class beforeAuth {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginList")
    public @ResponseBody
    String getAllUser(){
        GsonBuilder g = new GsonBuilder();
        g.registerTypeAdapter(User.class, new UsersAdapter());
        List<User> userList = userService.findAll();
        Gson gson = g.create();
        String json = gson.toJson(userList);
        return json;
    }
}
