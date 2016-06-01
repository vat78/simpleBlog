<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<h1 class="blog-title">
    <c:out value="${user.fullName}" />
</h1>

<p class="lead blog-description">Posts of  <c:out value="${user.fullName}" />:</p>
</p>