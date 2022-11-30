package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.L2.UserProfileDTOL2;
import org.example.dto.page.UserProfilePage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserProfileMapperPage {
    private final ModelMapper modelMapper;


    public UserProfileDTOL2 toDTO(UserProfilePage userProfilePage) {
        return modelMapper.map(userProfilePage, UserProfileDTOL2.class);
    }

    public List<UserProfileDTOL2> toDTO(List<UserProfilePage> userProfilePageList) {
        return Optional.ofNullable(userProfilePageList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<UserProfilePage> toPage(List<UserProfileDTOL2> userProfileDTOL2List) {
        return Optional.ofNullable(userProfileDTOL2List)
                .map(list -> list.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public UserProfilePage toPage(UserProfileDTOL2 userProfileDTOL2) {
        return modelMapper.map(userProfileDTOL2, UserProfilePage.class);
    }
}
