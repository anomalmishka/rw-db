package org.example.service.models.passengerProfile;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.L2.PassengerProfileDTOL2;
import org.example.service.rest.models.passengerProfile.PassengerProfileRestTemlateService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PassengerProfileServiceImpl implements PassengerProfileService {

    private final PassengerProfileRestTemlateService passengerProfileRestTemlateService;

    @Override
    public PassengerProfileDTOL2 create(PassengerProfileDTOL2 passengerProfileDTOL2) {
        return passengerProfileRestTemlateService.create(passengerProfileDTOL2);
    }

    @Override
    public List<PassengerProfileDTOL2> readAll() {
        return passengerProfileRestTemlateService.readAll();
    }

    @Override
    public PassengerProfileDTOL2 readById(Long id) {
        return passengerProfileRestTemlateService.readById(id);
    }

    @Override
    public List<PassengerProfileDTOL2> readAllByIds(List<Long> ids) {
        return passengerProfileRestTemlateService.readAllByIds(ids);
    }

    @Override
    public PassengerProfileDTOL2 deleteById(Long id) {
        return passengerProfileRestTemlateService.deleteById(id);
    }

    @Override
    public List<PassengerProfileDTOL2> deleteAllByIds(List<Long> ids) {
        return passengerProfileRestTemlateService.deleteAllByIds(ids);
    }

    @Override
    public PassengerProfileDTOL2 update(PassengerProfileDTOL2 passengerProfileDTOL2) {
        return passengerProfileRestTemlateService.update(passengerProfileDTOL2);
    }
}
