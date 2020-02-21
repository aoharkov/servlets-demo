<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common/header/defaultHeader.jsp" %>
<%@ include file="common/langchooser/defaultLangChooser.jsp" %>

<h1>Login page</h1>
<form method="post">
  <input type="hidden" name="command" value="login"/>
  <label for="email"><fmt:message key="email"/></label>:
  <input autofocus="autofocus" id="email" name="email" type="text"/> <br/>
  <label for="password"><fmt:message key="password"/></label>:
  <input id="password" name="password" type="password"/> <br/>
  <input type="submit" value="Log in"/>
</form>

<%@ include file="common/footer/defaultFooter.jsp" %>