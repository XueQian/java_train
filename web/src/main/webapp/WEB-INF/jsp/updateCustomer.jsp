<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/21/15
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Customer</title>
</head>
<body>

<form method="POST" action="" style="position:absolute; left: 350px;">
    Name : <input
        type="text" name="name"
        value="<c:out value="${customer.name}" />"/> <br/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>