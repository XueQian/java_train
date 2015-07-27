<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/23/15
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>SHOW COURSES!!</title>
    <link href="../../css/updateCourse.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="navigationBar">
    <ul>
        <li id="highLight1"><a id="highLight" href="/web/courses">课程管理</a></li>
        <li><a href="/web/schedules/">课表管理</a></li>
        <li><a href="/web/users/">用户管理</a></li>
        <li><a href="/web/employees/">雇员管理</a></li>
        <li><a href="/web/customers/">顾客管理</a></li>
    </ul>
</div>

<div class="formCss">
    <form method="POST" action="" class="form" id="updateCourse">
        <input id="courseId" value="${course.id}" hidden="hidden"/>

        <div id="input1">课程名称 <input type="text" name="name" value="<c:out value="${course.name}" />" readonly="readonly"/><br/></div>

        <div id="input2">课程描述<input type="text" name="description" value="<c:out value="${course.description}" />"/>
            <br/></div>
        <input id="submit" type="submit" value="Submit"/>
    </form>
</div>

<script src="../../lib/js/jquery-1.11.1.min.js"></script>
<script src="../../js/updateCourse.js"></script>

</body>
</html>