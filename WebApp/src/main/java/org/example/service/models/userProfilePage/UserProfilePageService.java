package org.example.service.models.userProfilePage;

import org.example.dto.models.L2.UserProfileDTOL2;

import java.security.Principal;

public interface UserProfilePageService {
    UserProfileDTOL2 findWhereName(Principal principal);

    UserProfileDTOL2 updateProfile(UserProfileDTOL2 userProfileDTOL2, Principal principal);
}
