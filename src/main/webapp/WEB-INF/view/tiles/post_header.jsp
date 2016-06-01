<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<h1 class="blog-title">
    <c:out value="${post.title}" />
</h1>
<s:url value="/users/{userName}" var="user_url">
    <s:param name="userName" value="${post.author.id}" />
</s:url>


<p class="lead blog-description">
    <c:out value="${post.created}" />
    by <a href="${user_url}">
    <c:out value="${post.author.fullName}" />
</a>
</p>