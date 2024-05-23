package app.mapper;

import app.dto.CreateUserDto;
import app.entity.Gender;
import app.entity.Role;
import app.entity.User;
import app.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();
    private static final String IMAGE_FOLDER = "user/";

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }

    private CreateUserMapper() {
    }

    @Override
    public User mapFrom(CreateUserDto object) {

        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .image(IMAGE_FOLDER + object.getName() + object.getImage().getSubmittedFileName())
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .build();
    }
}
