package org.example.service.models.passengerProfileCustom;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.L2.PassengerProfileDTOL2;
import org.example.dto.models.L2.UserProfileDTOL2;
import org.example.model.UserLogin;
import org.example.service.models.userLoginCustom.UserLoginCustomService;
import org.example.service.models.userProfileCustom.UserProfileCustomService;
import org.example.service.models.userProfilePage.UserProfilePageService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PassengerProfileCustomServiceImpl implements PassengerProfileCustomService {
    private final UserProfilePageService userProfilePageService;
    private final UserLoginCustomService userLoginCustomService;
    private final UserProfileCustomService userProfileCustomService;

    @Override
    public List<PassengerProfileDTOL2> create(PassengerProfileDTOL2 passengerProfileDTOL2, Principal principal) {
        String name = principal.getName();
        UserLogin userLogin = userLoginCustomService.findByUsername(name);
        Long userLoginId = userLogin.getId();
        UserProfileDTOL2 findUserProfileDTOL2 = userProfileCustomService.findWhereUserId(userLoginId);
        List<PassengerProfileDTOL2> getPassengerProfileDTOL2List = findUserProfileDTOL2.getPassengerProfileList();
        if (passengerProfileDTOL2 != null) {
            getPassengerProfileDTOL2List.add(passengerProfileDTOL2);
        }
        findUserProfileDTOL2.setPassengerProfileList(getPassengerProfileDTOL2List);
        UserProfileDTOL2 updateUserProfileDTOL2 = userProfilePageService.updateProfile(findUserProfileDTOL2, principal);
        return updateUserProfileDTOL2.getPassengerProfileList();
    }

    @Override
    public List<PassengerProfileDTOL2> getPassanger(Principal principal) {
        UserLogin userLogin = userLoginCustomService.findByUsername(principal.getName());
        Long loginId = userLogin.getId();
        UserProfileDTOL2 userProfileDTOL2 = userProfileCustomService.findWhereUserId(loginId);
        return userProfileDTOL2.getPassengerProfileList();
    }

    @Override
    public List<PassengerProfileDTOL2> readPassangerProfile(UserProfileDTOL2 userProfileDTOL2) {
        return userProfileDTOL2.getPassengerProfileList();
    }
}
