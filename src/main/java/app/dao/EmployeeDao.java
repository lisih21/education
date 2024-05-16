package app.dao;

import app.entity.Employee;
import app.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class EmployeeDao implements Dao<Integer, Employee> {
    private static Logger logger  = Logger.getLogger(EmployeeDao.class.getName());
    private static final EmployeeDao INSTANCE = new EmployeeDao();
    private String FIND_ALL_BY_DEPARTMENT_ID = "select " +
            "id, " +
            "first_name, " +
            "last_name, " +
            "date, " +
            "salary, " +
            "job, " +
            "commission, " +
            "phone_number, " +
            "department_id, " +
            "manager_id " +
            "from employees where department_id=?";

    private EmployeeDao() {
    }

    public static EmployeeDao getInstance() {
        return INSTANCE;
    }


    public List<Employee> findAllByDepartmentId(Integer departmentId) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(FIND_ALL_BY_DEPARTMENT_ID)) {
            preparedStatement.setObject(1, departmentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            logger.info("Method findAllByDepartmentId after create resultSet");
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = buildEmployee(resultSet);
                employees.add(employee);
                logger.info("Method findAllByDepartmentId. Employee " +employee + " added" );
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Employee entity) {

    }

    @Override
    public Employee save(Employee entity) {
        return null;
    }

    private Employee buildEmployee(ResultSet resultSet) {
        try {
            logger.info("Method buildEmployee before create Employee");
            return new Employee(
                    resultSet.getObject("id", Integer.class),
                    resultSet.getObject("first_name", String.class),
                    resultSet.getObject("last_name", String.class),
                    Optional.of(resultSet.getDate("date")).map(Date::toLocalDate).get(),
                    resultSet.getObject("salary", Integer.class),
                    resultSet.getObject("job", String.class),
                    Optional.of(resultSet.getDouble("commission")).get(),
                    Optional.of(resultSet.getString("phone_number")).get(),
                    Optional.of(resultSet.getInt("department_id")).get(),
                    Optional.of(resultSet.getInt("manager_id")).get());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
