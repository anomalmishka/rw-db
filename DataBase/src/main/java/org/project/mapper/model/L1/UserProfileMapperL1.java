package org.project.mapper.model.L1;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.project.dto.models.L1.UserProfileDTOL1;
import org.project.model.UserProfile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserProfileMapperL1 {

    private final ModelMapper modelMapper;

    public UserProfileDTOL1 toDTO(UserProfile userProfile) {
        System.out.println(userProfile);
        return modelMapper.map(userProfile, UserProfileDTOL1.class);
    }

    public List<UserProfileDTOL1> toDTO(List<UserProfile> userProfileList) {
        return Optional.ofNullable(userProfileList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<UserProfile> toModel(List<UserProfileDTOL1> userProfileDTOL1List) {
        return Optional.ofNullable(userProfileDTOL1List)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public UserProfile toModel(UserProfileDTOL1 userProfileDTOL1) {
        return modelMapper.map(userProfileDTOL1, UserProfile.class);
    }
}
