<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Sign In</title>
		<link rel="stylesheet" type="text/css" href="../Styles/ChristmasStyle.css"/>
	</head>
	
	<body>	
		<div id="header">
			<hr>
			<h1>Sign in</h1>
			<hr>
		</div>
		
		<div id="body">
			<form action="Login_result.jsp" method="POST">
				<label for="user">Username</label><br><br>
				<input type="text" id="user" name="user"><br><br>
				<label for="pass">Password</label><br><br>
				<input type="password" id="pass" name="pass"><br><br>
				<input type="submit" name="submitToLog" value="Login">
			</form>
			<br>
			<form action="Create_account.jsp" method="POST">
				<input type="submit" name="submitToRegister" value="Register">
			</form>
			<hr>
		</div>
	</body>
</html>