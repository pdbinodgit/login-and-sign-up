package com.loginandsignup.loginandsinup.user.controller;

import com.loginandsignup.loginandsinup.customresponse.Response;
import com.loginandsignup.loginandsinup.user.model.UserInformation;
import com.loginandsignup.loginandsinup.user.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userInformation")
public class UserInformationController {
    @Autowired
    UserInformationService userInformationService;

    @PostMapping("/saveUserInformation")
    public ResponseEntity<Response<?>> saveUserInformation(@RequestBody UserInformation information){
        return userInformationService.saveUserInformation(information);
    }


    @GetMapping("/getAllUserInformation")
    public ResponseEntity<Response<?>> getAllUserInformation(){
        return userInformationService.getAllUser();
    }
}
