package app.servlet;

import app.service.DepartmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/departments")
public class DepartmentServlet extends HttpServlet {
    private final DepartmentService departmentService = DepartmentService.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Список департаментов</h1>");
            writer.write("<ul>");
            departmentService.findAll().forEach(departmentDto -> {
                writer.write(String.format("" +
                        "<li>\n" +
                        "   <a href=\"/employees?departmentId=%d\">%s</a>\n" +
                        "</li>", departmentDto.getId(), departmentDto.getDescription()));
            });
            writer.write("</ul>");
        }
    }
}
