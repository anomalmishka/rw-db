package org.project.service.filter;

import org.project.model.UserProfile;

public interface FilterUserProfileService {

    UserProfile findWhereUserId(Long userId);
}

