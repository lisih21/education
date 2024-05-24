<%--
  Created by IntelliJ IDEA.
  User: lisih
  Date: 22.05.2024
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post">

    <label style="color: darkviolet"> I am login page </label> <br>
    <img src="${pageContext.request.contextPath}/image/form/addLogin.jpg" alt="User image"> <br>
    <label for="emailId">Email:
        <input type="text" name="email" id="emailId" value="${param.email}" required> <br>
    </label>
    <label for="passwordId">Password:
        <input type="password" name="password" id="passwordId" required> <br>
    </label>
    <button type="submit" style="color: darkslateblue">Login</button>
    <a href="${pageContext.request.contextPath}/registration">
        <button type="button" style="color: darkslateblue">Register</button>
    </a>
    <c:if test="${param.error !=null}">
        <div style="color: red">
            <span>Email or password is not correct</span>
        </div>
    </c:if>
</form>


</body>
</html>
