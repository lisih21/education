package app.dto;

import lombok.Getter;

import java.util.Objects;

@Getter
public class EmployeeDto {

    private final Integer id;
    private final String description;


    public EmployeeDto(Integer id,  String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
