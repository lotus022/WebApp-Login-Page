<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<form method="post" action="login">
	<label>Email </label>
	<input type="email" id="email" name="email" required/><br><br>
	<label>Password </label>	
	<input type="password" id="PassCode" name="PassCode" required/>
	<br><br>
	<input type="submit" value="Submit" id="submit"/>
</form>

</body>
</html>