package org.project.controller.models.L1;

import lombok.RequiredArgsConstructor;
import org.project.dto.models.L1.UserProfileDTOL1;
import org.project.mapper.model.L1.UserProfileMapperL1;
import org.project.service.model.L1.api.UserProfileServiceL1;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user/profile")
public class UserProfileControllerL1 implements Serializable {
    private final UserProfileServiceL1 userProfileService;
    private final UserProfileMapperL1 userProfileMapper;

    @GetMapping(path = "read/all", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTOL1> readAll() {
        return userProfileMapper.toDTO(userProfileService.readAll());
    }

    @GetMapping(path = "read/{id}/", produces = "application/json", consumes = "application/json")
    public UserProfileDTOL1 readById(@PathVariable("id") Long id) {
        return userProfileMapper.toDTO(userProfileService.readById(id));
    }

    @PostMapping(path = "read/all/id", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTOL1> readAllById(@RequestBody List<Long> ids) {
        return userProfileMapper.toDTO(userProfileService.readAllByIds(ids));
    }

    @PostMapping(path = "create", produces = "application/json", consumes = "application/json")
    public UserProfileDTOL1 create(@RequestBody UserProfileDTOL1 userProfileDTOL1) {
        return userProfileMapper.toDTO(userProfileService.create(userProfileMapper.toModel(userProfileDTOL1)));
    }

    @PutMapping(path = "update", produces = "application/json", consumes = "application/json")
    public UserProfileDTOL1 update(@RequestBody UserProfileDTOL1 userProfileDTOL1) {
        return userProfileMapper.toDTO(userProfileService.update(userProfileMapper.toModel(userProfileDTOL1)));
    }

    @DeleteMapping(path = "delete/{id}/", produces = "application/json", consumes = "application/json")
    public UserProfileDTOL1 deleteById(@PathVariable("id") Long id) {
        return userProfileMapper.toDTO(userProfileService.deleteById(id));
    }

    @DeleteMapping(path = "delete/all/id", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTOL1> deleteAllById(@RequestBody List<Long> ids) {
        return userProfileMapper.toDTO(userProfileService.deleteAllByIds(ids));
    }
}

