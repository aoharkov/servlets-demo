<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="../../common/header/clientHeader.jsp" %>
<%@ include file="../../common/langchooser/defaultLangChooser.jsp" %>

<div align="center">
<h1>New Feedback</h1>
<form action="${requestURI}" method="post">
    <input name="req"
           type="hidden"
           value="${param.req}"/>
    <table>
        <tr><td>
            <input name="text"
                   type="text"
                   maxlength="255"
                   pattern="^([A-Za-z]+[ A-Za-z])*[A-Za-z]+$"
                   onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Only letters and whitespaces (between words) are allowed' : '');"
                   <fmt:message key="text" var="text"/> placeholder="${text}"/>
        </td></tr>
        <tr><td>
            <input name="score"
                   type="number"
                   min="1"
                   max="10"
                   <fmt:message key="score" var="score"/>
                   onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Score should be in range [1, 10]' : '');"
                   placeholder="${score}"/>
        </td></tr>
    </table>
    <input type="submit" value="submit"/>
</form>
</div>

<%@ include file="../../common/footer/defaultFooter.jsp" %>