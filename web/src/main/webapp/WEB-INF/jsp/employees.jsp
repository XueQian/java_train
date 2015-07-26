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
<spring:url value="/lib/js/bootstrap.min.js" var="bootstrapJs"/>
<spring:url value="/lib/js/jquery-1.11.1.min.js" var="jqueryJs"/>
<spring:url value="/js/addEmployee.js" var="addEmployee"/>
<script src="${jqueryJs}"></script>
<link href="${bootstrapCss}" rel="stylesheet"/>
<script src="${bootstrapJs}"></script>
<script src="${addEmployee}"></script>

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
                <li role="presentation"><a href="/web/schedules"><h3>课表管理</h3></a></li>
                <li role="presentation"><a href="/web/users"><h3>用户管理</h3></a></li>
                <li role="presentation" class="active dropdown">
                    <a href="/web/employees" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false"><h3>雇员管理</h3> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/web/users/creation"><h4>添加雇员</h4></a></li>
                    </ul>
                </li>
                <li role="presentation"><a href="/web/customers"><h3>顾客管理</h3></a></li>
            </ul>
        </nav>

    </div>

    <div class="panel panel-success well well-sm col-lg-12">

        <div class="panel-heading">
            <div class="row">
                <div class="col-md-6">
                    <h2>添加雇员信息</h2>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <form method="POST" action="/web/employees/creation" id="addEmployee">

                <div class="col-md-6 col-md-offset-1 text-center input-group">
                    <span class="input-group-addon">雇员名称</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="name">
                </div>
                <div class="col-md-6 col-md-offset-1 text-cente input-group">
                    <span class="input-group-addon">职位</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="role">
                </div>
                <div class="col-md-6 col-md-offset-1 text-cente input-group">
                    <span class="input-group-addon">邮箱</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="email">
                </div>
                <div class="col-md-6 col-md-offset-1 text-center">
                    <input class="bg-success btn btn-primary btn-lg " type="submit" value="保存">
                </div>
            </form>
        </div>
    </div>

    <div class="panel panel-success well well-sm col-lg-12">
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
                    <td><a role="button" class="btn btn-primary btn-lg"
                           href="./employees/modification/<c:out value="${employee.id}"/>">更新</a></td>
                    <td><a role="button" class="btn btn-danger btn-lg"
                           href="./employees/deletion/<c:out value="${employee.id}"/>">删除</a></td>
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
