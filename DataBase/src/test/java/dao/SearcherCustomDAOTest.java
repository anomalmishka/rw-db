package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.DataBase;
import org.project.dao.custom.searcher.SearcherCustomDAO;
import org.project.dto.searcher.Searcher;
import org.project.model.PassengerProfile;
import org.project.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataBase.class)
@ActiveProfiles("test")
@Transactional
@AutoConfigureTestDatabase
public class SearcherCustomDAOTest {

    @Autowired
    SearcherCustomDAO searcherCustomDAO;
    private final PassengerProfile passengerProfile = PassengerProfile.builder()
            .id(1L)
            .passengername("Admin")
            .passengerlastname("Admin")
            .passportNumber("KK0000000")
            .build();
    private final List<PassengerProfile> EXPECTED_PASSANGER_PROFILE_LIST = new ArrayList<>();

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
    private final List<UserProfile> EXPECTED_USER_PROFILE_LIST = new ArrayList<>();

    @Test
    public void whenFindUserProfile_thenReturnListEntity() {
        EXPECTED_PASSANGER_PROFILE_LIST.add(passengerProfile);
        EXPECTED_USER_PROFILE_LIST.add(EXPECTED_USER_PROFILE);
        Searcher GIVEN = Searcher.builder()
                .findContent("Admin")
                .build();
        List<UserProfile> ACTUAL_LIST = searcherCustomDAO.findUserProfile(GIVEN);
        assertEquals(EXPECTED_USER_PROFILE_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindPassengerProfile_thenReturnListEntity() {
        EXPECTED_PASSANGER_PROFILE_LIST.add(passengerProfile);
        Searcher GIVEN = Searcher.builder()
                .findContent("Admin")
                .build();
        List<PassengerProfile> ACTUAL_LIST = searcherCustomDAO.findPassengerProfile(GIVEN);
        assertEquals(EXPECTED_PASSANGER_PROFILE_LIST, ACTUAL_LIST);
    }
}
