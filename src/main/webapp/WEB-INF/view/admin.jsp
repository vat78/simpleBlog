<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


                <div class="blog-post">

                    <p class="blog-post-meta">

                        <table width="100%" cellspacing="20px">

                        <tr border-spacing="10">
                            <th text-align="center">User</th>
                            <th text-align="center">Role</th>
                        </tr>
                        <c:forEach var="user" items="${users}">

                            <tr>
                            <s:url value="/users/{userName}" var="user_url">
                                <s:param name="userName" value="${user.id}" />
                            </s:url>

                                <td>
                                    <a href="${user_url}">
                                        <c:out value="${user.fullName}" />
                                    </a>
                                </td>
                                <td>
                                    <c:if test="${user.admin}">
                                        ADMIN
                                    </c:if>
                                </td>
                            </tr>

                        </c:forEach>

                        </table>
                    </p>

                </div><!-- /.blog-post -->
