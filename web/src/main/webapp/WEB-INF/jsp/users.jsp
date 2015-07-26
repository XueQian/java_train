<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/20/15
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:url value="/lib/js/jquery-1.11.1.min.js" var="jqueryJs"/>
<spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>
<spring:url value="/lib/js/bootstrap.min.js" var="bootstrapJs"/>
<spring:url value="/js/addUser.js" var="addUser"/>
<script src="${jqueryJs}"></script>
<link href="${bootstrapCss}" rel="stylesheet"/>
<script src="${bootstrapJs}"></script>
<script src="${addUser}"></script>

<html>
<head>
    <title>user management</title>
</head>
<body>

<div class="container">
    <div class="btn-toolbar bg-danger">
        <nav class="navbar-default">
            <ul class="nav nav-pills">
                <li role="presentation"><a href="/web/courses"><h3>课程管理</h3></a></li>
                <li role="presentation"><a href="/web/schedules"><h3>课表管理</h3></a></li>
                <li role="presentation"><a href="/web/users"><h3>用户管理</h3></a></li>
                <li role="presentation"><a href="/web/employees"><h3>雇员管理</h3></a></li>
                <li role="presentation"><a href="/web/customers"><h3>顾客管理</h3></a></li>
            </ul>
        </nav>
    </div>

    <div class="panel panel-success well well-sm col-lg-12">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-6">
                    <h2>添加用户信息</h2>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <form method="POST" action="/web/users/creation" id="addUser">

                <div class="col-md-6 col-md-offset-1 text-center input-group">
                    <span class="input-group-addon">用户名称</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="name">
                </div>
                <div class="col-md-6 col-md-offset-1 text-cente input-group">
                    <span class="input-group-addon">密码</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="password">
                </div>
                <div class="col-md-6 col-md-offset-1 text-center">
                    <input class="bg-success btn btn-primary btn-lg " type="submit" value="保存">
                </div>
            </form>
        </div>
    </div>

    <div class="panel panel-success well well-sm col-lg-12">
        <div class="panel-heading">
            <th><h3 id="itemList_category">健身房管理系统~用户</h3></th>
        </div>

        <table class="table text-center table-responsive">

            <tr>
                <th class="text-center"><h4>用户名称</h4></th>
                <th class="text-center"><h4>密码</h4></th>
                <th class="text-center"><h4>操作</h4></th>
                <th class="text-center"><h4>操作</h4></th>
            </tr>

            <c:forEach items="${users}" var="user">
                <tr>
                    <td><h4><c:out value="${user.name}"/></h4></td>
                    <td><h4><c:out value="${user.password}"/></h4></td>
                    <td><a role="button" class="btn btn-primary btn-lg"
                           href="./users/modification/<c:out value="${user.id}"/>">更新</a></td>
                    <td><a role="button" class="btn btn-danger btn-lg"
                           href="./users/deletion/<c:out value="${user.id}"/>">删除</a></td>
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
