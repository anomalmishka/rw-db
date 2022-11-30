package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.L2.PassengerProfileDTOL2;
import org.example.dto.page.PassengerProfilePage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PassengerProfileMapperPage {
    private final ModelMapper modelMapper;


    public PassengerProfileDTOL2 toDTO(PassengerProfilePage passengerProfilePage) {
        return modelMapper.map(passengerProfilePage, PassengerProfileDTOL2.class);
    }

    public List<PassengerProfileDTOL2> toDTO(List<PassengerProfilePage> passengerProfilePageList) {
        return Optional.ofNullable(passengerProfilePageList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<PassengerProfilePage> toPage(List<PassengerProfileDTOL2> passengerProfileDTOL2List) {
        return Optional.ofNullable(passengerProfileDTOL2List)
                .map(list -> list.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public PassengerProfilePage toPage(PassengerProfileDTOL2 passengerProfileDTOL2) {
        return modelMapper.map(passengerProfileDTOL2, PassengerProfilePage.class);
    }
}
