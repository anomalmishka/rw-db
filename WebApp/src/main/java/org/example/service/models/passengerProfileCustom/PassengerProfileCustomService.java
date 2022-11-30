package org.example.service.models.passengerProfileCustom;

import org.example.dto.models.L2.PassengerProfileDTOL2;
import org.example.dto.models.L2.UserProfileDTOL2;

import java.security.Principal;
import java.util.List;

public interface PassengerProfileCustomService {
    List<PassengerProfileDTOL2> create(PassengerProfileDTOL2 passengerProfileDTOL2, Principal principal);
    List<PassengerProfileDTOL2> getPassanger(Principal principal);
    List<PassengerProfileDTOL2> readPassangerProfile(UserProfileDTOL2 userProfileDTOL2);
}
