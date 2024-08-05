package com.loginandsignup.loginandsinup.user.repository;

import com.loginandsignup.loginandsinup.user.model.UserInformation;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation,Long> {

    public UserInformation findByUsername(String username);
}
