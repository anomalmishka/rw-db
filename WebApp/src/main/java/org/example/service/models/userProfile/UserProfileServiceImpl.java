package org.example.service.models.userProfile;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.L2.UserProfileDTOL2;
import org.example.service.rest.models.userProfile.UserProfileRestTemlateService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRestTemlateService userProfileRestTemlateService;


    @Override
    public List<UserProfileDTOL2> readAll() {
        return userProfileRestTemlateService.readAll();
    }

    @Override
    public UserProfileDTOL2 readById(Long id) {
        return userProfileRestTemlateService.readById(id);
    }

    @Override
    public List<UserProfileDTOL2> readAllByIds(List<Long> ids) {
        return userProfileRestTemlateService.readAllByIds(ids);
    }

    @Override
    public UserProfileDTOL2 create(UserProfileDTOL2 userProfileDTOL22) {
        return userProfileRestTemlateService.create(userProfileDTOL22);
    }

    @Override
    public UserProfileDTOL2 update(UserProfileDTOL2 userProfileDTOL22) {
        return userProfileRestTemlateService.update(userProfileDTOL22);
    }

    @Override
    public UserProfileDTOL2 deleteById(Long id) {
        return userProfileRestTemlateService.deleteById(id);
    }

    @Override
    public List<UserProfileDTOL2> deleteAllByIds(List<Long> ids) {
        return userProfileRestTemlateService.deleteAllByIds(ids);
    }
}
