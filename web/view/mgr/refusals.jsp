<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../common/header/mgrHeader.jsp" %>
<%@ include file="../common/langchooser/pageLangChooser.jsp" %>

<div align="center">
    <table>
        <tr>
            <th scope="col"><fmt:message key="requestId"/></th>
            <th scope="col"><fmt:message key="explanation"/></th>
            <th scope="col"><fmt:message key="masterId"/></th>
        </tr>
    <c:forEach items="${refusals}" var="refusal">
        <tr>
            <td>${refusal.getRequest().getId()}</td>
            <td>${refusal.getExplanation()}</td>
            <td>${refusal.getManager().getId()}</td>
        </tr>
    </c:forEach>
    </table>
</div>

<%@ include file="../common/footer/pageFooter.jsp" %>