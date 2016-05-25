<%--
  Created by IntelliJ IDEA.
  User: vat
  Date: 24.05.16
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<body onload='document.login.username.focus();'>

<s:url var="authUrl" value="/j_spring_security_check" />
<h3>Please login</h3>

<c:if test="${not empty error}"><div>${error}</div></c:if>
<c:if test="${not empty message}"><div>${message}</div></c:if>

<form name='login' class="signin" action="${authUrl}" method='POST'>
    <fieldset>
    <table>
        <tr>
            <th> User name</th>
            <td><input type='text' id="j_username" name='username' value=''></td>
        </tr>

        <tr>
            <th>Password</th>
            <td><input type='password' id="j_password" name='password' /></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>

    </fieldset>
</form>
<csrf disabled="true"/>
</body>
</html>
