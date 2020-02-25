<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../common/header/masterHeader.jsp" %>
<%@ include file="../common/langchooser/pageLangChooser.jsp" %>

<div align="center">
    <table>
        <tr>
            <th scope="col"><fmt:message key="num"/></th>
            <th scope="col"><fmt:message key="stage.name"/></th>
        </tr>
    <c:forEach items="${stages}" var="stage">
        <tr>
            <td>${stage.getId()}</td>
            <td>${stage.getName()}</td>
        </tr>
    </c:forEach>
    </table>
</div>

<%@ include file="../common/footer/pageFooter.jsp" %>