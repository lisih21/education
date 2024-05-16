package app.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter

public class Department {
    private Integer id;
    private String name;
    private Integer managerId;
    private Integer locationId;
    private DepartmentStatus status;

    public Department(Integer id, String name, Integer managerId, Integer locationId, DepartmentStatus status) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
        this.locationId = locationId;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerId=" + managerId +
                ", locationId=" + locationId +
                ", status=" + status +
                '}';
    }
}
