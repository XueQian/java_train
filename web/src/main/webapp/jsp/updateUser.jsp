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

<form method="POST" action="">
    <%--Id : <input type="text" readonly="readonly" name="id"--%>
                <%--value="<c:out value="${user.id}" />"/> <br/>--%>
    Name : <input
        type="text" name="name"
        value="<c:out value="${user.name}" />"/> <br/>
    Sex: <input
        type="text" name="sex"
        value="<c:out value="${user.sex}" />"/> <br/>
    Address : <input
        type="text" name="address"
        value="<c:out value="${user.address}" />"/> <br/>
    Age : <input type="text" name="age"
                 value="<c:out value="${user.age}" />"/> <br/>
    <input type="submit" value="update"/>
</form>

</body>
</html>