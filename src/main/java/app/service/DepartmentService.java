package app.service;

import app.dao.DepartmentDao;
import app.dto.DepartmentDto;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentService {
    private final static DepartmentService INSTANCE = new DepartmentService();
    private final DepartmentDao departmentDao = DepartmentDao.getInstance();

    private DepartmentService() {
    }

    public static DepartmentService getINSTANCE() {
        return INSTANCE;
    }

    public List<DepartmentDto> findAll() {
        return departmentDao.findAll().stream()
                .map(department -> new DepartmentDto(
                        department.getId(),
                        String.format("%s - %s - %s",
                                department.getName(),
                                department.getId(),
                                department.getStatus())))
                .collect(Collectors.toList());
    }
}
