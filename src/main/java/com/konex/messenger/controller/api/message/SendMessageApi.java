package com.konex.messenger.controller.api.message;

import com.konex.messenger.entity.user.Message;
import com.konex.messenger.entity.user.User;
import com.konex.messenger.service.Message.MessageService;
import com.konex.messenger.service.user.UserService;
import com.konex.messenger.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */

@Controller
@RequestMapping(value = "/api/send_message")
public class SendMessageApi {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    public @ResponseBody
    ResponseEntity sendMessUser(HttpSession session,
                                @RequestParam(name = "forUser") Long forUserId,
                                @RequestBody String strMessage) {
        String result = "send";
        Long fromUserId = (Long) session.getAttribute("currUserId") ;
        Message message = createMessage(strMessage, fromUserId, forUserId);
        messageService.save(message);

        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/all_users")
    public @ResponseBody
    ResponseEntity sendMessAllUser(@RequestParam(name = "message") String strMessage,
                                    HttpSession session) {

        String result = "send";
        Long fromUserId = (Long)session.getAttribute("currUserId");

        Message message = createMessage(strMessage, fromUserId, Constants.SEND_TO_ALL);
        messageService.save(message);

        return ResponseEntity.ok(result);
    }

    public Message createMessage(String strMessage, Long fromUserId, Long forUserId) {

        Message message = new Message(strMessage, new Date(), forUserId);
        message.setUser(userService.findById(fromUserId));

        return message;
    }
}
