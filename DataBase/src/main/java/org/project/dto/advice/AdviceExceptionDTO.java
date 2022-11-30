package org.project.dto.advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AdviceExceptionDTO {

    private String error;
    private Timestamp timestamp;
    private HttpStatus httpStatus;
    private String path;

}