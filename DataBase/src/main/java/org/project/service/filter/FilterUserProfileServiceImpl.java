package org.project.service.filter;

import lombok.RequiredArgsConstructor;
import org.project.dao.custom.userProfile.UserPrifileCustomDAO;
import org.project.model.UserProfile;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FilterUserProfileServiceImpl implements FilterUserProfileService {
    private final UserPrifileCustomDAO userPrifileCustomDAO;

    @Override
    public UserProfile findWhereUserId(Long userId) {
        return userPrifileCustomDAO.findWhereUserId(userId);
    }
}
