package org.project.service.model.L2;

import lombok.RequiredArgsConstructor;
import org.project.dao.crud.PassengerProfileDAO;
import org.project.exception.ErrorDataNotFound;
import org.project.exception.ErrorInvalidData;
import org.project.model.PassengerProfile;
import org.project.service.model.L2.api.PassengerProfileServiceL2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class PassengerProfileServiceImplL2 implements PassengerProfileServiceL2 {
    private final PassengerProfileDAO passengerProfileDAO;

    @Override
    public PassengerProfile create(PassengerProfile passengerProfile) {
        if (passengerProfile.getPassengername() != null) {
            return passengerProfileDAO.save(passengerProfile);
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }

    @Override
    public List<PassengerProfile> readAll() {
        return StreamSupport
                .stream(passengerProfileDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public PassengerProfile readById(Long id) {
        try {
            return passengerProfileDAO.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        }
    }

    @Override
    public List<PassengerProfile> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(passengerProfileDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public PassengerProfile deleteById(Long id) {
        try {
            PassengerProfile deleteEntity = passengerProfileDAO.findById(id).get();
            passengerProfileDAO.deleteById(id);
            return deleteEntity;
        }catch (NoSuchElementException e) {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        }
    }

    @Override
    public List<PassengerProfile> deleteAllByIds(List<Long> ids) {
        List<PassengerProfile> deleteEntities = readAllByIds(ids);
        passengerProfileDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public PassengerProfile update(PassengerProfile passengerProfile) {
        if (passengerProfile.getPassengername() != null) {
            return passengerProfileDAO.save(passengerProfile);
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }
}
