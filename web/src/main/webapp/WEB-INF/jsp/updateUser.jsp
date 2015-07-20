<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/20/15
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>

<form method="POST" action="" style="position:absolute; left: 350px;">
    Name : <input
        type="text" name="name"
        value="<c:out value="${user.name}" />"/> <br/>
    Coach: <input
        type="text" name="password"
        value="<c:out value="${user.password}" />"/> <br/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>
