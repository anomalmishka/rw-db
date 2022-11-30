package org.example.service.rest.filter.userProfile;


import org.example.dto.models.L2.UserProfileDTOL2;

public interface UserProfileRestTemplateFilter {

    UserProfileDTOL2 findWhereUserId(Long userId);

}
