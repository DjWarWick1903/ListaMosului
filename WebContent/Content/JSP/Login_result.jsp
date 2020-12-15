<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "listamosului.managers.UserManager, listamosului.managers.AccountManager" %>
<%@ page import= "listamosului.baseclasses.Account, listamosului.baseclasses.User" %>
<%@ page import= "java.sql.*, java.util.*, java.io.*, javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Result</title>
		<link rel="stylesheet" type="text/css" href="../Styles/ChristmasStyle.css"/>
	</head>
	
	<body>
		<div id="header">
			<hr>
			<h1>Sign up</h1>
			<hr>
		</div>
		
		<div id="body">
			<%
				String user = request.getParameter("user");
				String pass = request.getParameter("pass");

				AccountManager accMan = AccountManager.getInstance();
				boolean goToMainPage = false;
				
				if(accMan.checkIfAccountExists(user, pass)) {
					Account account = accMan.getAccount(user, pass);
					if(account != null) {
						goToMainPage = true;
						session.setAttribute("account", account);
						out.print("<h3> Bine ai venit " + account.getUser().getLastName() + " " + account.getUser().getFirstName() + "! </h3 <br>");
					}
				} 
				
				if(goToMainPage) {
			%>
				<form action="MainPage.jsp" method="POST">
					<input type="submit" value="Continua"/>
				</form>
			<%
				} else {	
			%>
				<h2>Ne pare rau dar contul introdus nu exista in Tolba Mosului!</h2>
				<h2>Va rugam sa verificati numele de utilizator si parola introduse sau sa va creati mai intai un cont.</h2>
				<br>
				<form action="Create_account.jsp" method="POST">
					<input type="submit" value="Creeaza cont" />
				</form>
				<br>
				<form action="Login.jsp" method="POST">
					<input type="submit" value="Inapoi"/>
				</form>
			<%
				}
			%>
		</div>
	</body>
</html>