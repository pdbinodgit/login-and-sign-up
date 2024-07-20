package com.loginandsignup.loginandsinup.user.service;

import com.loginandsignup.loginandsinup.customresponse.Response;
import com.loginandsignup.loginandsinup.user.model.UserInformation;
import org.springframework.http.ResponseEntity;

public interface UserInformationService {

    public ResponseEntity<Response<?>> saveUserInformation(UserInformation information);

    public ResponseEntity<Response<?>> getAllUser();
}
