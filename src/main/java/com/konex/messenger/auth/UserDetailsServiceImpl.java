//package com.konex.messenger.auth;
//
//import com.konex.messenger.entity.user.Role;
//import com.konex.messenger.entity.user.User;
//import com.konex.messenger.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * created by user violence
// * created on 19.10.2018
// * class created for project messenger
// */
//
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//
////    @Override
////    @Transactional(readOnly = true)
////    public UserDetails loadUserByUsername(String username) {
////        try {
////            User user = userDao.findByUsername(username);
////
////        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
////
////        for (Role role : user.getRoles()) {
////            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
////        }
////        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
//////                return new CurrentUser(user);
////        }catch (Exception e){
////            System.err.println("ERROR: User with username " + username + " was not found in DB by cause: " + e);
////            throw new UsernameNotFoundException("User with username " + username + " was not found in DB.");
////        }
////    }
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.getByUsername(username);
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//
//        for (Role role : user.getRoles()) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),
//                user.getPassword(), grantedAuthorities);
//    }
//}
