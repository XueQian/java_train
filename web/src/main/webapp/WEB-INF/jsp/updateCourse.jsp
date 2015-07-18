<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/8/15
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<form method="POST" action="" style="position:absolute; left: 350px;">
    Name : <input
        type="text" name="name"
        value="<c:out value="${course.name}" />"/> <br/>
    Coach: <input
        type="text" name="sex"
        value="<c:out value="${course.coach}" />"/> <br/>
    Time : <input
        type="text" name="address"
        value="<c:out value="${course.time}" />"/> <br/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>