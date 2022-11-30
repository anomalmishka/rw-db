package org.project.controller.models.L2;

import lombok.RequiredArgsConstructor;
import org.project.dto.models.L2.UserProfileDTOL2;
import org.project.mapper.model.L2.UserProfileMapperL2;
import org.project.service.model.L2.api.UserProfileServiceL2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "modif/user/profile")
public class UserProfileControllerL2 {
    private final UserProfileServiceL2 userProfileServiceL2;
    private final UserProfileMapperL2 userProfileMapperL2;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTOL2> readAll() {
        return userProfileMapperL2.toDTO(userProfileServiceL2.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public UserProfileDTOL2 readById(@PathVariable("id") Long id) {
        return userProfileMapperL2.toDTO(userProfileServiceL2.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTOL2> readAllById(@RequestBody List<Long> ids) {
        return userProfileMapperL2.toDTO(userProfileServiceL2.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public UserProfileDTOL2 create(@RequestBody UserProfileDTOL2 userProfileDTOL2) {
        return userProfileMapperL2.toDTO(userProfileServiceL2.create(userProfileMapperL2.toModel(userProfileDTOL2)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public UserProfileDTOL2 update(@RequestBody UserProfileDTOL2 userProfileDTOL2) {
        return userProfileMapperL2.toDTO(userProfileServiceL2.update(userProfileMapperL2.toModel(userProfileDTOL2)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public UserProfileDTOL2 deleteById(@PathVariable("id") Long id) {
        return userProfileMapperL2.toDTO(userProfileServiceL2.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTOL2> deleteAllById(@RequestBody List<Long> ids) {
        return userProfileMapperL2.toDTO(userProfileServiceL2.deleteAllByIds(ids));
    }
}

