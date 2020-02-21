<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="common/header/defaultHeader.jsp" %>
<%@ include file="common/langchooser/defaultLangChooser.jsp" %>

<h1>Registration Form</h1>

<form action="${requestURI}" method="post">
    <table>
        <tr><td>
            <input name="name"
                   required
                   type="text"
                   maxlength="60"
                   pattern="^([A-Za-zА-Яа-я]+[ A-Za-zА-Яа-я])*[A-Za-zА-Яа-я]+$"
                   onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Only letters are allowed' : '');"
                   <fmt:message key="name" var="name"/> placeholder="${name}"/>
        </td></tr>
        <tr><td>
            <input name="surname"
                   type="text"
                   maxlength="60"
                   pattern="^([A-Za-zА-Яа-я]+[ A-Za-zА-Яа-я])*[A-Za-zА-Яа-я]+$"
                   onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Only letters and whitespaces (between words) are allowed' : '');"
                   <fmt:message key="surname" var="surname"/> placeholder="${surname}"/>
        </td></tr>
        <tr><td>
            <input name="email"
                   required
                   type="email"
                   maxlength="60"
                   pattern="^[\w!#$%&'*+-\/=?^`{|}~]+(\.[\w!#$%&'*+-\/=?^`{|}~]+)*@[a-zA-Z0-9]+(-[a-zA-Z0-9]+)*(\.[a-zA-Z0-9]+(-[a-zA-Z0-9]+)*)*$"
                   <fmt:message key="email" var="email"/>
                   onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Not valid email' : '');"
                   placeholder="${email}"/>
        </td></tr>
        <tr><td>
            <input name="password"
                   required
                   type="password"
                   maxlength="60"
                   pattern="^.{8,}$"
                   <fmt:message key="password" var="password1"/>
                   onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Password must have at least 8 characters' : '');
                             if(this.checkValidity()) form.repeated_password.pattern = this.value;
                             else form.repeated_password.pattern = form.password.pattern"
                   placeholder="${password1}"/>
        </td></tr>
        <tr><td>
            <input name="repeated_password"
                   required
                   type="password"
                   maxlength="60"
                   pattern="^.{8,}$"
                    <fmt:message key="password" var="repeated_password"/>
                   onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Repeated password should be the same' : '');"
                   placeholder="${repeated_password}"/>
        </td></tr>
        <tr><td>
        <input type="submit" value="submit"/>
        </td></tr>
    </table>
</form>

<%@ include file="common/footer/defaultFooter.jsp" %>