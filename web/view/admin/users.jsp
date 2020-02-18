<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../common/defaultHeader.jsp" %>
<table>
    <tr>
        <td>
            <h3><a href="${requestURI}?lang=en&rows=${itemsPerPage}&page=${pageNum}"><fmt:message key="lang.en" /></a></h3>
        </td>
        <td>
            <h3><a href="${requestURI}?lang=ru&rows=${itemsPerPage}&page=${pageNum}"><fmt:message key="lang.ru" /></a></h3>
        </td>
        <td>
            <h3><a href="${requestURI}?lang=uk&rows=${itemsPerPage}&page=${pageNum}"><fmt:message key="lang.ua" /></a></h3>
        </td>
    </tr>
</table>

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
        <c:if test ="${pageNum > 1}">
            <td>
                <h1>
                <a href="${requestURI}?lang=${param.lang}&rows=${itemsPerPage}&page=1">1</a>
                </h1>
            </td>
        </c:if>

        <c:if test ="${pageNum > 2}">
            <td>
                <h1>
                <a href="${requestURI}?lang=${param.lang}&rows=${itemsPerPage}&page=${pageNum - 1}">...</a>
                </h1>
            </td>
        </c:if>

            <td>
                <h1>
                    <a href="${requestURI}?lang=${param.lang}&rows=${itemsPerPage}&page=${pageNum}">${pageNum}</a>
                </h1>
            </td>

        <c:if test ="${pageNum + 1 < maxPage}">
            <td>
                <h1>
                <a href="${requestURI}?lang=${param.lang}&rows=${itemsPerPage}&page=${pageNum + 1}">...</a>
                </h1>
            </td>
        </c:if>

        <c:if test ="${pageNum < maxPage}">
            <td>
                <h1>
                <a href="${requestURI}?lang=${param.lang}&rows=${itemsPerPage}&page=${maxPage}">${maxPage}</a>
                </h1>
            </td>
        </c:if>
    </tr>
</table>

<%@ include file="../common/defaultFooter.jsp" %>
