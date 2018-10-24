//package com.konex.messenger.auth;
//
//import com.konex.messenger.entity.user.User;
//
///**
// * created by user violence
// * created on 19.10.2018
// * class created for project messenger
// */
//
//
//public class CurrentUser extends org.springframework.security.core.userdetails.User {
//
//
//    private final User user;
//
//    public CurrentUser(User user) {
//
//        super(user.getUsername(),
//                user.getPassword(),
//                user.getAuthorities());
//
//        this.user = user;
//    }
//
//    public User getFromUser() {
//        return user;
//    }
//
//    public Long getId() {
//        return user.getId();
//    }
//
//
//}
