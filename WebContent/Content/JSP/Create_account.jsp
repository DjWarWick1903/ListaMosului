<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista lui Mos Craciun</title>
		<link rel="stylesheet" type="text/css" href="../Styles/ChristmasStyle.css"/>
	</head>
	
	<body>
		<div id="header">
			<hr>
			<h1>Creare cont</h1>
			<hr>
		</div>
		
		<div id="body">
			<form action="Create_account_result.jsp" method="POST">
				<label for="email">Email</label><br><br>
				<input type="text" id="email" name="email" required="required" maxlength="30" title="abc@email.com"><br><br>
				<label for="user">Nume utilizator</label><br><br>
				<input type="text" id="user" name="user" required="required" maxlength="30"><br><br>
				<label for="pass">Parola</label><br><br>
				<input type="password" id="pass" name="pass" required="required" maxlength="30" title="Trebuie sa contina cel putin un caracter ?!+_"><br><br>
				<label for="lastname">Nume</label><br><br>
				<input type="text" id="lastname" name="lastname" required="required" maxlength="30"><br><br>
				<label for="firstname">Prenume</label><br><br>
				<input type="text" id="firstname" name="firstname" required="required" maxlength="30"><br><br>
				<label for="address">Adresa</label><br><br>
				<input type="text" id="address" name="address" required="required" maxlength="60"><br><br>
				<label for="birthday">Data nasterii</label><br><br>
				<input type="date" id="birthday" name="birthday" required="required" maxlength="10" title="yyyy-MM-dd"><br><br>
				
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