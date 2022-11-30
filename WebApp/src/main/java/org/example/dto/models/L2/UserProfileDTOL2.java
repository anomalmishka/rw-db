package org.example.dto.models.L2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserProfileDTOL2 {
    private Long id;
    private String profilename;
    private String lastname;
    private Integer phone;
    private String email;
    private Boolean isBlockedProfile;
    private Long userId;
    private List<PassengerProfileDTOL2> passengerProfileList;
}

