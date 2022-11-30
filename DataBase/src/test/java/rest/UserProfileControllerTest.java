package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.project.DataBase;
import org.project.dto.models.L1.UserProfileDTOL1;
import org.project.model.PassengerProfile;
import org.project.model.UserProfile;
import org.project.service.model.L1.api.UserProfileServiceL1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = DataBase.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserProfileServiceL1 userProfileServiceL1;
    private static final ObjectMapper mapper = new ObjectMapper();

    private final PassengerProfile passengerProfile = PassengerProfile.builder()
            .id(1L)
            .passengername("Admin")
            .passengerlastname("Admin")
            .passportNumber("KK0000000")
            .build();
    private final List<PassengerProfile> PASSANGER_PROFILE_LIST = new ArrayList<>();
    private final UserProfile ANSWER_USER_PROFILE = UserProfile.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(11111111)
            .email("admin@gmail.com")
            .isBlockedProfile(false)
            .passengerProfileList(PASSANGER_PROFILE_LIST)
            .userId(1L)
            .build();

    private final UserProfile ANSWER_USER_PROFILE_UPDATE = UserProfile.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(11111111)
            .email("admin@gmail.com")
            .isBlockedProfile(false)
            .passengerProfileList(PASSANGER_PROFILE_LIST)
            .userId(1L)
            .build();
    private final UserProfileDTOL1 GIVEN_USER_PROFILE = UserProfileDTOL1.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(11111111)
            .email("admin@gmail.com")
            .isBlockedProfile(false)
            .userId(1L)
            .build();

    private final UserProfileDTOL1 GIVEN_USER_PROFILE_UPDATE = UserProfileDTOL1.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(11111111)
            .email("admin@gmail.com")
            .isBlockedProfile(false)
            .userId(1L)
            .build();
    private final List<UserProfile> ANSWER_USER_PROFILE_LIST = new ArrayList<>();
    private final UserProfileDTOL1 EXPECTED_USER_PROFILE = UserProfileDTOL1.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(11111111)
            .email("admin@gmail.com")
            .isBlockedProfile(false)
            .userId(1L)
            .build();
    private final UserProfileDTOL1 EXPECTED_USER_PROFILE_UPDATE = UserProfileDTOL1.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(11111111)
            .email("admin@gmail.com")
            .isBlockedProfile(false)
            .userId(1L)
            .build();
    private final List<UserProfileDTOL1> EXPECTED_USER_PROFILE_LIST = new ArrayList<>();
    private final Long GIVEN_ID = 1L;
    private final List<Long> GIVEN_ID_LIST = new ArrayList<>();

    @Before
    public void init(){
        PASSANGER_PROFILE_LIST.add(passengerProfile);
        ANSWER_USER_PROFILE_LIST.add(ANSWER_USER_PROFILE);
        EXPECTED_USER_PROFILE_LIST.add(EXPECTED_USER_PROFILE);
        GIVEN_ID_LIST.add(GIVEN_ID);
    }

    @Test
    public void test_Post_Create() throws Exception {
        Mockito.when(userProfileServiceL1.create(ArgumentMatchers.any())).thenReturn(ANSWER_USER_PROFILE);
        String GIVEN_JSON = mapper.writeValueAsString(GIVEN_USER_PROFILE);
        MvcResult requestResult = mockMvc.perform(post("/user/profile/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(GIVEN_JSON)
                        .characterEncoding("utf-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED_USER_PROFILE);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }

    @Test
    public void test_Get_ReadAll() throws Exception {
        Mockito.when(userProfileServiceL1.readAll()).thenReturn(ANSWER_USER_PROFILE_LIST);
        MvcResult requestResult = mockMvc.perform(get("/user/profile/read/all")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED_USER_PROFILE_LIST);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }

    @Test
    public void test_Get_ReadById() throws Exception {
        Mockito.when(userProfileServiceL1.readById(ArgumentMatchers.any())).thenReturn(ANSWER_USER_PROFILE);
        MvcResult requestResult = mockMvc.perform(get("/user/profile/read/" + GIVEN_ID + "/")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED_USER_PROFILE);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }

    @Test
    public void test_Post_ReadAllByIds() throws Exception {
        Mockito.when(userProfileServiceL1.readAllByIds(ArgumentMatchers.any())).thenReturn(ANSWER_USER_PROFILE_LIST);
        String GIVEN_JSON = mapper.writeValueAsString(GIVEN_ID_LIST);
        MvcResult requestResult = mockMvc.perform(post("/user/profile/read/all/id")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(GIVEN_JSON)
                        .characterEncoding("utf-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED_USER_PROFILE_LIST);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }

    @Test
    public void test_Put_Update() throws Exception {
        Mockito.when(userProfileServiceL1.update(ArgumentMatchers.any())).thenReturn(ANSWER_USER_PROFILE_UPDATE);
        String GIVEN_JSON = mapper.writeValueAsString(GIVEN_USER_PROFILE_UPDATE);
        MvcResult requestResult = mockMvc.perform(put("/user/profile/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(GIVEN_JSON)
                        .characterEncoding("utf-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED_USER_PROFILE_UPDATE);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }

    @Test
    public void test_Delete_DeleteById() throws Exception {
        Mockito.when(userProfileServiceL1.deleteById(ArgumentMatchers.any())).thenReturn(ANSWER_USER_PROFILE);
        String GIVEN_JSON = mapper.writeValueAsString(GIVEN_ID);
        MvcResult requestResult = mockMvc.perform(delete("/user/profile/delete/" + GIVEN_ID + "/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(GIVEN_JSON)
                        .characterEncoding("utf-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED_USER_PROFILE);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }

    @Test
    public void test_Delete_DeleteAllByIds() throws Exception {
        Mockito.when(userProfileServiceL1.deleteAllByIds(ArgumentMatchers.any())).thenReturn(ANSWER_USER_PROFILE_LIST);
        String GIVEN_JSON = mapper.writeValueAsString(GIVEN_ID_LIST);
        MvcResult requestResult = mockMvc.perform(delete("/user/profile/delete/all/id")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(GIVEN_JSON)
                        .characterEncoding("utf-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED_USER_PROFILE_LIST);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }
}
