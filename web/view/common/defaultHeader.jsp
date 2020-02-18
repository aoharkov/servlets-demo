<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="${param.lang}">
<head>
    <title><fmt:message key="title" /></title>
</head>
<body>
<table>
    <tr>
        <td>
            <img border="0" alt="Logo"
                 src="data:image/png;base64,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"
                 width="60" height="60">
        </td>
        <td>
            <h1><fmt:message key="title" /></h1>
        </td>
        <td>
            <h2><a href="/login?lang=${param.lang}">Login</a></h2>
        </td>
        <td>
            <h2><a href="/register?lang=${param.lang}">Register</a></h2>
        </td>
    </tr>
    <tr>
        <a href="/admin/users?lang=en&rows=4&page=1"><fmt:message key="users" /></a>
    </tr>
</table>

