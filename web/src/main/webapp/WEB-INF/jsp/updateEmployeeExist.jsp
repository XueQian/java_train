<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/21/15
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EMPLOYEE IS EXIST!!</title>
</head>
<body>
<h1>该用户名已经存在，请重新操作!</h1>
<a href="/web/employees">回到雇员管理页面</a>
<a href="/web/employees/modification/<c:out value="${employee.id}"/>">重新修改雇员</a>
</body>
</html>

