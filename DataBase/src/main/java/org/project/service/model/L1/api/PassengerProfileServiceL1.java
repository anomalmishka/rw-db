package org.project.service.model.L1.api;


import org.project.model.PassengerProfile;

import java.util.List;

public interface PassengerProfileServiceL1 {

    PassengerProfile create(PassengerProfile passengerProfile);

    List<PassengerProfile> readAll();

    PassengerProfile readById(Long id);

    List<PassengerProfile> readAllByIds(List<Long> ids);

    PassengerProfile deleteById(Long id);

    List<PassengerProfile> deleteAllByIds(List<Long> ids);

    PassengerProfile update(PassengerProfile passengerProfile);
}

