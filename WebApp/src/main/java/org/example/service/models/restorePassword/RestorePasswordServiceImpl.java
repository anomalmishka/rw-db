package org.example.service.models.restorePassword;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.L2.UserProfileDTOL2;
import org.example.exception.ErrorInvalidData;
import org.example.model.UserLogin;
import org.example.service.models.userLogin.UserLoginService;
import org.example.service.models.userLoginCustom.UserLoginCustomService;
import org.example.service.models.userProfileCustom.UserProfileCustomService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class RestorePasswordServiceImpl implements RestorePasswordService {

    private final UserProfileCustomService userProfileCustomService;
    private final UserLoginService userLoginService;
    private final UserLoginCustomService userLoginCustomService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserLogin restorePassword(UserProfileDTOL2 userProfileDTOL2, UserLogin userLogin) {
        if (!Objects.equals(userLogin.getPassword(), userLogin.getPasswordConfirm())) {
            throw new ErrorInvalidData("Passwords don't match");
        }
        UserLogin findUserLogin = userLoginCustomService.findByUsername(userLogin.getUsername());
        if (findUserLogin == null) {
            throw new ErrorInvalidData("User with this login not exists");
        } else {
            Long loginId = findUserLogin.getId();
            UserProfileDTOL2 findUserProfileDTOL2 = userProfileCustomService.findWhereUserId(loginId);
            String getPofilename = userProfileDTOL2.getProfilename();
            String getLastname = userProfileDTOL2.getLastname();
            String getEmail = userProfileDTOL2.getEmail();
            String findProfilename = findUserProfileDTOL2.getProfilename();
            String findLastname = findUserProfileDTOL2.getLastname();
            String findEmail = findUserProfileDTOL2.getEmail();
            if (getPofilename.equals(findProfilename) && getLastname.equals(findLastname) && getEmail.equals(findEmail))
            {
                findUserLogin.setPassword(passwordEncoder.encode(userLogin.getPassword()));
                return userLoginService.update(findUserLogin);
            }
            else {
                throw new ErrorInvalidData("Given Name or Lastname or Email not equals");
            }
        }
    }
}
