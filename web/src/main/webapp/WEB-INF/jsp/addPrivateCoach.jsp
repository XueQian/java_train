<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/19/15
  Time: 4:08 PM
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
    <title>ADD PRIVATE COACH!!</title>
</head>
<body>

<div class="container">

    <div class="btn-toolbar bg-danger">

        <nav class="navbar-default">
            <ul class="nav nav-pills">
                <li role="presentation" class="active dropdown">
                    <a href="/web/schedules" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false"><h3>课表管理</h3> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/web/schedules/creation"><h4>添加公共课表</h4></a></li>
                        <li><a href="/web/schedules/private/creation"><h4>添加私教课表</h4></a></li>
                    </ul>
                </li>
                <li role="presentation"><a href="/web/users"><h3>用户管理</h3></a></li>
                <li role="presentation"><a href="/web/employees"><h3>雇员管理</h3></a></li>
                <li role="presentation"><a href="/web/customers"><h3>顾客管理</h3></a></li>
            </ul>
        </nav>

    </div>

    <div class="panel panel-success well well-sm ">

        <div class="panel-heading">
            <div class="row">
                <div class="col-md-6">
                    <table>
                        <tr>
                            <th><h2 id="goodsList_category">增加私教</h2></th>
                            <th><h4 class="text-right">ADD PERSONAL COACH</h4></th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <form method="POST" action="">

                <div class="col-md-6 col-md-offset-1 text-center input-group">
                    <span class="input-group-addon">课表名称</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="course" value="私教" readonly="readonly">
                </div>
                <div class="col-md-6 col-md-offset-1 text-cente input-group">
                    <span class="input-group-addon">顾客名称</span>
                    <select name="customerId">
                        <c:forEach var="customer" items="${customerList}">
                            <option value="<c:out value="${customer.id}"/>"><c:out value="${customer.name}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6 col-md-offset-1 text-cente input-group">
                    <span class="input-group-addon">教练名称</span>
                    <select name="coachId">
                        <c:forEach var="coach" items="${coachList}">
                            <option value="<c:out value="${coach.id}"/>"><c:out value="${coach.name}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6 col-md-offset-1 text-cente input-group">
                    <span class="input-group-addon">课表时间</span>
                    <input type="date" class="form-control"
                           aria-describedby="basic-addon1" name="time">
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
