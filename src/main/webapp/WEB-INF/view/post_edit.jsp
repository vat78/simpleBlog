<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


            <sf:form method="POST" modelAttribute="post">
                <fieldset>

                    <table cellpadding="0">

                        <tr>
                            <th>
                                <label for="post_title">Title:</label>
                            </th>
                            <td>
                                <sf:input path="id" type="hidden" id="post_id"/>
                                <sf:input path="author.id" type="hidden" id="post_author"/>
                                <sf:input path="title" maxlength="250" size="50" id="post_title" /><br/>
                                <small><sf:errors path="title" type="text.error" /></small>
                            </td>
                        </tr>

                        <tr>
                            <th>
                                <label for="post_text">Text:</label>
                            </th>
                            <td>
                                <sf:textarea path="text" width="100%" rows="15" id="post_text" />
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
