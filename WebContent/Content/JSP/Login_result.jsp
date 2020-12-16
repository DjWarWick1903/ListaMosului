<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "listamosului.managers.UserManager, listamosului.managers.AccountManager, listamosului.managers.WishManager" %>
<%@ page import= "listamosului.baseclasses.Account, listamosului.baseclasses.User, listamosului.baseclasses.Wish" %>
<%@ page import= "java.sql.*, java.util.*, java.io.*, javax.servlet.http.*,javax.servlet.*" %>
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
			<h1>Rezultat logare</h1>
			<hr>
		</div>
		
		<div id="body">
		<hr>
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
						Wish wish = WishManager.getInstance().getWishByUserId(account.getUser().getId());
						session.setAttribute("wish", wish);
						out.print("<h2> Bine ai venit " + account.getUser().getLastName() + " " + account.getUser().getFirstName() + "! </h2 <br>");
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
			<hr>
		</div>
	</body>
</html>