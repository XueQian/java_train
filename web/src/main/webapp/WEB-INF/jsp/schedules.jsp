<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/17/15
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>SHOW schedules!!</title>
    <link href="./lib/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
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

    <div class="panel panel-success well well-sm col-lg-6">

        <div class="panel-heading">
            <div class="row">
                <div class="col-md-9">
                    <h2>增加公共课</h2>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <form method="POST" action="/web/schedules/creation" id="addSchedule">
                <div class="col-md-6 col-md-offset-1 input-group">
                    <span class="input-group-addon">课表名称</span>
                    <select name="courseId">
                        <c:forEach var="course" items="${courseList}">
                            <option value="<c:out value="${course.id}"/>"><c:out value="${course.name}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6 col-md-offset-1 input-group">
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

    <div class="panel panel-success well well-sm col-lg-6">

        <div class="panel-heading">
            <div class="row">
                <div class="col-md-6">
                    <h2>增加私教</h2>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <form method="POST" action="/web/schedules/private/creation" id="addPrivateCoach">
                <div class="col-md-6 col-md-offset-1 text-center input-group">
                    <span class="input-group-addon">课表名称</span>
                    <input type="text" class="form-control"
                           aria-describedby="basic-addon1" name="course" value="私教" readonly="readonly">
                </div>
                <div class="col-md-6 col-md-offset-1 input-group">
                    <span class="input-group-addon">顾客名称</span>
                    <select name="customerId">
                        <c:forEach var="customer" items="${customerList}">
                            <option value="<c:out value="${customer.id}"/>"><c:out value="${customer.name}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6 col-md-offset-1 input-group">
                    <span class="input-group-addon">教练名称</span>
                    <select name="coachId">
                        <c:forEach var="coach" items="${coachList}">
                            <option value="<c:out value="${coach.id}"/>"><c:out value="${coach.name}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6 col-md-offset-1 text-center input-group">
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

    <div class="panel panel-success well well-sm col-lg-12">
        <div class="panel-heading">
            <th><h3 id="itemList_category">健身房管理系统~课表</h3></th>
        </div>

        <table class="table text-center table-responsive">

            <tr>
                <th class="text-center"><h4>课表名称</h4></th>
                <th class="text-center"><h4>教练</h4></th>
                <th class="text-center"><h4>时间</h4></th>
                <th class="text-center"><h4>操作</h4></th>
                <th class="text-center"><h4>操作</h4></th>
            </tr>

            <c:forEach items="${schedules}" var="schedule">
                <tr>
                    <td><h4><c:out value="${schedule.name}"/></h4></td>
                    <td><h4><c:out value="${schedule.employee}"/></h4></td>
                    <td><h4><c:out value="${schedule.time}"/></h4></td>
                    <td><a role="button" class="btn btn-primary btn-lg"
                           href="./schedules/modification/<c:out value="${schedule.id}"/>">更新</a></td>
                    <td><a role="button" class="btn btn-danger btn-lg"
                           href="./schedules/deletion/<c:out value="${schedule.id}"/>">删除</a></td>
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
<script src="./js/addPrivateCoach.js"></script>
<script src="./js/addSchedule.js"></script>

</body>
</html>

