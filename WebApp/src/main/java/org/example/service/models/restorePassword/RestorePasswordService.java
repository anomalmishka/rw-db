package org.example.service.models.restorePassword;

import org.example.dto.models.L2.UserProfileDTOL2;
import org.example.model.UserLogin;

public interface RestorePasswordService {
    UserLogin restorePassword(UserProfileDTOL2 userProfileDTOL22, UserLogin userLogin);
}
