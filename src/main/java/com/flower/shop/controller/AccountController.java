package com.flower.shop.controller;

import com.flower.shop.entity.User;
import com.flower.shop.service.UserService;
import com.flower.shop.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;


/** 
 * @author kamal berriga
 *
 */
@RestController
@RequestMapping("account")
public class AccountController {

	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserDetailsService userDetailsService;

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        System.out.println(newUser);
        if (userService.find(newUser.getUsername()) != null) {
            logger.error("username Already exist " + newUser.getUsername());
            return new ResponseEntity(
                    new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
                    HttpStatus.CONFLICT);
        }
        newUser.setRole("USER");

        return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
    }


	@CrossOrigin
	@RequestMapping("/login")
	public Principal user(Principal principal) {
		logger.info("user logged "+principal);
		return principal;
	}

    @RequestMapping("/out")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        System.out.println("LOGOUT");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "ok";
    }

	
	
}
