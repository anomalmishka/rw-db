package org.project.mapper.model.L2;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.project.dto.models.L2.UserProfileDTOL2;
import org.project.model.UserProfile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserProfileMapperL2 {
    private final ModelMapper modelMapper;

    public UserProfileDTOL2 toDTO(UserProfile userProfile) {
            return modelMapper.map(userProfile, UserProfileDTOL2.class);
    }

    public List<UserProfileDTOL2> toDTO(List<UserProfile> userProfileList) {
        return Optional.ofNullable(userProfileList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<UserProfile> toModel(List<UserProfileDTOL2> userProfileDTOL2List) {
        return Optional.ofNullable(userProfileDTOL2List)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public UserProfile toModel(UserProfileDTOL2 userProfileDTOL2) {
        return modelMapper.map(userProfileDTOL2, UserProfile.class);
    }
}
