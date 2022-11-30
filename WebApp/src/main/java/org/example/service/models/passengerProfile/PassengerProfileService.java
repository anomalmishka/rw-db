package org.example.service.models.passengerProfile;

import org.example.dto.models.L2.PassengerProfileDTOL2;

import java.util.List;

public interface PassengerProfileService {
    PassengerProfileDTOL2 create(PassengerProfileDTOL2 passengerProfileDTOL2);

    List<PassengerProfileDTOL2> readAll();

    PassengerProfileDTOL2 readById(Long id);

    List<PassengerProfileDTOL2> readAllByIds(List<Long> ids);

    PassengerProfileDTOL2 deleteById(Long id);

    List<PassengerProfileDTOL2> deleteAllByIds(List<Long> ids);

    PassengerProfileDTOL2 update(PassengerProfileDTOL2 passengerProfileDTOL2);
}
