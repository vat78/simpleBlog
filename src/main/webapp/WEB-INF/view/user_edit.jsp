<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


            <sf:form method="POST" modelAttribute="user">
                <fieldset>

                    <table cellpadding="0">

                        <tr>
                            <th>
                                <label for="user_name">User name:</label>
                            </th>
                            <td>
                                <sf:input path="id" type="hidden" id="user_id"/>
                                <sf:input path="name" maxlength="50" size="50" id="user_name" /><br/>
                                <small><sf:errors path="name" type="text.error" /></small>
                            </td>
                        </tr>

                        <tr>
                            <th>
                                <label for="user_password">Password:</label>
                            </th>
                            <td>
                                <sf:password path="password" maxlength="50" size="50" id="user_password" /><br/>
                                <small><sf:errors path="password" type="text.error" /></small>
                            </td>
                        </tr>

                        <tr>
                            <th>
                                <label for="user_fullname">Full name:</label>
                            </th>
                            <td>
                                <sf:input path="fullName" size="50" id="user_fullname" />
                            </td>
                        </tr>

                        <tr>
                            <th>
                                <label for="user_admin">Admin rights:</label>
                            </th>
                            <td>
                                <sf:checkbox path="admin" id="user_admin" />
                            </td>
                        </tr>

                        <tr>
                            <th></th>
                            <td>
                                <sf:button id="save" name="save">
                                    Save
                                </sf:button>
                            </td>
                        </tr>

                    </table>
                </fieldset>
            </sf:form>