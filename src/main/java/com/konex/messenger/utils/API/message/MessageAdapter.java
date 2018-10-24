package com.konex.messenger.utils.API.message;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.konex.messenger.entity.user.Message;

import java.lang.reflect.Type;

/**
 * created by user violence
 * created on 24.10.2018
 * class created for project messenger
 */


public class MessageAdapter implements JsonSerializer<Message> {
    @Override
    public JsonElement serialize(Message message, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("from_user_id", message.getUser().getId());
        jsonObject.addProperty("for_user", message.getForUser());
        jsonObject.addProperty("date_send", message.getWasSent().getTime());
        if (message.getWasRead() != null) {
            jsonObject.addProperty("date_read", message.getWasRead().getTime());
        }
        jsonObject.addProperty("message", message.getText());
        return jsonObject;
    }
}
