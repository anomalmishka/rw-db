package org.project.dao.crud;

import org.project.model.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileDAO extends CrudRepository<UserProfile, Long> {
}
