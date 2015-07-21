<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/13/15
  Time: 1:12 PM
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
    <title>login</title>
</head>
<body>


<form method="POST" action="">

    <div class="container">

        <div class="panel panel-success well well-sm">
            <div class="panel-heading">
                <h3>欢迎使用健身房管理系统 <span class="label label-default">welcome</span></h3>
            </div>
            <div class="panel-body">
                <div class="jumbotron">

                    <div class="row">

                        <div class="col-md-6 col-md-offset-1 text-center input-group">
                            <span class="input-group-addon">用户名</span>
                            <input type="text" class="form-control" placeholder="Username"
                                   aria-describedby="basic-addon1" name="name">
                        </div>
                        <div class="col-md-6 col-md-offset-1 text-cente input-group">
                            <span class="input-group-addon">密     码</span>
                            <input type="text" class="form-control" placeholder="Password"
                                   aria-describedby="basic-addon1" name="password">
                        </div>
                    </div>

                    <div class="row">

                        <div class="col-xs-6 col-sm-4 text-center">
                            <input class="bg-success btn btn-primary btn-lg " type="submit" value="登录">
                        </div>
                        <div class="col-xs-6 col-sm-4 text-center">
                            <p><a class="btn btn-primary btn-lg" role="button" a href="./users/creation">注册</a></p>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

</body>
</html>
