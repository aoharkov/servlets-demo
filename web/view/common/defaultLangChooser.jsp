<table>
    <tr>
        <td>
            <h3><a href="${requestURI}?lang=en"><fmt:message key="lang.en" /></a></h3>
        </td>
        <td>
            <h3><a href="${requestURI}?lang=ru"><fmt:message key="lang.ru" /></a></h3>
        </td>
        <td>
            <h3><a href="${requestURI}?lang=uk"><fmt:message key="lang.ua" /></a></h3>
        </td>
    </tr>
    <tr>
        <a href="/admin/users?lang=${param.lang}&rows=4&page=1"><fmt:message key="users" /></a>
    </tr>
</table>