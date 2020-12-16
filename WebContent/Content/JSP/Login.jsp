<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista lui Mos Craciun</title>
		<link rel="stylesheet" type="text/css" href="../Styles/ChristmasStyle.css"/>
	</head>
	
	<%
		session.removeAttribute("account");
		session.removeAttribute("wish");
	%>
	<body>	
		<div id="header">
			<hr>
			<h1>Logare</h1>
			<hr>
		</div>
		
		<div id="body">
			<form action="Login_result.jsp" method="POST">
				<label for="user">Nume utilizator</label><br><br>
				<input type="text" id="user" name="user" required="required"><br><br>
				<label for="pass">Parola</label><br><br>
				<input type="password" id="pass" name="pass" required="required" title="Acest camp este obligatoriu ar trebui sa contina macar un caracter din ?!+_"><br><br>
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