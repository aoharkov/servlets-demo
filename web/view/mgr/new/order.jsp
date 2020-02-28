<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="../../common/header/mgrHeader.jsp" %>
<%@ include file="../../common/langchooser/defaultLangChooser.jsp" %>

<div align="center">
<h1>New Order</h1>
<form action="${requestURI}" method="post">
    <input name="req"
           type="hidden"
           value="${param.req}"/>
    <table>
        <tr><td>
            <input name="price"
                   type="number"
                   min="0"
                   onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Price should not be negative' : '');"
                   <fmt:message key="price" var="price"/> placeholder="${price}"/>
        </td></tr>
        <tr><td>
            <input name="masterId"
                   type="number"
                   min="1"
                   onchange="this.setCustomValidity(this.validity.patternMismatch ? 'ID should be positive' : '');"
                    <fmt:message key="masterId" var="masterId"/> placeholder="${masterId}"/>
        </td></tr>
    </table>
    <input type="submit" value="<fmt:message key="btn.submit"/>"/>
</form>
</div>

<%@ include file="../../common/footer/defaultFooter.jsp" %>