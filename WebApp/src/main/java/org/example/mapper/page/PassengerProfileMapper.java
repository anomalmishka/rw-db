package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.L1.PassengerProfileDTOL1;
import org.example.dto.models.L2.PassengerProfileDTOL2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PassengerProfileMapper {
    private final ModelMapper modelMapper;


    public PassengerProfileDTOL2 toL2(PassengerProfileDTOL1 passengerProfileDTOL1) {
        return modelMapper.map(passengerProfileDTOL1, PassengerProfileDTOL2.class);
    }

    public List<PassengerProfileDTOL2> toL2(List<PassengerProfileDTOL1> passengerProfileDTOL1List) {
        return Optional.ofNullable(passengerProfileDTOL1List)
                .map(list -> list.stream()
                        .map(this::toL2).collect(Collectors.toList())).orElse(null);
    }

    public List<PassengerProfileDTOL1> toL1(List<PassengerProfileDTOL2> passengerProfileDTOL2List) {
        return Optional.ofNullable(passengerProfileDTOL2List)
                .map(list -> list.stream()
                        .map(this::toL1).collect(Collectors.toList())).orElse(null);
    }

    public PassengerProfileDTOL1 toL1(PassengerProfileDTOL2 passengerProfileDTOL2) {
        return modelMapper.map(passengerProfileDTOL2, PassengerProfileDTOL1.class);
    }
}
