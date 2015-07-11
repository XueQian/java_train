<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/8/15
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>用户信息页面</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Sex</th>
        <th>Address</th>
        <th>age</th>
        <th>Operation</th>
        <th>Operation</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.name}" /></td>
            <td><c:out value="${user.sex}" /></td>
            <td><c:out value="${user.address}" /></td>
            <td><c:out value="${user.age}" /></td>
            <td><a href="?action=update&id=<c:out value="${user.id}"/>">Update</a></td>
            <td><a href="?action=delete&id=<c:out value="${user.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="./addUser">Add User</a></p>

</body>
</html>

