<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Sign Up</title>
		<link rel="stylesheet" type="text/css" href="../Styles/ChristmasStyle.css"/>
	</head>
	
	<body>
		<div id="header">
			<hr>
			<h1>Sign up</h1>
			<hr>
		</div>
		
		<div id="body">
			<form action="MainPage.jsp" method="POST">
				<label for="email">Email</label><br><br>
				<input type="text" id="email" name="email" required="required" maxlength="30"><br><br>
				<label for="user">Username</label><br><br>
				<input type="text" id="user" name="user" required="required" maxlength="30"><br><br>
				<label for="pass">Password</label><br><br>
				<input type="password" id="pass" name="pass" required="required" maxlength="30"><br><br>
				<label for="lastname">Last name</label><br><br>
				<input type="text" id="lastname" name="lastname" required="required" maxlength="30"><br><br>
				<label for="firstname">First name</label><br><br>
				<input type="text" id="firstname" name="firstname" required="required" maxlength="30"><br><br>
				<label for="address">Address</label><br><br>
				<input type="text" id="address" name="address" required="required" maxlength="30"><br><br>
				<label for="birthday">Birthday</label><br><br>
				<input type="date" id="birthday" name="birthday" required="required" maxlength="10"><br><br>
				
				<input type="submit" name="submitToMain" value="Sign Up">
			</form>
			<br>
			<form action="Login.jsp" method="POST">
				<input type="submit" name="submitToLogin" value="Return">
			</form>
			<hr>
		</div>
	</body>
</html>