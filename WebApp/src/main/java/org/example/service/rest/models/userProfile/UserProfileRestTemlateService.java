package org.example.service.rest.models.userProfile;

import org.example.dto.models.L2.UserProfileDTOL2;

import java.util.List;

public interface UserProfileRestTemlateService {
    List<UserProfileDTOL2> readAll();

    UserProfileDTOL2 readById(Long id);

    List<UserProfileDTOL2> readAllByIds(List<Long> ids);

    UserProfileDTOL2 create(UserProfileDTOL2 userProfileDTOL2);

    UserProfileDTOL2 update(UserProfileDTOL2 userProfileDTOL2);

    UserProfileDTOL2 deleteById(Long id);

    List<UserProfileDTOL2> deleteAllByIds(List<Long> ids);
}
