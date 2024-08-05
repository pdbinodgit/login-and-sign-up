package com.loginandsignup.loginandsinup.jwt;

import com.loginandsignup.loginandsinup.customresponse.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
        @RequestMapping("/login")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;



    @PostMapping("/generateToken")
    public ResponseEntity<Response<?>> loginRequest(@RequestBody LoginRequest request){
        Authentication authentication;
        try {
            authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));

        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Response<>("Invalid username and password.",401,HttpStatus.UNAUTHORIZED,request));
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails= (UserDetails) authentication.getPrincipal();
        String jwtToken=jwtUtils.generateJwtTokenFromUserName(userDetails);

        return ResponseEntity.status(HttpStatus.OK).body(new Response<>("Success",200,HttpStatus.OK,request));

    }
}
