<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/21/15
  Time: 12:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>customer management</title>
</head>
<body>

<h1>customer management</h1>

<table border=1 style="position:absolute; left: 400px;">
    <thead>
    <tr>
        <th>Name</th>
        <%--<th>Coach</th>--%>
        <th>Operation</th>
        <th>Operation</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td><c:out value="${customer.name}"/></td>
            <%--<td><c:out value="${customer.coach}"/></td>--%>
            <td><a href="./customers/modification/<c:out value="${customer.id}"/>">Update</a></td>
            <td><a href="./customers/deletion/<c:out value="${customer.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h3 style="position:absolute; left: 260px;"><a href="./customers/creation">Add Customer</a></h3>
</body>
