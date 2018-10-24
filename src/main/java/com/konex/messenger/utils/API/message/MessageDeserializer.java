package com.konex.messenger.utils.API.message;

import com.google.gson.*;
import com.konex.messenger.entity.user.Message;
import com.konex.messenger.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * created by user violence
 * created on 24.10.2018
 * class created for project messenger
 */

@Service
public class MessageDeserializer implements JsonDeserializer<Message> {

    @Autowired
    private UserService userService;

    @Override
    public Message deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Message message = new Message();

        message.setUser(userService.findById(jsonObject.get("from_user_id").getAsLong()));
        message.setForUser(jsonObject.get("for_user").getAsLong());
        message.setWasSent(new Date(jsonObject.get("date_send").getAsLong()));
        message.setText(jsonObject.get("message").getAsString());

        return message;
    }
}
