<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/20/15
  Time: 10:27 PM
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
    <title>employee management</title>
</head>
<body>

<div class="container">
    <div class="btn-toolbar bg-danger">

        <nav class="navbar-default">
            <ul class="nav nav-pills">
                <li role="presentation"><a href="/web/courses"><h3>课程管理</h3></a></li>
                <li role="presentation"><a href="/web/users"><h3>用户管理</h3></a></li>
                <li role="presentation" class="active dropdown">
                    <a href="/web/employees" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false"><h3>雇员管理</h3> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/web/users/creation"><h4>添加雇员</h4></a></li>
                    </ul>
                </li>
                <li role="presentation"><a href="/web/customers"><h3>客户管理</h3></a></li>
            </ul>
        </nav>

    </div>

    <div class="panel panel-success well well-sm ">
        <div class="panel-heading">
            <th><h3 id="itemList_category">健身房管理系统~雇员</h3></th>
        </div>

        <table class="table text-center table-responsive">

            <tr>
                <th class="text-center"><h4>雇员名称</h4></th>
                <th class="text-center"><h4>职位</h4></th>
                <th class="text-center"><h4>邮箱</h4></th>
                <th class="text-center"><h4>操作</h4></th>
                <th class="text-center"><h4>操作</h4></th>
            </tr>

            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td><h4><c:out value="${employee.name}"/></h4></td>
                    <td><h4><c:out value="${employee.role}"/></h4></td>
                    <td><h4><c:out value="${employee.email}"/></h4></td>
                    <td><a href="./employees/modification/<c:out value="${employee.id}"/>"><h4>更新</h4></a></td>
                    <td><a href="./employees/deletion/<c:out value="${employee.id}"/>"><h4>删除</h4></a></td>
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
