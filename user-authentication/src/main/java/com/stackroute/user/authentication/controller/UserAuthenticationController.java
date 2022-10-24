package com.stackroute.user.authentication.controller;

import com.stackroute.user.authentication.entity.Role;
import com.stackroute.user.authentication.entity.UserAuthentication;

import com.stackroute.user.authentication.exceptions.UserAlreadyExist;
import com.stackroute.user.authentication.exceptions.UsernameNotFoundException;
import com.stackroute.user.authentication.service.JwtUserDetailsService;
import com.stackroute.user.authentication.service.UserAuthenticationService;
import com.stackroute.user.authentication.utill.JwtUtil;
import io.jsonwebtoken.Jwts;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/User-authentication-service")
public class UserAuthenticationController {

    static final String TOKEN_PREFIX = "Bearer";
    static final String SECRET = "gymvilla";
    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserAuthenticationService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/registration")
    public ResponseEntity<UserAuthentication> addUser( @RequestBody @Valid  UserAuthentication user) throws UserAlreadyExist {

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user").toUriString());
        return ResponseEntity.created(uri).body(userDetailsService.addUser(user));
    }


        @PostMapping("/authenticate")
        private String authenticate (@RequestBody UserAuthentication userAuthentication) throws
        UsernameNotFoundException {
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(userAuthentication.getEmailId(), userAuthentication.getPassword())
                );
            } catch (Exception ex) {
                throw new UsernameNotFoundException("");
            }
            return jwtTokenUtil.generateToken(userAuthentication.getEmailId(),userAuthentication.getPassword());
        }
        @GetMapping("/details/{emilid}")
       public UserAuthentication gettingDetails(@PathVariable String emailid)
       {
           return userDetailsService.getUserData(emailid);
       }


    @Operation(summary = "Welcome user", description = "gettinfg role")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/gettingRole")
    public String gettingRole(HttpServletRequest httpServletRequest) throws UsernameNotFoundException {
        final String HEADER_STRING = "Authorization";
        String token = httpServletRequest.getHeader(HEADER_STRING);
        String user = null;
        Role rolevalue = null;

        if (token != null) {
            // parse the token.

            try {

                user = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody()
                        .getSubject();

              //  UserAuthentication userAuthentication=new UserAuthentication();
                  rolevalue= userDetailsService.getRole(user);


            } catch (Exception e) {
                throw e;
            }

        }

        return "Welcome to Gymvilla.Account is created as a "+rolevalue;
    }
}

