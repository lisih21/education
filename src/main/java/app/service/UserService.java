package app.service;

import app.dao.UserDao;
import app.dto.CreateUserDto;
import app.dto.UserDto;
import app.entity.User;
import app.exception.ValidationException;
import app.mapper.CreateUserMapper;
import app.mapper.UserMapper;
import app.validator.CreateUserValidator;
import app.validator.ValidationResult;
import lombok.SneakyThrows;

import java.util.Optional;

public class UserService {
    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();

    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password).map(userMapper::mapFrom);
        }

    @SneakyThrows
    public Integer create(CreateUserDto userDto) {
        // validation
        ValidationResult validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        // mapping dto into userEntity
        User userEntity = createUserMapper.mapFrom(userDto);
        //save entity in bd
        imageService.upload(userEntity.getImage(), userDto.getImage().getInputStream());
        userDao.save(userEntity);

        return userEntity.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

    private UserService() {
    }
}
