package org.project.controller.searcher;

import lombok.RequiredArgsConstructor;

import org.project.dto.models.L1.PassengerProfileDTOL1;
import org.project.dto.models.L1.UserProfileDTOL1;
import org.project.dto.searcher.SearcherDTO;
import org.project.mapper.model.L1.PassengerProfileMapperL1;
import org.project.mapper.model.L1.UserProfileMapperL1;
import org.project.mapper.searcher.SearcherMapper;
import org.project.service.searcher.SearcherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "searcher")
public class SearcherController {
    private final SearcherService searcherService;
    private final SearcherMapper searcherMapper;
    private final UserProfileMapperL1 userProfileMapperL1;
    private final PassengerProfileMapperL1 passengerProfileMapperL1;

    @PostMapping(path = "find/user/profile", produces = "application/json", consumes = "application/json")
    public List<UserProfileDTOL1> findUserProfile(@RequestBody SearcherDTO searcherDTO) {
        return userProfileMapperL1.toDTO(searcherService.findUserProfile(searcherMapper.toModel(searcherDTO)));
    }

    @PostMapping(path = "find/passanger/profile", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTOL1> findJournal(@RequestBody SearcherDTO searcherDTO) {
        return passengerProfileMapperL1.toDTO(searcherService.findPassengerProfile(searcherMapper.toModel(searcherDTO)));
    }
}

