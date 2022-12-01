package org.example.service.models.encoder;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.dto.models.L1.PassengerProfileDTOL1;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Service
public class EncoderServiceImpl implements EncoderService{

    @Override
    @SneakyThrows
    public PassengerProfileDTOL1 toUTF_8(PassengerProfileDTOL1 passengerProfileDTOL1) {
        System.out.println(passengerProfileDTOL1);
        String passengername = passengerProfileDTOL1.getPassengername();
        String passengerlastname = passengerProfileDTOL1.getPassengerlastname();
        String passportNumber = passengerProfileDTOL1.getPassportNumber();
        passengerProfileDTOL1.setPassengername(new String(passengername.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        passengerProfileDTOL1.setPassengerlastname(new String(passengerlastname.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        passengerProfileDTOL1.setPassportNumber(new String(passportNumber.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        System.out.println(passengerProfileDTOL1);
        return passengerProfileDTOL1;
    }

    @Override
    @SneakyThrows
    public PassengerProfileDTOL1 toISO_8859_1(PassengerProfileDTOL1 passengerProfileDTOL1) {
        String passengername = passengerProfileDTOL1.getPassengername();
        String passengerlastname = passengerProfileDTOL1.getPassengerlastname();
        String passportNumber = passengerProfileDTOL1.getPassportNumber();
        passengerProfileDTOL1.setPassengername(new String(passengername.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
        passengerProfileDTOL1.setPassengerlastname(new String(passengerlastname.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
        passengerProfileDTOL1.setPassportNumber(new String(passportNumber.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
        return passengerProfileDTOL1;
    }
}
