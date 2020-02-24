<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../common/header/mgrHeader.jsp" %>
<%@ include file="../common/langchooser/pageLangChooser.jsp" %>

<div align="center">
    <table>
        <tr>
            <th scope="col"><fmt:message key="client"/></th>
            <th scope="col"><fmt:message key="description"/></th>
            <th scope="col"><fmt:message key="viewed"/></th>
            <th scope="col"><fmt:message key="accepted"/></th>
            <th scope="col"><fmt:message key="action.accept"/></th>
            <th scope="col"><fmt:message key="action.decline"/></th>
        </tr>
    <c:forEach items="${requests}" var="request">
        <tr>
            <td>${request.getClient().getId()}</td>
            <td>${request.getDescription()}</td>
            <td>${request.getViewed()}</td>
            <td>${request.getAccepted()}</td>
            <td>
                <a href="/client/new/feedback?lang=${lang}&req=${request.getId()}">
                <img border="0" alt="Feedback"
                     src="../images/accept.png"
                     width="66" height="60"></a>
            </td>
            <td>
                <a href="/client/new/feedback?lang=${lang}&req=${request.getId()}">
                    <img border="0" alt="Feedback"
                         src="../images/decline.png"
                         width="66" height="60"></a>
            </td>
        </tr>
    </c:forEach>
    </table>
</div>

<%@ include file="../common/footer/pageFooter.jsp" %>