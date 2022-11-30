package org.project.dao.crud;

import org.project.model.PassengerProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerProfileDAO extends CrudRepository<PassengerProfile, Long> {
}
