package org.project.service.model.L2;

import lombok.RequiredArgsConstructor;
import org.project.model.PassengerProfile;
import org.project.service.model.L1.api.PassengerProfileServiceL1;
import org.project.service.model.L2.api.PassengerProfileServiceL2;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PassengerProfileServiceL2Impl implements PassengerProfileServiceL2 {
    private final PassengerProfileServiceL1 passengerProfileServiceL1;

    @Override
    public PassengerProfile create(PassengerProfile passengerProfile) {
        return passengerProfileServiceL1.create(passengerProfile);
    }

    @Override
    public List<PassengerProfile> readAll() {
        return passengerProfileServiceL1.readAll();
    }

    @Override
    public PassengerProfile readById(Long id) {
        return passengerProfileServiceL1.readById(id);
    }

    @Override
    public List<PassengerProfile> readAllByIds(List<Long> ids) {
        return passengerProfileServiceL1.readAllByIds(ids);
    }

    @Override
    public PassengerProfile deleteById(Long id) {
        return passengerProfileServiceL1.deleteById(id);
    }

    @Override
    public List<PassengerProfile> deleteAllByIds(List<Long> ids) {
        return passengerProfileServiceL1.deleteAllByIds(ids);
    }

    @Override
    public PassengerProfile update(PassengerProfile passengerProfile) {
        return passengerProfileServiceL1.update(passengerProfile);
    }

}
