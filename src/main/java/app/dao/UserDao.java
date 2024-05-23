package app.dao;

import app.entity.User;
import app.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class UserDao implements Dao<Integer, User> {

    private static final UserDao INSTANCE = new UserDao();
    private String SAVE_SQL = "insert into users(name, birthday, email, password, role, gender, image) values " +
            "(?, ?, ?, ?, ?, ?, ?)";

    private static final String CHECK_EMAIL = "select * from users where email = ?";
    private static Logger logger = Logger.getLogger(UserDao.class.getName());

    public static UserDao getInstance() {
        return INSTANCE;
    }

    private UserDao() {
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    @SneakyThrows
    public User save(User entity) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getBirthday());
            preparedStatement.setObject(3, entity.getEmail());
            preparedStatement.setObject(4, entity.getPassword());
            preparedStatement.setObject(5, entity.getRole().name());
            preparedStatement.setObject(6, entity.getGender().name());
            preparedStatement.setObject(7, entity.getImage());

            preparedStatement.executeUpdate();
            logger.info("UserDao transformed entity into table");
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));

            return entity;
        }
    }

    @SneakyThrows
    public boolean containsDuplicateEmail(String email) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(CHECK_EMAIL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }
}