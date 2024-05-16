package app.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
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

    public Employee(Integer id, String firstName, String lastName, LocalDate date, Integer salary, String job, Double commission, String phoneNumber, Integer departmentId, Integer managerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.salary = salary;
        this.job = job;
        this.commission = commission;
        this.phoneNumber = phoneNumber;
        this.departmentId = departmentId;
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date=" + date +
                ", salary=" + salary +
                ", commission=" + commission +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", departmentId=" + departmentId +
                ", managerId=" + managerId +
                '}';
    }
}
