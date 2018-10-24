package com.konex.messenger.utils.API;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.konex.messenger.entity.user.User;

import java.lang.reflect.Type;

/**
 * created by user violence
 * created on 24.10.2018
 * class created for project messenger
 */


public class UsersAdapter implements JsonSerializer<User> {
    @Override
    public JsonElement serialize(User user, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("user_id", user.getId());
        jsonObject.addProperty("user_name", user.getPib());
        jsonObject.addProperty("user_login", user.getUsername());
        jsonObject.addProperty("user_mobile", user.getMobile());
        if (user.getLastActive() != null) {
            jsonObject.addProperty("user_last_active", user.getLastActive().getTime());
        }
        return jsonObject;
    }
}
