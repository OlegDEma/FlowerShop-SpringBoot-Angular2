package com.flower.shop.service;


import com.flower.shop.repository.UsersRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UsersRepository userRepository;
    public UserDetailsServiceImpl(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.flower.shop.entity.User applicationUser = userRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println(username);
//        com.flower.shop.entity.User applicationUser = applicationUserRepository.findByUsername(username);
//        System.out.println(applicationUser);
//        String dBuserName = applicationUser.getUsername();
//        System.out.println(dBuserName);
//        if(dBuserName == null){
//            throw new UsernameNotFoundException("User not authorized.");
//        }
//
//        UserDetails userDetails = new User(dBuserName,
//                applicationUser.getPassword(), emptyList());
//        return userDetails;
//    }
}