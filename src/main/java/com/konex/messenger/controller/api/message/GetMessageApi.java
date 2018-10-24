package com.konex.messenger.controller.api.message;

import com.konex.messenger.entity.user.Message;
import com.konex.messenger.entity.user.User;
import com.konex.messenger.repository.UserRepository;
import com.konex.messenger.service.Message.MessageService;
import com.konex.messenger.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * created by user violence
 * created on 24.10.2018
 * class created for project messenger
 */

@Controller
@RequestMapping(value = "/api/get_message")
public class GetMessageApi {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    public @ResponseBody
    String sendMessUser(@RequestParam(name = "forUser") Long forUserId,
                                HttpSession session) {
        String result = "send";
        Long fromUserId = (Long) session.getAttribute("currUserId");
        messageService.getAllMessageWithUser(forUserId, fromUserId);

        return "";
    }
}
