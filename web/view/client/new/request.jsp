<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="../../common/header/clientHeader.jsp" %>
<%@ include file="../../common/langchooser/defaultLangChooser.jsp" %>

<div align="center">
<h1>New Request</h1>
<form action="${requestURI}" method="post">
    <table>
        <tr><td>
            <input name="description"
                   type="text"
                   maxlength="255"
                   onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Not longer than 255 characters' : '');"
                   <fmt:message key="text" var="text"/> placeholder="${text}"/>
        </td></tr>
    </table>
    <input type="submit" value="submit"/>
</form>
</div>

<%@ include file="../../common/footer/defaultFooter.jsp" %>