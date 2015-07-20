<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/20/15
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>

<form method="POST" action="" style="position:absolute; left: 350px;">
    Name : <input
        type="text" name="name"
        value="<c:out value="${employee.name}" />"/> <br/>
    Role: <input
        type="text" name="role"
        value="<c:out value="${employee.role}" />"/> <br/>
    Email: <input
        type="text" name="email"
        value="<c:out value="${employee.email}" />"/> <br/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>
