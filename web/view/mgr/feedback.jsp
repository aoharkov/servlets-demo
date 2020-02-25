<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../common/header/mgrHeader.jsp" %>
<%@ include file="../common/langchooser/pageLangChooser.jsp" %>

<div align="center">
    <table>
        <tr>
            <th scope="col"><fmt:message key="requestId"/></th>
            <th scope="col"><fmt:message key="text"/></th>
            <th scope="col"><fmt:message key="score"/></th>
        </tr>
    <c:forEach items="${feedback}" var="oneFeedback">
        <tr>
            <td>${oneFeedback.getRequest().getId()}</td>
            <td>${oneFeedback.getText()}</td>
            <td>${oneFeedback.getScore()}</td>
        </tr>
    </c:forEach>
    </table>
</div>

<%@ include file="../common/footer/pageFooter.jsp" %>