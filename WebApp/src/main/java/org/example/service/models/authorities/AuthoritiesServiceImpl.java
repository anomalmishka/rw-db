package org.example.service.models.authorities;

import lombok.RequiredArgsConstructor;
import org.example.dao.AuthoritiesDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.model.Authorities;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

    private final AuthoritiesDAO authoritiesDAO;


    @Override
    public List<Authorities> readAll() {
        return authoritiesDAO.findAll();
    }

    @Override
    public Authorities readById(Long id) {
        try {
            return authoritiesDAO.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        }
    }

    @Override
    public List<Authorities> readAllByIds(List<Long> ids) {
        return authoritiesDAO.findAllById(ids);
    }

    @Override
    public Authorities create(Authorities authorities) {
        return authoritiesDAO.save(authorities);
    }

    @Override
    public Authorities update(Authorities authorities) {
        return authoritiesDAO.save(authorities);
    }

    @Override
    public Authorities deleteById(Long id) {
        try {
            Authorities deleteEntity = authoritiesDAO.findById(id).get();
            authoritiesDAO.deleteById(id);
            return deleteEntity;
        } catch (NoSuchElementException e) {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        }
    }

    @Override
    public List<Authorities> deleteAllByIds(List<Long> ids) {
        List<Authorities> userList = readAllByIds(ids);
        authoritiesDAO.deleteAllById(ids);
        return userList;
    }
}
