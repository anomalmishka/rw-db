package service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.project.dao.crud.UserProfileDAO;
import org.project.exception.ErrorDataNotFound;
import org.project.exception.ErrorInvalidData;
import org.project.model.PassengerProfile;
import org.project.model.UserProfile;
import org.project.service.model.L1.UserProfileServiceL1Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserProfileServiceImplTest {
    @Mock
    UserProfileDAO userProfileDAO;

    @InjectMocks
    UserProfileServiceL1Impl userProfileServiceL1;

    private final PassengerProfile passengerProfile = PassengerProfile.builder()
            .id(1L)
            .passengername("Admin")
            .passengerlastname("Admin")
            .passportNumber("KK0000000")
            .build();
    private final List<PassengerProfile> EXPECTED_PASSANGER_PROFILE_LIST = new ArrayList<>();
    private final UserProfile GIVEN_USER_PROFILE = UserProfile.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(11111111)
            .email("admin@gmail.com")
            .isBlockedProfile(false)
            .passengerProfileList(EXPECTED_PASSANGER_PROFILE_LIST)
            .userId(1L)
            .build();

    private final UserProfile GIVEN_USER_PROFILE_UPDATE = UserProfile.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(11111111)
            .email("admin@gmail.com")
            .isBlockedProfile(false)
            .passengerProfileList(EXPECTED_PASSANGER_PROFILE_LIST)
            .userId(1L)
            .build();
    private final UserProfile USER_PROFILE_NAME_NULL = UserProfile.builder()
            .id(1L)
            .profilename(null)
            .lastname("Admin")
            .phone(11111111)
            .email("admin@gmail.com")
            .isBlockedProfile(false)
            .passengerProfileList(EXPECTED_PASSANGER_PROFILE_LIST)
            .userId(1L)
            .build();
    private final UserProfile ANSWER_USER_PROFILE = UserProfile.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(11111111)
            .email("admin@gmail.com")
            .isBlockedProfile(false)
            .passengerProfileList(EXPECTED_PASSANGER_PROFILE_LIST)
            .userId(1L)
            .build();

    private final UserProfile ANSWER_USER_PROFILE_UPDATE = UserProfile.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(11111111)
            .email("admin@gmail.com")
            .isBlockedProfile(false)
            .passengerProfileList(EXPECTED_PASSANGER_PROFILE_LIST)
            .userId(1L)
            .build();
    private final UserProfile ANSWER_USER_PROFILE_2 = UserProfile.builder()
            .id(2L)
            .profilename("User")
            .lastname("User")
            .phone(2222222)
            .email("user@gmail.com")
            .isBlockedProfile(false)
            .passengerProfileList(EXPECTED_PASSANGER_PROFILE_LIST)
            .userId(2L)
            .build();
    private final List<UserProfile> ANSWER_USER_PROFILE_LIST = new ArrayList<>();
    private final UserProfile EXPECTED_USER_PROFILE = UserProfile.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(11111111)
            .email("admin@gmail.com")
            .isBlockedProfile(false)
            .passengerProfileList(EXPECTED_PASSANGER_PROFILE_LIST)
            .userId(1L)
            .build();

    private final UserProfile EXPECTED_USER_PROFILE_UPDATE = UserProfile.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(11111111)
            .email("admin@gmail.com")
            .isBlockedProfile(false)
            .passengerProfileList(EXPECTED_PASSANGER_PROFILE_LIST)
            .userId(1L)
            .build();
    private final UserProfile EXPECTED_USER_PROFILE_2 = UserProfile.builder()
            .id(2L)
            .profilename("User")
            .lastname("User")
            .phone(2222222)
            .email("user@gmail.com")
            .isBlockedProfile(false)
            .passengerProfileList(EXPECTED_PASSANGER_PROFILE_LIST)
            .userId(2L)
            .build();
    private final List<UserProfile> EXPECTED_USER_PROFILE_LIST = new ArrayList<>();

    private static final Long ID_2L = 2L;
    private static final Long ID_100L = 100L;
    private static final List<Long> LIST_IDS = new ArrayList<>();
    private static final String ERROR_INVALID_DATA_MESSAGE = "Name must not be null";
    private static final String ERROR_DATA_NOT_FOUND_MESSAGE = "This id = 100 not found!";

    @Test
    void whenCreateEntity_thenReturnEntity() {
        Mockito.when(userProfileDAO.save(GIVEN_USER_PROFILE)).thenReturn(ANSWER_USER_PROFILE);
        UserProfile ACTUAL = userProfileServiceL1.create(GIVEN_USER_PROFILE);
        assertEquals(EXPECTED_USER_PROFILE, ACTUAL);
        Mockito.verify(userProfileDAO, Mockito.times(1))
                .save(GIVEN_USER_PROFILE);
    }

    @Test
    void whenCreateEntity_thenReturnErrorInvalidData() {
        Exception exception = assertThrows(ErrorInvalidData.class, () -> {
                    userProfileServiceL1.create(USER_PROFILE_NAME_NULL);
                }
        );
        String actual = exception.getMessage();
        assertTrue(actual.contains(ERROR_INVALID_DATA_MESSAGE));
    }

    @Test
    void whenReadAllEntities_thenReturnAllEntities() {
        Mockito.when(userProfileDAO.findAll()).thenReturn(ANSWER_USER_PROFILE_LIST);
        List<UserProfile> ACTUAL = userProfileServiceL1.readAll();
        assertEquals(EXPECTED_USER_PROFILE_LIST, ACTUAL);
        Mockito.verify(userProfileDAO, Mockito.times(1)).findAll();
    }

    @Test
    void whenReadEntityById_thenReturnEntity() {
        Mockito.when(userProfileDAO.findById(ID_2L)).thenReturn(Optional.of(ANSWER_USER_PROFILE_2));
        UserProfile ACTUAL = userProfileServiceL1.readById(ID_2L);
        assertEquals(EXPECTED_USER_PROFILE_2, ACTUAL);
        Mockito.verify(userProfileDAO, Mockito.times(1)).findById(ID_2L);
    }

    @Test
    void whenReadEntityById_thenThrowErrorDataNotFound() {
        Exception exception = assertThrows(ErrorDataNotFound.class, () -> {
                    userProfileServiceL1.readById(ID_100L);
                }
        );
        String actual = exception.getMessage();
        assertTrue(actual.contains(ERROR_DATA_NOT_FOUND_MESSAGE));
    }

    @Test
    void whenReadAllEntitiesById_thenReturnListAllEntitiesById() {
        Mockito.when(userProfileDAO.findAllById(LIST_IDS)).thenReturn(ANSWER_USER_PROFILE_LIST);
        List<UserProfile> ACTUAL = userProfileServiceL1.readAllByIds(LIST_IDS);
        assertEquals(EXPECTED_USER_PROFILE_LIST, ACTUAL);
        Mockito.verify(userProfileDAO, Mockito.times(1)).findAllById(LIST_IDS);
    }

    @Test
    void whenDeleteEntityById_thenReturnDeleteEntity() {
        Mockito.when(userProfileDAO.findById(ID_2L)).thenReturn(Optional.of(ANSWER_USER_PROFILE_2));
        UserProfile ACTUAL = userProfileServiceL1.deleteById(ID_2L);
        assertEquals(EXPECTED_USER_PROFILE_2, ACTUAL);
        Mockito.verify(userProfileDAO, Mockito.times(1)).deleteById(ID_2L);
    }

    @Test
    void whenDeleteEntityById_thenThrowErrorDataNotFound() {
        Exception exception = assertThrows(ErrorDataNotFound.class, () -> {
                    userProfileServiceL1.deleteById(ID_100L);
                }
        );
        String actual = exception.getMessage();
        assertTrue(actual.contains(ERROR_DATA_NOT_FOUND_MESSAGE));
    }

    @Test
    void whenDeleteAllEntitiesById_thenReturnDeleteAllEntitiesById() {
        Mockito.when(userProfileDAO.findAllById(LIST_IDS)).thenReturn(ANSWER_USER_PROFILE_LIST);
        List<UserProfile> ACTUAL = userProfileServiceL1.deleteAllByIds(LIST_IDS);
        assertEquals(EXPECTED_USER_PROFILE_LIST, ACTUAL);
        Mockito.verify(userProfileDAO, Mockito.times(1)).deleteAllById(LIST_IDS);
    }

    @Test
    void whenUpdateEntity_thenReturnEntity() {
        Mockito.when(userProfileDAO.save(GIVEN_USER_PROFILE_UPDATE)).thenReturn(ANSWER_USER_PROFILE_UPDATE);
        UserProfile ACTUAL = userProfileServiceL1.update(GIVEN_USER_PROFILE_UPDATE);
        assertEquals(EXPECTED_USER_PROFILE_UPDATE, ACTUAL);
        Mockito.verify(userProfileDAO, Mockito.times(1))
                .save(GIVEN_USER_PROFILE_UPDATE);
    }

    @Test
    void whenUpdateEntity_thenReturnErrorInvalidData() {
        Exception exception = assertThrows(ErrorInvalidData.class, () -> {
                    userProfileServiceL1.update(USER_PROFILE_NAME_NULL);
                }
        );
        String actual = exception.getMessage();
        assertTrue(actual.contains(ERROR_INVALID_DATA_MESSAGE));
    }
}
