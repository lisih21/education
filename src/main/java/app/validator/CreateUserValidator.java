package app.validator;

import app.dao.UserDao;
import app.dto.CreateUserDto;
import app.entity.Gender;
import app.entity.Role;
import app.util.ConnectionManager;
import app.util.LocalDateFormatter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateUserValidator implements Validator<CreateUserDto>{

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();
    UserDao userDao = UserDao.getInstance();

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
        if(object.getImage().getSubmittedFileName().isEmpty()) {
            validationResult.add(Error.of("invalid.image", "image is invalid"));
        }

        if (userDao.containsDuplicateEmail(object.getEmail())) {
            validationResult.add(Error.of("invalid.email", "this email has already been registered"));
        }
        if( object.getEmail().isEmpty()
                || !object.getEmail().contains("@")
                || (!object.getEmail().contains(".com") && !object.getEmail().contains(".ru"))) {
            validationResult.add(Error.of("invalid.email", "email is invalid"));
        }
        if(Role.find(object.getRole()).isEmpty()) {
            validationResult.add(Error.of("invalid.role", "role is invalid"));
        }

        return validationResult;
    }
}
