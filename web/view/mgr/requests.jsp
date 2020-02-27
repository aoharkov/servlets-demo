<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../common/header/mgrHeader.jsp" %>
<%@ include file="../common/langchooser/pageLangChooser.jsp" %>

<div align="center">
    <table>
        <tr>
            <th scope="col"><fmt:message key="description"/></th>
            <th scope="col"><fmt:message key="viewed"/></th>
            <th scope="col"><fmt:message key="accepted"/></th>
            <th scope="col"><fmt:message key="action.accept"/></th>
            <th scope="col"><fmt:message key="action.decline"/></th>
        </tr>
    <c:forEach items="${requests}" var="request">
        <tr>
            <td>${request.getDescription()}</td>
            <td>${request.getViewed()}</td>
            <td>${request.getAccepted()}</td>
            <c:if test="${request.getViewed()=='false'}">
            <td>
                <a href="/mgr/new/order?lang=${lang}&req=${request.getId()}">
                <img border="0" alt="accept"
                     src="../images/accept.png"
                     width="66" height="60"></a>
            </td>
            <td>
                <a href="/mgr/new/refusal?lang=${lang}&req=${request.getId()}">
                    <img border="0" alt="decline"
                         src="../images/decline.png"
                         width="66" height="60"></a>
            </td>
            </c:if>
        </tr>
    </c:forEach>
    </table>
</div>

<%@ include file="../common/footer/pageFooter.jsp" %>