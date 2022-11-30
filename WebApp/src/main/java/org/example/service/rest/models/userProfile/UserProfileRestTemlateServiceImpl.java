package org.example.service.rest.models.userProfile;

import org.example.dto.models.L2.UserProfileDTOL2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserProfileRestTemlateServiceImpl implements UserProfileRestTemlateService {
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;
    private final String PATH = "/modif/user/profile/";

    @Override
    public List<UserProfileDTOL2> readAll() {
        String uriVar = "read/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserProfileDTOL2> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserProfileDTOL2[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, UserProfileDTOL2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public UserProfileDTOL2 readById(Long id) {
        String uriVar = "read/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserProfileDTOL2> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserProfileDTOL2> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, UserProfileDTOL2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<UserProfileDTOL2> readAllByIds(List<Long> ids) {
        String uriVar = "read/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<UserProfileDTOL2[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, UserProfileDTOL2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public UserProfileDTOL2 create(UserProfileDTOL2 userProfileDTOL2) {
        String uriVar = "create";
        HttpEntity<UserProfileDTOL2> httpEntity = new HttpEntity<>(userProfileDTOL2);
        ResponseEntity<UserProfileDTOL2> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, UserProfileDTOL2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public UserProfileDTOL2 update(UserProfileDTOL2 userProfileDTOL2) {
        String uriVar = "update";
        HttpEntity<UserProfileDTOL2> httpEntity = new HttpEntity<>(userProfileDTOL2);
        ResponseEntity<UserProfileDTOL2> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.PUT, httpEntity, UserProfileDTOL2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public UserProfileDTOL2 deleteById(Long id) {
        String uriVar = "delete/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserProfileDTOL2> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserProfileDTOL2> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, UserProfileDTOL2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<UserProfileDTOL2> deleteAllByIds(List<Long> ids) {
        String uriVar = "delete/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<UserProfileDTOL2[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, UserProfileDTOL2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
