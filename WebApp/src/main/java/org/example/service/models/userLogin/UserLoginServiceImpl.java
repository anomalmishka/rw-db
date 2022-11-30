package org.example.service.models.userLogin;

import lombok.RequiredArgsConstructor;
import org.example.dao.UserLoginDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.model.UserLogin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UserLoginServiceImpl implements UserLoginService {

    private final UserLoginDAO userLoginDAO;


    @Override
    public List<UserLogin> readAll() {
        return userLoginDAO.findAll();
    }

    @Override
    public UserLogin readById(Long id) {
        try {
            return userLoginDAO.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        }
    }

    @Override
    public List<UserLogin> readAllByIds(List<Long> ids) {
        return userLoginDAO.findAllById(ids);
    }

    @Override
    public UserLogin create(UserLogin userLogin) {
        return userLoginDAO.save(userLogin);
    }

    @Override
    public UserLogin update(UserLogin userLogin) {
        return userLoginDAO.save(userLogin);
    }

    @Override
    public UserLogin deleteById(Long id) {
        try {
            UserLogin deleteEntity = userLoginDAO.findById(id).get();
            userLoginDAO.deleteById(id);
            return deleteEntity;
        } catch (NoSuchElementException e) {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        }
    }

    @Override
    public List<UserLogin> deleteAllByIds(List<Long> ids) {
        List<UserLogin> userLoginList = readAllByIds(ids);
        userLoginDAO.deleteAllById(ids);
        return userLoginList;
    }

    @Override
    public UserLogin findByUsername(String username) {
        return userLoginDAO.findByUsername(username);
    }
}
