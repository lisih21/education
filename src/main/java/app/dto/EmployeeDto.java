package app.dto;

import lombok.*;

@Value
@Builder
public class EmployeeDto {
    Integer id;
    String description;
}
