package org.project.mapper.model.L1;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.project.dto.models.L1.PassengerProfileDTOL1;
import org.project.model.PassengerProfile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PassengerProfileMapperL1 {
    private final ModelMapper modelMapper;

    public PassengerProfileDTOL1 toDTO(PassengerProfile passengerProfile) {
        return modelMapper.map(passengerProfile, PassengerProfileDTOL1.class);
    }

    public List<PassengerProfileDTOL1> toDTO(List<PassengerProfile> passengerProfileList) {
        return Optional.ofNullable(passengerProfileList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<PassengerProfile> toModel(List<PassengerProfileDTOL1> passengerProfileDTOL1List) {
        return Optional.ofNullable(passengerProfileDTOL1List)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public PassengerProfile toModel(PassengerProfileDTOL1 passengerProfileDTOL1) {
        return modelMapper.map(passengerProfileDTOL1, PassengerProfile.class);
    }
}
