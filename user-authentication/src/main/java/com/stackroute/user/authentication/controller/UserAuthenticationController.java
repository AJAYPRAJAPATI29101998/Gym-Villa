package com.stackroute.user.authentication.controller;

import com.stackroute.user.authentication.entity.UserAuthentication;

import com.stackroute.user.authentication.service.JwtUserDetailsService;
import com.stackroute.user.authentication.service.UserAuthenticationService;
import com.stackroute.user.authentication.utill.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class UserAuthenticationController {

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserAuthenticationService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/registration")
    public ResponseEntity<UserAuthentication> addUser(@RequestBody UserAuthentication user) {

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user").toUriString());
        return ResponseEntity.created(uri).body(userDetailsService.addUser(user));
    }




    @GetMapping("/users")
    public ResponseEntity<List<UserAuthentication>> getallusers() {

        return ResponseEntity.ok().body(userDetailsService.getAllUsers());
    }



   // @RequestMapping(value = "/authenticate", method = RequestMethod.POST)


    @PostMapping("/authenticate")
    private String authenticate(@RequestBody UserAuthentication userAuthentication) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userAuthentication.getEmailId(), userAuthentication.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtTokenUtil.generateToken(userAuthentication.getEmailId());
    }
}
