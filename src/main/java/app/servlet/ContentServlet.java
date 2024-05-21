package app.servlet;

import app.dto.DepartmentDto;
import app.service.DepartmentService;
import app.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toMap;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {
    private final DepartmentService departmentService = DepartmentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DepartmentDto> departmentsDto = departmentService.findAll();
        req.setAttribute("departments", departmentsDto);
        req.getSession().setAttribute("departmentsMap", departmentsDto.stream()
                .collect(toMap(DepartmentDto::getId, DepartmentDto::getDescription)));
        req.getRequestDispatcher(JspHelper.getPath("content")).forward(req, resp);
    }
}
