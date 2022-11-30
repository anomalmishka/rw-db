package org.example.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PassengerProfilePage {
    private Long id;
    private String passengername;
    private String passengerlastname;
    private String passportNumber;
}

