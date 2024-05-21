<%--
  Created by IntelliJ IDEA.
  User: lisih
  Date: 17.05.2024
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${not empty requestScope.employees}">
<h1>Список сотрудников:</h1>
<ul>
    <c:forEach var="employee" items="${requestScope.employees}">
        <li> ${employee.description}</li>
    </c:forEach>
</ul>
    </c:if>
</body>
</html>
