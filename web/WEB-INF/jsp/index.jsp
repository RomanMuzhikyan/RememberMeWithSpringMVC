<%--
  Created by IntelliJ IDEA.
  User: seriozhik
  Date: 11/1/2016
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Remember me with Spring MVC framework</title>
</head>
<body>
<s:form method="post" commandName="account" action="login.html">
    <fieldset>
        <legend>
            Login
        </legend>
        ${error}
        <table cellpadding="2" cellspacing="2">
            <tr>
            <td>Username:</td>
            <td><s:input path="username" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><s:password path="password"/></td>
            </tr>
            <tr>
                <td>Remember me</td>
                <td><input type="checkbox" name="remember" value="true"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Login"></td>
            </tr>
        </table>
    </fieldset>
</s:form>
</body>
</html>
