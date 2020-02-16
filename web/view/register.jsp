<%@ include file="common/defaultHeader.jsp" %>

<h1>Registration Form</h1>
<form action="user_register" method="post">
  <table>
    <tr>
      <td>First Name</td>
      <td><input type="text" name="first_name" /></td>
      <td><button onclick="location.href='/list'">List users</button></td>
      <td><button onclick="location.href='/add'">Add user</button></td>
    </tr>
    <tr>
      <td>Last Name</td>
      <td><input type="text" name="last_name" /></td>
    </tr>
    <tr>
      <td>UserName</td>
      <td><input type="text" name="username" /></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input type="password" name="password" /></td>
    </tr>
    <tr>
      <td>Address</td>
      <td><input type="text" name="address" /></td>
    </tr>
    <tr>
      <td>Contact No</td>
      <td><input type="text" name="contact" /></td>
    </tr></table>
  <input type="submit" value="Submit" /></form>

<%@ include file="common/defaultFooter.jsp" %>