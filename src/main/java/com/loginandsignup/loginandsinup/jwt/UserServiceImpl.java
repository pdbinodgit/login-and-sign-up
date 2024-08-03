package com.loginandsignup.loginandsinup.jwt;

import com.loginandsignup.loginandsinup.user.model.UserInformation;
import com.loginandsignup.loginandsinup.user.repository.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    UserInformationRepository userInformationRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInformation user = userInformationRepository.findByUsername(username);
        UserDetails userDetails= (UserDetails) user;

        return userDetails;
    }
}*/
