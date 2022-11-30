package org.project.dao.custom.userProfile;

import org.project.model.UserProfile;

public interface UserPrifileCustomDAO {
    UserProfile findWhereUserId(Long userId);
}
