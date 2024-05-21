package app.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate date;
    private Integer salary;
    private String job;
    private Double commission;
    private String phoneNumber;
    private Integer departmentId;
    private Integer managerId;
}
