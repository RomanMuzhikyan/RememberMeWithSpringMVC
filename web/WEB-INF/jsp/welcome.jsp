<%--
  Created by IntelliJ IDEA.
  User: seriozhik
  Date: 11/1/2016
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remember Me with Spring framework</title>
</head>
<body>
Welcome ${sessionScope.username}
<br>
<a href="${pageContext.request.contextPath}/account/logout.html">Logout</a>
</body>
</html>
