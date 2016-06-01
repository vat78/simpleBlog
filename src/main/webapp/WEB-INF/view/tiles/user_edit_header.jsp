<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<h1 class="blog-title">
</h1>
<p class="lead blog-description">

<c:if test="${user.name} == ''">
    Create user
</c:if>

<c:if test="${user.name} != ''">
    Edit user <c:out value="${user.fullName}" />:</p>
</c:if>