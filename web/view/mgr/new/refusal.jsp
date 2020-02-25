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
            <input name="explanation"
                   type="text"
                   maxlength="255"
                   onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Not longer than 255 characters' : '');"
                    <fmt:message key="explanation" var="explanation"/> placeholder="${explanation}"/>
        </td></tr>
    </table>
    <input type="submit" value="submit"/>
</form>
</div>

<%@ include file="../../common/footer/defaultFooter.jsp" %>