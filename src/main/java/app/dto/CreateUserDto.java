package app.dto;

import app.entity.Gender;
import app.entity.Role;
import jakarta.servlet.http.Part;
import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class CreateUserDto {
    String name;
    String birthday;
    Part image;
    String email;
    String password;
    String role;
    String gender;
}
