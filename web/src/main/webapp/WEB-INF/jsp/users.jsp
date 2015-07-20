<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/20/15
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>user management</title>
</head>
<body>

<h1>user management</h1>

<table border=1 style="position:absolute; left: 400px;">
    <thead>
    <tr>
        <th>Name</th>
        <th>Password</th>
        <th>Operation</th>
        <th>Operation</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td><a href="./users/modification/<c:out value="${user.id}"/>">Update</a></td>
            <td><a href="./users/deletion/<c:out value="${user.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
