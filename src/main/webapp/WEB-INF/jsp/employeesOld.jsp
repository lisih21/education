<%@ page import="app.service.DepartmentService" %>
<%@ page import="app.service.EmployeeService" %>
<%@ page import="app.dto.EmployeeDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lisih
  Date: 16.05.2024
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri =""%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Список департаментов</h1>
    <ul>
        <%
           Integer departmentId = Integer.valueOf(request.getParameter("departmentId"));
           List<EmployeeDto> employees = EmployeeService.getInstance().findAllByDepartmentId(departmentId);
           for (EmployeeDto employee : employees) {
               out.write(String.format("<li>%s</li>", employee.getDescription()));
           }
    %>
    </ul>
</body>
</html>
