package org.example.service.models.registrationUserLogin;

import org.example.dto.models.L2.UserProfileDTOL2;
import org.example.model.UserLogin;

public interface RegistrationUserLoginService {
    UserProfileDTOL2 create(UserProfileDTOL2 userProfileDTOL22, UserLogin userLogin);

    UserProfileDTOL2 update(UserProfileDTOL2 userProfileDTOL22, UserLogin userLogin);
    UserProfileDTOL2 readById(UserProfileDTOL2 userProfileDTOL22, UserLogin userLogin);
}
