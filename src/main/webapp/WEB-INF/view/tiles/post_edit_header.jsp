<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<h1 class="blog-title">
</h1>

<p class="lead blog-description">

<c:if test="${post.title} == ''">
    Create new post
</c:if>

<c:if test="${post.title} != ''">
    Edit post <c:out value="${post.title}" />:</p>
</c:if>