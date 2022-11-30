package org.project.service.model.L2.api;


import org.project.model.PassengerProfile;

import java.util.List;

public interface PassengerProfileServiceL2 {

    PassengerProfile create(PassengerProfile passengerProfile);

    List<PassengerProfile> readAll();

    PassengerProfile readById(Long id);

    List<PassengerProfile> readAllByIds(List<Long> ids);

    PassengerProfile deleteById(Long id);

    List<PassengerProfile> deleteAllByIds(List<Long> ids);

    PassengerProfile update(PassengerProfile passengerProfile);

}

