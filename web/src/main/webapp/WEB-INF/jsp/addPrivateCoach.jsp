<%--
  Created by IntelliJ IDEA.
  User: qxue
  Date: 7/19/15
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD PRIVATE COACH!!</title>
</head>
<body>
<h2 >添加私教!!</h2>
<form method="POST" action="" style="position:absolute; left: 350px;">
    Course : <input type="text" name="course" value = "私教" readonly="readonly"/> <br/>
    Customer Name : <input type="text" name="customer"/> <br/>
    Customer Sex : <input type="text" name="sex"/> <br/>
    Customer Email : <input type="text" name="email"/> <br/>
    Customer Telephone: <input type="text" name="telephone"/> <br/>
    Coach : <input type="text" name="coach"/> <br/>
    Time : <input type="date" name="time"/> <br/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>
