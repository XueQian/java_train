<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/21/15
  Time: 12:04 AM
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
    <title>customer management</title>
</head>
<body>

<div class="container">
    <div class="btn-toolbar bg-danger">

        <nav class="navbar-default">
            <ul class="nav nav-pills">
                <li role="presentation"><a href="/web/courses"><h3>课程管理</h3></a></li>
                <li role="presentation"><a href="/web/users"><h3>用户管理</h3></a></li>
                <li role="presentation"><a href="/web/employees"><h3>雇员管理</h3></a></li>
                <li role="presentation" class="active dropdown">
                    <a href="/web/customers" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false"><h3>客户管理</h3> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/web/courses/private/creation"><h4>添加客户</h4></a></li>
                    </ul>
                </li>
            </ul>
        </nav>

    </div>

    <div class="panel panel-success well well-sm ">
        <div class="panel-heading">
            <th><h3 id="itemList_category">健身房管理系统~客户</h3></th>
        </div>

        <table class="table text-center table-responsive">

            <tr>
                <th class="text-center"><h4>姓名</h4></th>
                <th class="text-center"><h4>性别</h4></th>
                <th class="text-center"><h4>邮箱</h4></th>
                <th class="text-center"><h4>电话</h4></th>
                <th class="text-center"><h4>操作</h4></th>
                <th class="text-center"><h4>操作</h4></th>
            </tr>

            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td><h4><c:out value="${customer.name}"/></h4></td>
                    <td><h4><c:out value="${customer.sex}"/></h4></td>
                    <td><h4><c:out value="${customer.email}"/></h4></td>
                    <td><h4><c:out value="${customer.telephone}"/></h4></td>
                    <td><a role="button" class="btn btn-primary btn-lg"
                           href="./customers/modification/<c:out value="${customer.id}"/>">更新</a></td>
                    <td><a role="button" class="btn btn-danger btn-lg"
                           href="./customers/deletion/<c:out value="${customer.id}"/>">删除</a></td>
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
