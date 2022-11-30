package org.example.service.models.userProfileCustom;

import org.example.dto.models.L2.UserProfileDTOL2;

public interface UserProfileCustomService {
    UserProfileDTOL2 findWhereUserId(Long userId);

    UserProfileDTOL2 readUserProfile(String username);
}
