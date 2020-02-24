<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common/header/defaultHeader.jsp" %>
<%@ include file="common/langchooser/defaultLangChooser.jsp" %>
<div align="center">
<h1>Login page</h1>
  <form action="${requestURI}" method="post">
      <input type="hidden" name="command" value="login"/>
      <input name="email"
             required
             type="email"
             maxlength="60"
             pattern="^[\w!#$%&'*+-\/=?^`{|}~]+(\.[\w!#$%&'*+-\/=?^`{|}~]+)*@[a-zA-Z0-9]+(-[a-zA-Z0-9]+)*(\.[a-zA-Z0-9]+(-[a-zA-Z0-9]+)*)*$"
              <fmt:message key="email" var="email"/>
             onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Not valid email' : '');"
             placeholder="${email}"/><br>
      <input name="password"
             required
             type="password"
             maxlength="60"
             pattern="^.{8,}$"
              <fmt:message key="password" var="password1"/>
             onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Password must have at least 8 characters' : '');
                               if(this.checkValidity()) form.repeated_password.pattern = this.value;
                               else form.repeated_password.pattern = form.password.pattern"
             placeholder="${password1}"/><br>
      <input type="submit" value="Log in"/>
  </form>
</div>

<%@ include file="common/footer/defaultFooter.jsp" %>