<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/17/15
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>SHOW COURSES!!</title>
</head>
<body>

<h1>show courses</h1>

<table border=1 style="position:absolute; left: 400px;">
    <thead>
    <tr>
        <th>Name</th>
        <th>Coach</th>
        <th>Time</th>
        <th>Operation</th>
        <th>Operation</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${courses}" var="course">
        <tr>
            <td><c:out value="${course.name}"/></td>
            <td><c:out value="${course.coach}"/></td>
            <td><c:out value="${course.time}"/></td>
            <td><a href="./courses/modification/<c:out value="${course.id}"/>">Update</a></td>
            <td><a href="./courses/deletion/<c:out value="${course.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h3 style="position:absolute; left: 200px;"><a href="./courses/creation">Add Public Course</a></h3>

<h3 style="position:absolute; left: 200px;top:100px;"><a href="./courses/private/creation">Add Private Coach</a></h3>

<h3 style="position:absolute; left: 200px;top:130px;"><a href="./users">User Management</a></h3>

<h3 style="position:absolute; left: 200px;top:160px;"><a href="./employees">Employee Management</a></h3>

</body>
</html>
