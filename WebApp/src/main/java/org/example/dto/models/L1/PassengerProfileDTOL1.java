package org.example.dto.models.L1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PassengerProfileDTOL1 {
    private Long id;
    private String passengername;
    private String passengerlastname;
    private String passportNumber;
}

