<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/22/15
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>SHOW COURSES!!</title>
    <link href="./css/courses.css" rel="stylesheet" type="text/css">
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
    <form method="POST" action="/web/courses/creation" class="form" id="addCourse">

        课程名称 : <label>
        <input id="input1" type="text" name="name"/>
    </label>
        描述 : <label>
        <input id="input2"
               type="text" name="description"/>
    </label>
        <input id="submit" type="submit" value="Submit"/>
    </form>
</div>

<div class="tableCss">
    <table>
        <thead>
        <tr>
            <th>课程名称</th>
            <th>描述</th>
            <th>Operation</th>
            <th>Operation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${courses}" var="course">
            <tr>
                <td><c:out value="${course.name}"/></td>
                <td><c:out value="${course.description}"/></td>
                <td id="update"><a id="button1" href="./courses/modification/<c:out value="${course.id}"/>">Update</a>
                </td>
                <td id="delete"><a id="button2" href="./courses/deletion/<c:out value="${course.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="lib/js/jquery-1.11.1.min.js"></script>
<script src="js/addCourse.js"></script>

</body>
</html>