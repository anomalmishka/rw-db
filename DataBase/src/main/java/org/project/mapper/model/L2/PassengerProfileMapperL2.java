package org.project.mapper.model.L2;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.project.dto.models.L2.PassengerProfileDTOL2;
import org.project.model.PassengerProfile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PassengerProfileMapperL2 {
    private final ModelMapper modelMapper;

    public PassengerProfileDTOL2 toDTO(PassengerProfile passengerProfile) {
        return modelMapper.map(passengerProfile, PassengerProfileDTOL2.class);
    }

    public List<PassengerProfileDTOL2> toDTO(List<PassengerProfile> passengerProfileList) {
        return Optional.ofNullable(passengerProfileList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<PassengerProfile> toModel(List<PassengerProfileDTOL2> passengerProfileDTOModifList) {
        return Optional.ofNullable(passengerProfileDTOModifList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public PassengerProfile toModel(PassengerProfileDTOL2 passengerProfileDTOModif) {
        return modelMapper.map(passengerProfileDTOModif, PassengerProfile.class);
    }
}
