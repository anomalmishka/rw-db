package org.project.service.model.L1.api;
import org.project.model.UserProfile;

import java.util.List;

public interface UserProfileServiceL1 {

    UserProfile create(UserProfile userProfile);

    List<UserProfile> readAll();

    UserProfile readById(Long id);

    List<UserProfile> readAllByIds(List<Long> ids);

    UserProfile deleteById(Long id);

    List<UserProfile> deleteAllByIds(List<Long> ids);

    UserProfile update(UserProfile userProfile);
}

