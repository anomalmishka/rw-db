package org.example.service.models.userProfilePage;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.L2.PassengerProfileDTOL2;
import org.example.dto.models.L2.UserProfileDTOL2;
import org.example.mapper.page.PassengerProfileMapper;
import org.example.model.UserLogin;
import org.example.service.models.userLoginCustom.UserLoginCustomService;
import org.example.service.models.userProfile.UserProfileService;
import org.example.service.models.userProfileCustom.UserProfileCustomService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserProfilePageServiceImpl implements UserProfilePageService {
    private final UserProfileCustomService userProfileCustomService;
    private final UserProfileService userProfileService;
    private final UserLoginCustomService userLoginCustomService;
    private final PassengerProfileMapper passengerProfileMapper;

    @Override
    public UserProfileDTOL2 findWhereName(Principal principal) {
        UserLogin userLogin = userLoginCustomService.findByUsername(principal.getName());
        Long loginId = userLogin.getId();
        return userProfileCustomService.findWhereUserId(loginId);
    }

    @Override
    public UserProfileDTOL2 updateProfile(UserProfileDTOL2 userProfileDTOL2, Principal principal) {
        List<PassengerProfileDTOL2> getPassengerProfileList = passengerProfileMapper.toL2(userProfileDTOL2.getPassengerProfileList());
        UserLogin userLogin = userLoginCustomService.findByUsername(principal.getName());
        Long loginId = userLogin.getId();
        UserProfileDTOL2 findUserProfileDTOL2 = userProfileCustomService.findWhereUserId(loginId);
        findUserProfileDTOL2.setProfilename(userProfileDTOL2.getProfilename());
        findUserProfileDTOL2.setLastname(userProfileDTOL2.getLastname());
        findUserProfileDTOL2.setPhone(userProfileDTOL2.getPhone());
        findUserProfileDTOL2.setEmail(userProfileDTOL2.getEmail());
        if (getPassengerProfileList != null) {
            findUserProfileDTOL2.setPassengerProfileList(passengerProfileMapper.toL1(getPassengerProfileList));
        }
        return userProfileService.update(findUserProfileDTOL2);
    }
}
