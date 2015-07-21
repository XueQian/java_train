<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/17/15
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>
<link href="${bootstrapCss}" rel="stylesheet"/>
<spring:url value="/lib/js/bootstrap.min.js" var="bootstrapJs"/>
<spring:url value="/lib/js/jquery-1.11.1.min.js" var="jqueryJs"/>
<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>

<html>
<head>
    <title>SHOW COURSES!!</title>
</head>
<body>

<div class="container">
    <div class="btn-toolbar bg-danger">

        <nav class="navbar-default">
            <ul class="nav nav-pills">
                <li role="presentation" class="active dropdown">
                    <a href="/web/courses" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false"><h3>课程管理</h3> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/web/courses/creation"><h4>添加公共课程</h4></a></li>
                        <li><a href="/web/courses/private/creation"><h4>添加私教课程</h4></a></li>
                    </ul>
                </li>
                <li role="presentation"><a href="/web/users"><h3>用户管理</h3></a></li>
                <li role="presentation"><a href="/web/employees"><h3>雇员管理</h3></a></li>
                <li role="presentation"><a href="/web/customers"><h3>客户管理</h3></a></li>
            </ul>
        </nav>

    </div>

    <div class="panel panel-success well well-sm ">
        <div class="panel-heading">
            <th><h3 id="itemList_category">健身房管理系统~课程</h3></th>
        </div>

        <table class="table text-center table-responsive">

            <tr>
                <th class="text-center"><h4>课程名称</h4></th>
                <th class="text-center"><h4>教练</h4></th>
                <th class="text-center"><h4>时间</h4></th>
                <th class="text-center"><h4>操作</h4></th>
                <th class="text-center"><h4>操作</h4></th>
            </tr>

            <c:forEach items="${courses}" var="course">
                <tr>
                    <td><h4><c:out value="${course.name}"/></h4></td>
                    <td><h4><c:out value="${course.coach}"/></h4></td>
                    <td><h4><c:out value="${course.time}"/></h4></td>
                    <td><a href="./courses/modification/<c:out value="${course.id}"/>"><h4>更新</h4></a></td>
                    <td><a href="./courses/deletion/<c:out value="${course.id}"/>"><h4>删除</h4></a></td>
                </tr>
            </c:forEach>

        </table>
    </div>

    <div class="footer">
        <p><span class="glyphicon glyphicon-heart"></span> Have a nice day!!</p>
    </div>

</div>

</body>
</html>

