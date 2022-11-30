package org.project.controller.models.L2;

import lombok.RequiredArgsConstructor;
import org.project.dto.models.L2.PassengerProfileDTOL2;
import org.project.mapper.model.L2.PassengerProfileMapperL2;
import org.project.service.model.L2.api.PassengerProfileServiceL2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "modif/passenger/profile")
public class PassengerProfileControllerL2 {
    private final PassengerProfileServiceL2 passengerProfileServiceL2;
    private final PassengerProfileMapperL2 passengerProfileMapperL2;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTOL2> readAll() {
        return passengerProfileMapperL2.toDTO(passengerProfileServiceL2.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOL2 readById(@PathVariable("id") Long id) {
        return passengerProfileMapperL2.toDTO(passengerProfileServiceL2.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTOL2> readAllById(@RequestBody List<Long> ids) {
        return passengerProfileMapperL2.toDTO(passengerProfileServiceL2.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOL2 create(@RequestBody PassengerProfileDTOL2 passengerProfileDTOL2) {
        return passengerProfileMapperL2.toDTO(passengerProfileServiceL2.create(passengerProfileMapperL2.toModel(passengerProfileDTOL2)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOL2 update(@RequestBody PassengerProfileDTOL2 passengerProfileDTOL2) {
        return passengerProfileMapperL2.toDTO(passengerProfileServiceL2.update(passengerProfileMapperL2.toModel(passengerProfileDTOL2)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public PassengerProfileDTOL2 deleteById(@PathVariable("id") Long id) {
        return passengerProfileMapperL2.toDTO(passengerProfileServiceL2.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTOL2> deleteAllById(@RequestBody List<Long> ids) {
        return passengerProfileMapperL2.toDTO(passengerProfileServiceL2.deleteAllByIds(ids));
    }
}

