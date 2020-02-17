<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../common/defaultHeader.jsp" %>

<table>
    <tr>
        <th scope="col"><fmt:message key="name"/></th>
        <th scope="col"><fmt:message key="surname"/></th>
        <th scope="col"><fmt:message key="email"/></th>
        <th scope="col"><fmt:message key="role"/></th>
    </tr>
<c:forEach items="${users}" var="user">
    <tr>
        <td>${user.getName()}</td>
        <td>${user.getSurname()}</td>
        <td>${user.getEmail()}</td>
        <td>${user.getRole().name()}</td>
    </tr>
</c:forEach>
</table>
<table>
    <tr>
        <h2>
            <c:if test ="${pageNum} > 1">
            <td>
                <a href="/admin/users/all(rows = ${itemsPerPage}, page = 1)}" th:text="1"></a>
            </td>
            </c:if>
            <c:if test ="${pageNum} > 2">
            <td>
                <a th:href="@{/admin/users/all(rows = ${itemsPerPage}, page = ${pageNum} - 1)}" th:text="..."></a>
            </td>
            </c:if>
            <td>
                <h1>
                    <a th:href="@{/admin/users/all(rows = ${itemsPerPage}, page = ${pageNum})}"
                       th:text="${pageNum}"></a>
                </h1>
            </td>

            <c:if test ="${pageNum} + 1 < ${maxPage}">
            <td>
                <a th:href="@{/admin/users/all(rows = ${itemsPerPage}, page = ${pageNum} + 1)}" th:text="..."></a>
            </td>
            </c:if>
            <c:if test ="${pageNum} < ${maxPage}">
            <td>
                <a th:href="@{/admin/users/all(rows = ${itemsPerPage}, page = ${maxPage})}" th:text="${maxPage}"></a>
            </td>
            </c:if>
        </h2>
    </tr>
</table>

<%@ include file="../common/defaultFooter.jsp" %>
