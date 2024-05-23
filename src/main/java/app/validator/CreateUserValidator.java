package app.validator;

import app.dto.CreateUserDto;
import app.entity.Gender;
import app.entity.Role;
import app.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto>{

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
    private CreateUserValidator(){}

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        ValidationResult validationResult = new ValidationResult();

        if (object.getGender()==null || Gender.find(object.getGender()).isEmpty()) {
            validationResult.add(Error.of("invalid.gender", "gender is invalid"));
        }
        if(!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid.birthday", "birthday is invalid"));
        }
        if(object.getName().isEmpty()) {
            validationResult.add(Error.of("invalid.name", "name is invalid"));
        }
        if(object.getPassword().isEmpty()) {
            validationResult.add(Error.of("invalid.password", "password is invalid"));
        }
        if(object.getEmail().isEmpty()) {
            validationResult.add(Error.of("invalid.email", "email is invalid"));
        }
        if(Role.find(object.getRole()).isEmpty()) {
            validationResult.add(Error.of("invalid.role", "role is invalid"));
        }

        return validationResult;
    }
}
