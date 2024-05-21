package app.servlet;

import app.service.EmployeeService;
import app.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
    private final EmployeeService employeeService = EmployeeService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer departmentId = Integer.valueOf(req.getParameter("departmentId"));
        req.setAttribute("employees", employeeService.findAllByDepartmentId(departmentId));
        req.getRequestDispatcher(JspHelper.getPath("employees")).forward(req,resp);


//        resp.setContentType("text/html");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        try (PrintWriter writer = resp.getWriter()) {
//            writer.write("<h1>Список работников отдела</h1>");
//            writer.write("<ul>");
//            employeeService.findAllByDepartmentId(departmentId).forEach(employeeDto ->
//                writer.write(String.format("" +
//                        "<li>\n" +
//                        "   %s\n " +
//                        "</li>", employeeDto.getDescription())));
//            writer.write("</ul>");
//        }
    }
}
