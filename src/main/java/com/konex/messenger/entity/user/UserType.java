//package com.konex.messenger.entity.user;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.konex.messenger.entity.DomainObject;
//
//import javax.persistence.*;
//import java.util.Set;
//
///**
// * created by user violence
// * created on 18.10.2018
// * class created for project messengerServer
// */
//
//@Entity
//@Table(name = "Users_type")
//public class UserType implements DomainObject {
//
//    @Id
//    @Column(name = "user_type_id")
//    @SequenceGenerator(name = "users_type_seq", sequenceName = "users_type_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_type_seq")
//    private Long id;
//
//    @Column(name = "user_type_name", unique = true)
//    private String name;
//
//    @JsonIgnore
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userType")
//    private Set<User> userSet;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Set<User> getUserSet() {
//        return userSet;
//    }
//
//    public void setUserSet(Set<User> userSet) {
//        this.userSet = userSet;
//    }
//
//    @Override
//    public String toString() {
//        return "UserType{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
