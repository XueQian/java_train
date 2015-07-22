<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/21/15
  Time: 9:17 AM
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
    <title>Update Customer</title>
</head>
<body>

<div class="container">

    <div class="btn-toolbar bg-danger">

        <nav class="navbar-default">
            <ul class="nav nav-pills">
                <li role="presentation"><a href="/web/schedules"><h3>课程管理</h3></a></li>
                <li role="presentation"><a href="/web/users"><h3>用户管理</h3></a></li>
                <li role="presentation"><a href="/web/employees"><h3>雇员管理</h3></a></li>
                <li role="presentation" class="active dropdown">
                    <a href="/web/customers" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false"><h3>顾客管理</h3> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/web/schedules/private/creation"><h4>添加顾客</h4></a></li>
                    </ul>
                </li>
            </ul>
        </nav>

    </div>

    <div class="panel panel-success well well-sm ">

        <div class="panel-heading">
            <div class="row">
                <div class="col-md-6">
                    <table>
                        <tr>
                            <th><h2 id="goodsList_category">修改顾客信息</h2></th>
                            <th><h4 class="text-right">MODIFY CUSTOMER INFO</h4></th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <form method="POST" action="">

                <div class="col-md-6 col-md-offset-1 text-center input-group">
                    <span class="input-group-addon">顾客名称</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="name" value="<c:out value="${customer.name}" />">
                </div>
                <div class="col-md-6 col-md-offset-1 text-cente input-group">
                    <span class="input-group-addon">性别</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="sex" value="<c:out value="${customer.sex}" />">
                </div>
                <div class="col-md-6 col-md-offset-1 text-cente input-group">
                    <span class="input-group-addon">邮箱</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="email" value="<c:out value="${customer.email}" />">
                </div>
                <div class="col-md-6 col-md-offset-1 text-cente input-group">
                    <span class="input-group-addon">电话</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="telephone" value="<c:out value="${customer.telephone}" />">
                </div>
                <div class="col-md-6 col-md-offset-1 text-center">
                    <input class="bg-success btn btn-primary btn-lg " type="submit" value="保存">
                </div>
            </form>
        </div>
    </div>
    <div class="footer">
        <p><span class="glyphicon glyphicon-heart"></span> Have a nice day!!</p>
    </div>
</div>

</body>
</html>
