<%--
  Created by IntelliJ IDEA.
  User: lisih
  Date: 16.05.2024
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div>
    <span>Content. Русский</span>
    <p>Size: ${requestScope.departments.size()}</p>
    <p>DepartmentsMap: ${sessionScope.departmentsMap} </p>
    <p> JSESSION id:  ${cookie["JSESSIONID"]}</p>
    <p> HEADER: ${header["Cookie"]}</p>
    <p> Param id: ${param.id}</p>
    <p> Param test: ${param.test}</p>
    <p> Empty DepartmentsMap? ${empty departmentsMap} </p>



</div>
<%@ include file="footer.jsp" %>
</body>
</html>
