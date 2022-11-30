package org.project.controller.searcher;

import lombok.RequiredArgsConstructor;
import org.project.dto.models.L2.UserProfileDTOL2;
import org.project.mapper.model.L2.UserProfileMapperL2;
import org.project.service.filter.FilterUserProfileService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "filter/user/profile")
public class FilterUserProfileController {
    private final FilterUserProfileService filterUserProfileService;
    private final UserProfileMapperL2 userProfileMapperL2;

    @GetMapping(path = "where/user/{userId}/", produces = "application/json", consumes = "application/json")
    public UserProfileDTOL2 findWhereName(@PathVariable("userId") Long userId) {
        return userProfileMapperL2.toDTO(filterUserProfileService.findWhereUserId(userId));
    }
}

