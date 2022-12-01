package org.example.service.models.encoder;

import org.example.dto.models.L1.PassengerProfileDTOL1;

public interface EncoderService {
    PassengerProfileDTOL1 toUTF_8(PassengerProfileDTOL1 passengerProfileDTOL1);
    PassengerProfileDTOL1 toISO_8859_1(PassengerProfileDTOL1 passengerProfileDTOL1);
}
