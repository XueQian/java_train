<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/19/15
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>COACH IS BUSY!!</title>
</head>
<body>
<h1>您所修改的课程教练时间冲突，请重新操作!</h1>
<a href="/web/courses">回到公共课主页</a>
<a href="/web/courses/modification/<c:out value="${course.id}"/>">重新修改课程</a>
</body>
</html>
