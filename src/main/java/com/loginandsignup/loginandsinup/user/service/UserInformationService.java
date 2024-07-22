package com.loginandsignup.loginandsinup.user.service;

import com.loginandsignup.loginandsinup.customresponse.Response;
import com.loginandsignup.loginandsinup.user.model.UserInformation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserInformationService {

    public void saveUserInformation(UserInformation information);

    public List<UserInformation> getAllUser();
}
