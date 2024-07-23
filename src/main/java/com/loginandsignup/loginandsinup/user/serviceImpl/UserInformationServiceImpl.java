package com.loginandsignup.loginandsinup.user.serviceImpl;

import com.loginandsignup.loginandsinup.customexception.CustomException;
import com.loginandsignup.loginandsinup.customresponse.Response;
import com.loginandsignup.loginandsinup.user.model.UserInformation;
import com.loginandsignup.loginandsinup.user.repository.UserInformationRepository;
import com.loginandsignup.loginandsinup.user.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    UserInformationRepository userInformationRepository;

    @Override
    public void saveUserInformation(UserInformation information) {
        userInformationValidation(information);
        userInformationRepository.save(information);

    }

    private  void userInformationValidation(UserInformation information) {
        if (information.getUsername()!=null && information.getUsername().equals("")){
            throw new CustomException("Validation Error: The provided username must be null, but it is not.",HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
        }
        if (information.getPassword()!=null && information.getPassword().equals("")){
            throw new CustomException("Validation Error: The provided password must be null, but it is not.",HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<UserInformation> getAllUser() {
        return userInformationRepository.findAll();
    }
}
