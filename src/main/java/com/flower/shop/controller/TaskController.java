package com.flower.shop.controller;

import com.flower.shop.entity.User;
import com.flower.shop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final Logger log = LoggerFactory.getLogger(TaskController.class);
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public TaskController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.addUser(user);
    }


    @GetMapping("/principal")
    public String principal(Principal principal) {
        return principal.getName();
    }


}





