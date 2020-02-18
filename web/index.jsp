<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="view/common/defaultHeader.jsp" %>
<table>
    <tr>
        <td>
            <h3><a href="?lang=en"><fmt:message key="lang.en" /></a></h3>
        </td>
        <td>
            <h3><a href="?lang=ru"><fmt:message key="lang.ru" /></a></h3>
        </td>
        <td>
            <h3><a href="?lang=uk"><fmt:message key="lang.ua" /></a></h3>
        </td>
    </tr>
    <tr>
        <a href="/admin/users?lang=$en&rows=4&page=1"><fmt:message key="users" /></a>
    </tr>
</table>

<h1><fmt:message key="m.welcome" /></h1>

<%@ include file="view/common/defaultFooter.jsp" %>