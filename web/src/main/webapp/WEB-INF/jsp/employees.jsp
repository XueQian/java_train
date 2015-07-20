<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/20/15
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>employee management</title>
</head>
<body>

<h1>employee management</h1>

<table border=1 style="position:absolute; left: 400px;">
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th>Email</th>
        <th>Operation</th>
        <th>Operation</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td><c:out value="${employee.name}"/></td>
            <td><c:out value="${employee.role}"/></td>
            <td><c:out value="${employee.email}"/></td>
            <td><a href="./employees/modification/<c:out value="${employee.id}"/>">Update</a></td>
            <td><a href="./employees/deletion/<c:out value="${employee.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h3 style="position:absolute; left: 260px;"><a href="./employees/creation">Add Employee</a></h3>
</body>
