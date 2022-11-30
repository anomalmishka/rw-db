package org.project.controller.models.L1;

import lombok.RequiredArgsConstructor;
import org.project.dto.models.L1.PassengerProfileDTOL1;
import org.project.mapper.model.L1.PassengerProfileMapperL1;
import org.project.service.model.L1.api.PassengerProfileServiceL1;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "passenger/profile")
public class PassengerProfileControllerL1 implements Serializable {
    private final PassengerProfileServiceL1 passengerProfileServiceL1;
    private final PassengerProfileMapperL1 passengerProfileMapperL1;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTOL1> readAll() {
        return passengerProfileMapperL1.toDTO(passengerProfileServiceL1.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOL1 readById(@PathVariable("id") Long id) {
        return passengerProfileMapperL1.toDTO(passengerProfileServiceL1.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTOL1> readAllById(@RequestBody List<Long> ids) {
        return passengerProfileMapperL1.toDTO(passengerProfileServiceL1.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOL1 create(@RequestBody PassengerProfileDTOL1 passengerProfileDTOL1) {
        return passengerProfileMapperL1.toDTO(passengerProfileServiceL1.create(passengerProfileMapperL1.toModel(passengerProfileDTOL1)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOL1 update(@RequestBody PassengerProfileDTOL1 passengerProfileDTOL1) {
        return passengerProfileMapperL1.toDTO(passengerProfileServiceL1.update(passengerProfileMapperL1.toModel(passengerProfileDTOL1)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOL1 deleteById(@PathVariable("id") Long id) {
        return passengerProfileMapperL1.toDTO(passengerProfileServiceL1.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTOL1> deleteAllById(@RequestBody List<Long> ids) {
        return passengerProfileMapperL1.toDTO(passengerProfileServiceL1.deleteAllByIds(ids));
    }
}

