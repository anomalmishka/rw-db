package org.example.service.rest.filter.userProfile;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.L2.UserProfileDTOL2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class UserProfileRestTemplateFilterImpl implements UserProfileRestTemplateFilter {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;

    @Override
    public UserProfileDTOL2 findWhereUserId(Long userId) {
        String url = DATA_BASE_APP_URL + "/filter/user/profile/where/user/" + userId + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserProfileDTOL2> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserProfileDTOL2> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET,
                        httpEntity, UserProfileDTOL2.class);
        return responseEntity.getBody();
    }
}
