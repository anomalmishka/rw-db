package org.project.service.model.L2;

import lombok.RequiredArgsConstructor;
import org.project.exception.ErrorInvalidData;
import org.project.model.PassengerProfile;
import org.project.model.UserProfile;
import org.project.service.model.L1.api.UserProfileServiceL1;
import org.project.service.model.L2.api.PassengerProfileServiceL2;
import org.project.service.model.L2.api.UserProfileServiceL2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserProfileServiceL2Impl implements UserProfileServiceL2 {
    private final UserProfileServiceL1 userProfileServiceL1;
    private final PassengerProfileServiceL2 passengerProfileServiceL2;

    @Override
    public UserProfile create(UserProfile userProfile) {
        UserProfile profile = userProfileServiceL1.create(userProfile);
        List<PassengerProfile> passengerProfileList = profile.getPassengerProfileList();
        if (passengerProfileList!=null) {
            passengerProfileList.forEach(passengerProfile -> passengerProfile.setUserProfile(profile));
            List<PassengerProfile> collect = passengerProfileList.stream().map(passengerProfileServiceL2::update).collect(Collectors.toList());
            profile.setPassengerProfileList(collect);
        }
        return profile;
    }

    @Override
    public List<UserProfile> readAll() {
        return userProfileServiceL1.readAll();
    }

    @Override
    public UserProfile readById(Long id) {
        return userProfileServiceL1.readById(id);
    }

    @Override
    public List<UserProfile> readAllByIds(List<Long> ids) {
        return userProfileServiceL1.readAllByIds(ids);
    }

    @Override
    public UserProfile deleteById(Long id) {
        return userProfileServiceL1.deleteById(id);
    }

    @Override
    public List<UserProfile> deleteAllByIds(List<Long> ids) {
        return userProfileServiceL1.deleteAllByIds(ids);
    }

    @Override
    public UserProfile update(UserProfile userProfile) {
        return userProfileServiceL1.update(setForgetValueOnId(userProfile));
    }

    private UserProfile setForgetValueOnId(UserProfile userProfile) {
        if (userProfile.getProfilename() != null) {
            Long id = userProfile.getId();
            List<PassengerProfile> getPassengerProfileList = userProfile.getPassengerProfileList();
            UserProfile profile = userProfileServiceL1.readById(id);
            profile.setProfilename(userProfile.getProfilename());
            profile.setLastname(userProfile.getLastname());
            profile.setPhone(userProfile.getPhone());
            profile.setEmail(userProfile.getEmail());
            if (getPassengerProfileList != null) {
                profile.setPassengerProfileList(getPassengerProfileList);
            }
            return profile;
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }
}
