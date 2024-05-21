package app.entity;

import lombok.*;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Department {
    private Integer id;
    private String name;
    private Integer managerId;
    private Integer locationId;
    private DepartmentStatus status;
}
