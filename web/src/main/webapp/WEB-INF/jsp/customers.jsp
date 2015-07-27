<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/21/15
  Time: 12:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>customer management</title>
    <link href="./lib/css/bootstrap.min.css" rel="stylesheet" type="text/css">
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
                    <table>
                        <tr>
                            <th><h2 id="goodsList_category">添加顾客</h2></th>
                            <th><h4 class="text-right">ADD CUSTOMER</h4></th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <form method="POST" action="/web/customers/creation" id="addCustomer">

                <div class="col-md-6 col-md-offset-1 text-center input-group">
                    <span class="input-group-addon">顾客名称</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="name" placeholder="name"/>
                </div>
                <div class="col-md-6 col-md-offset-1 text-cente input-group">
                    <span class="input-group-addon">性别</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="sex" placeholder="sex"/>
                </div>
                <div class="col-md-6 col-md-offset-1 text-cente input-group">
                    <span class="input-group-addon">邮箱</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="email" placeholder="email"/>
                </div>
                <div class="col-md-6 col-md-offset-1 text-cente input-group">
                    <span class="input-group-addon">电话</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="telephone" placeholder="telephone"/>
                </div>
                <div class="col-md-6 col-md-offset-1 text-center">
                    <input class="bg-success btn btn-primary btn-lg " type="submit" value="保存">
                </div>
            </form>
        </div>
    </div>

    <div class="panel panel-success well well-sm col-lg-12">
        <div class="panel-heading">
            <th><h3 id="itemList_category">健身房管理系统~顾客</h3></th>
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

<script src="./lib/js/jquery-1.11.1.min.js"></script>
<script src="./lib/js/bootstrap.min.js"></script>
<script src="./js/addCustomer.js"></script>

</body>
</html>
