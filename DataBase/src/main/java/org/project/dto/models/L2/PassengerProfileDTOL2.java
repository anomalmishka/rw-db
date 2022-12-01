package org.project.dto.models.L2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.dto.models.L1.UserProfileDTOL1;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PassengerProfileDTOL2 {
    private Long id;
    private String passengername;
    private String passengerlastname;
    private String passportNumber;
    private UserProfileDTOL1 userProfile;
}


