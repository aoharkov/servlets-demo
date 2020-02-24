<div align="center">
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
</div>
</body>
</html>
