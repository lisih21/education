package app.service;

import app.dao.EmployeeDao;
import app.dto.EmployeeDto;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    private static final EmployeeService INSTANCE = new EmployeeService();
    private final EmployeeDao employeeDao = EmployeeDao.getInstance();

    private EmployeeService() {
    }

    public static EmployeeService getInstance() {
        return INSTANCE;
    }

    public List<EmployeeDto> findAllByDepartmentId(Integer departmentId) {
        return employeeDao.findAllByDepartmentId(departmentId).stream()
                .map(employee -> EmployeeDto.builder()
                        .id(employee.getId())
                        .description(String.format("%s  %s",
                                employee.getFirstName(),
                                employee.getLastName()))
                        .build())
                .collect(Collectors.toList());
    }
}
