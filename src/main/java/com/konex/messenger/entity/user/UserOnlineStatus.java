//package com.konex.messenger.entity.user;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.konex.messenger.entity.DomainObject;
//import lombok.NonNull;
//
//import javax.persistence.*;
//import java.util.Date;
//
///**
// * created by user violence
// * created on 18.10.2018
// * class created for project messengerServer
// */
//
//@Entity
//@Table(name = "users_online_status")
//public class UserOnlineStatus implements DomainObject {
//
//    @Id
//    @Column(name = "users_online_status")
//    @SequenceGenerator(name = "users_online_status_seq", sequenceName = "users_online_status_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_online_status_seq")
//    private Long id;
//
//
//    @Column(name = "is_active")
//    private boolean isActive;
//
//    @NonNull
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    @JsonManagedReference
//    private User user;
//}
