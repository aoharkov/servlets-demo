<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common/defaultHeader.jsp" %>
<table>
  <tr>
    <td>
      <h3><a href="/login?lang=en"><fmt:message key="lang.en" /></a></h3>
    </td>
    <td>
      <h3><a href="/login?lang=ru"><fmt:message key="lang.ru" /></a></h3>
    </td>
    <td>
      <h3><a href="/login?lang=uk"><fmt:message key="lang.ua" /></a></h3>
    </td>
  </tr>
</table>

<h1>Login page</h1>
<form method="post">
  <input type="hidden" name="command" value="login"/>
  <label for="email"><fmt:message key="email"/></label>:
  <input autofocus="autofocus" id="email" name="email" type="text"/> <br/>
  <label for="password"><fmt:message key="password"/></label>:
  <input id="password" name="password" type="password"/> <br/>
  <input type="submit" value="Log in"/>
</form>

<%@ include file="common/defaultFooter.jsp" %>