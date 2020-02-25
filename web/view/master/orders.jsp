<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../common/header/masterHeader.jsp" %>
<%@ include file="../common/langchooser/pageLangChooser.jsp" %>

<div align="center">
    <table>
        <tr>
            <th scope="col"><fmt:message key="price"/></th>
            <th scope="col"><fmt:message key="stage"/></th>
            <th scope="col"><fmt:message key="requestId"/></th>
            <th scope="col"><fmt:message key="managerId"/></th>
            <th scope="col"><fmt:message key="masterId"/></th>
        </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.getPrice()}</td>
            <td>${order.getRepairStage().getId()}</td>
            <td>${order.getRequest().getId()}</td>
            <td>${order.getManager().getId()}</td>
            <td>${order.getMaster().getId()}</td>
        </tr>
    </c:forEach>
    </table>
</div>

<%@ include file="../common/footer/pageFooter.jsp" %>