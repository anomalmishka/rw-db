package org.example.service.rest.models.passengerProfile;

import org.example.dto.models.L2.PassengerProfileDTOL2;
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
public class PassengerProfileRestTemlateServiceImpl implements PassengerProfileRestTemlateService {
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;
    private final String PATH = "/modif/passenger/profile/";

    @Override
    public List<PassengerProfileDTOL2> readAll() {
        String uriVar = "read/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PassengerProfileDTOL2> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<PassengerProfileDTOL2[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, PassengerProfileDTOL2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public PassengerProfileDTOL2 readById(Long id) {
        String uriVar = "read/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PassengerProfileDTOL2> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<PassengerProfileDTOL2> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, PassengerProfileDTOL2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<PassengerProfileDTOL2> readAllByIds(List<Long> ids) {
        String uriVar = "read/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<PassengerProfileDTOL2[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, PassengerProfileDTOL2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public PassengerProfileDTOL2 create(PassengerProfileDTOL2 passengerProfileDTOModif) {
        String uriVar = "create";
        HttpEntity<PassengerProfileDTOL2> httpEntity = new HttpEntity<>(passengerProfileDTOModif);
        ResponseEntity<PassengerProfileDTOL2> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, PassengerProfileDTOL2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public PassengerProfileDTOL2 update(PassengerProfileDTOL2 passengerProfileDTOModif) {
        String uriVar = "update";
        HttpEntity<PassengerProfileDTOL2> httpEntity = new HttpEntity<>(passengerProfileDTOModif);
        ResponseEntity<PassengerProfileDTOL2> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.PUT, httpEntity, PassengerProfileDTOL2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public PassengerProfileDTOL2 deleteById(Long id) {
        String uriVar = "delete/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PassengerProfileDTOL2> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<PassengerProfileDTOL2> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, PassengerProfileDTOL2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<PassengerProfileDTOL2> deleteAllByIds(List<Long> ids) {
        String uriVar = "delete/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<PassengerProfileDTOL2[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, PassengerProfileDTOL2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
