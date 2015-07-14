<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/8/15
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<html>
<head>
    <title>VIEW USERS</title>
    <spring:url value="lib/js/jquery-1.11.1.min.js" var="jQuery"/><script src="${jQuery}"></script>
    <spring:url value="js/user.js" var="user"/><script src="${user}"></script>
</head>
<body>
<table border=1  style="position:absolute; left: 350px;">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Sex</th>
        <th>Address</th>
        <th>age</th>
        <th>password</th>
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
            <td><c:out value="${user.password}"/> </td>
            <td><a href="./users/modification/<c:out value="${user.id}"/>">Update</a></td>
            <td><a href="javascript:;"onclick="deleteUserById(<c:out value="${user.id}" />);">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p style="position:absolute; left: 280px;"><a href="./users/creation">Add User</a></p>

</body>
</html>

