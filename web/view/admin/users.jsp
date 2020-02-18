<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../common/defaultHeader.jsp" %>
<%@ include file="../common/pageLangChooser.jsp" %>

<table>
    <tr>
        <th scope="col"><fmt:message key="name"/></th>
        <th scope="col"><fmt:message key="surname"/></th>
        <th scope="col"><fmt:message key="email"/></th>
        <th scope="col"><fmt:message key="role"/></th>
    </tr>
<c:forEach items="${users}" var="user">
    <tr>
        <td>${user.getName()}</td>
        <td>${user.getSurname()}</td>
        <td>${user.getEmail()}</td>
        <td>${user.getRole().name()}</td>
    </tr>
</c:forEach>
</table>

<%@ include file="../common/pageFooter.jsp" %>