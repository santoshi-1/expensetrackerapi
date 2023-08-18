package com.santoshi.expensetrackerapi.controller;

import com.santoshi.expensetrackerapi.entity.AuthModal;
import com.santoshi.expensetrackerapi.entity.JWTResponse;
import com.santoshi.expensetrackerapi.entity.User;
import com.santoshi.expensetrackerapi.entity.UserModal;
import com.santoshi.expensetrackerapi.security.CustomUserDetailsService;
import com.santoshi.expensetrackerapi.service.UserService;
import com.santoshi.expensetrackerapi.util.JwtTokenUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login(@RequestBody AuthModal authModal) throws Exception {
        authenticate(authModal.getEmail(), authModal.getPassword());
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authModal.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new ResponseEntity<JWTResponse>(new JWTResponse(token), HttpStatus.OK);
    }

    public void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException exception) {
            throw new Exception("User Disabled!");
        } catch (BadCredentialsException exception) {
            throw new Exception("Bad Credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserModal userModal) {
        return new ResponseEntity<User>(userService.registerUser(userModal), HttpStatus.CREATED);
    }

}
