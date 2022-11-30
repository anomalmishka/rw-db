package org.project.service.model.L2;

import lombok.RequiredArgsConstructor;
import org.project.dao.crud.UserProfileDAO;
import org.project.exception.ErrorDataNotFound;
import org.project.exception.ErrorInvalidData;
import org.project.model.PassengerProfile;
import org.project.model.UserProfile;
import org.project.service.model.L1.api.UserProfileServiceL1;
import org.project.service.model.L2.api.UserProfileServiceL2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class UserProfileServiceImplL2 implements UserProfileServiceL2 {
        private final UserProfileDAO userProfileDAO;

    @Override
    public UserProfile create(UserProfile userProfile) {
        if (userProfile.getProfilename() != null) {
            return userProfileDAO.save(userProfile);
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }

    @Override
    public List<UserProfile> readAll() {
        return StreamSupport
                .stream(userProfileDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public UserProfile readById(Long id) {
        try {
            return userProfileDAO.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        }
    }

    @Override
    public List<UserProfile> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(userProfileDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public UserProfile deleteById(Long id) {
        try {
            UserProfile deleteEntity = userProfileDAO.findById(id).get();
            userProfileDAO.deleteById(id);
            return deleteEntity;
        } catch (NoSuchElementException e) {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        }
    }

    @Override
    public List<UserProfile> deleteAllByIds(List<Long> ids) {
        List<UserProfile> deleteEntities = readAllByIds(ids);
        userProfileDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public UserProfile update(UserProfile userProfile) {
        if (userProfile.getProfilename() != null) {
            return userProfileDAO.save(userProfile);
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }
}
