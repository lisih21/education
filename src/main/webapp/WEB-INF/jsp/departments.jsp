<%--
  Created by IntelliJ IDEA.
  User: lisih
  Date: 21.05.2024
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>Departments</title>
</head>
<body>

  <h1>Список департаментов:</h1>
  <ul>
    <c:forEach var="department" items="${requestScope.departments}">
      <li>
        <a href="${pageContext.request.contextPath}/employees?departmentId=${department.id}">${department.description}</a>
      </li>
    </c:forEach>
  </ul>

</body>
</html>

