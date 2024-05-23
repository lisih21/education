package app.dto;

import app.entity.Gender;
import app.entity.Role;
import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class CreateUserDto {
    String name;
    String birthday;
    String email;
    String password;
    String role;
    String gender;
}
