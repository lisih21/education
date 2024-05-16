package app.dao;

import app.util.ConnectionManager;
import app.entity.Department;
import app.entity.DepartmentStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmentDao implements Dao<Integer, Department> {
    private static final DepartmentDao INSTANCE = new DepartmentDao();

    public static DepartmentDao getInstance() {
        return INSTANCE;
    }

    private DepartmentDao() {
    }

    private static final String FIND_ALL = "select " +
            "id, " +
            "name, " +
            "manager_id, " +
            "location_id, " +
            "status " +
            "from departments";

    @Override
    public List<Department> findAll() {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Department> departments = new ArrayList<>();
            while (resultSet.next()) {
                departments.add(buildDepartment(resultSet));
            }
            return departments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Department> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Department entity) {}

    @Override
    public Department save(Department entity) {
        return null;
    }

    private Department buildDepartment(ResultSet resultSet) {
        try {
            return new Department(
                    resultSet.getObject("id", Integer.class),
                    resultSet.getObject("name", String.class),
                    resultSet.getObject("manager_id", Integer.class),
                    resultSet.getObject("location_id", Integer.class),
                    DepartmentStatus.valueOf(resultSet.getObject("status", String.class)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
