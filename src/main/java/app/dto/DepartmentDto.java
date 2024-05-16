package app.dto;

import lombok.Getter;
import java.util.Objects;

@Getter
public class DepartmentDto {
    private final Integer id;
    private final String description;

    public DepartmentDto(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentDto that = (DepartmentDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
