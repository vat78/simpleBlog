<%--
  Created by IntelliJ IDEA.
  User: vat
  Date: 24.05.16
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body onload='document.loginForm.username.focus();'>
<h3>JournalDEV Tutorials</h3>

<c:if test="${not empty error}"><div>${error}</div></c:if>
<c:if test="${not empty message}"><div>${message}</div></c:if>

<form name='login' action="<c:url value='/login' />" method='POST'>
    <table>
        <tr>
            <td>UserName:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>
