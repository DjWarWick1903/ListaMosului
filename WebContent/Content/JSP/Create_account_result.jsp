<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "listamosului.tools.DataValidation, listamosului.managers.AccountManager, java.util.*" %>
<%@ page import= "listamosului.managers.UserManager, java.time.LocalDate, listamosului.baseclasses.User" %>
<%@ page import= "listamosului.baseclasses.Account" %>
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
			<h1>Crearea contului</h1>
			<hr>
		</div>
		
		<div id="body">
			<hr>
			<%
				boolean goToMainPage = false;
			
				//luam valorile din form
				String email = request.getParameter("email");
				String username = request.getParameter("user");
				String password = request.getParameter("pass");
				String lastName = request.getParameter("lastname");
				String firstName = request.getParameter("firstname");
				String address = request.getParameter("address");
				String bday = request.getParameter("birthday");
				
				//scoatem spatiile inutile din ele, acolo unde sunt
				email = email.trim();
				username = username.trim();
				password = password.trim();
				lastName = lastName.trim();
				firstName = firstName.trim();
				address = address.trim();
				bday = bday.trim();
				
				DataValidation validation = DataValidation.getInstance();
				
				boolean dataIsValid = false;
				
				while(!dataIsValid) {
					if(!validation.checkEmail(email)) {
			%>
				<h2>Emailul este gresit!</h2>
			<%
						break;
					}
					
					if(!validation.checkUsername(username)) {
			%>
				<h2>Numele de utilizator este gresit!</h2>
				<h2>Nu folositi caracter speciale.</h2>
			<%
						break;
					}
					
					if(!validation.checkPassword(password)) {
			%>
				<h2>Parola este gresita!</h2>
				<h2>Nu folositi alte caracter speciale in loc de ?!+_</h2>
			<%
						break;
					}
					
					if(!validation.checkLName(lastName)) {
			%>
				<h2>Numele este gresit!</h2>
				<h2>Nu folositi caractere speciale!</h2>
			<%
						break;
					}
					
					if(!validation.checkFName(firstName)) {
			%>
				<h2>Prenumele este gresit!</h2>
				<h2>Nu folositi caractere speciale!</h2>
			<%
						break;
					}
					
					if(!validation.checkAddress(address)) {
			%>
				<h2>Adresa este gresita!</h2>
				<h2>Nu folositi caractere speciale!</h2>
			<%
						break;
					}
					
					if(!validation.checkDate(bday)) {
			%>
				<h2>Data nasterii este gresita!</h2>
				<h2>Introduceti o data valida in formatul "yyyy-MM-dd"</h2>
			<%
						break;
					}
					
					dataIsValid = true;
				}
				
				if(dataIsValid) {
					AccountManager accMan = AccountManager.getInstance();
					UserManager userMan = UserManager.getInstance();
					
					LocalDate bdate = validation.convertStringToLocalDate(bday);
					
					Random random = new Random();
					User user = new User(0, lastName, firstName, address, bdate, random.nextBoolean());
					final int insertedUser = userMan.insertUser(user);
					
					if(insertedUser > 0) {
						final Account acc = new Account(0, email, username, password, user);
						
						final int insertedAccount = accMan.insertAccount(acc);
						if(insertedAccount > 0) {
							goToMainPage = true;
							session.setAttribute("account", acc);
						}
					}
				}
				
				if(goToMainPage) {
			%>
				<h2>Mosul a gasit numele tau in baza sa de date, iar acum ai si un cont pentru site!</h2>
				<h2>Bine ai venit pe site-ul lui Mos Craciun!</h2>
				
				<form action="MainPage.jsp" method="POST">
					<input type="submit" name="submitToMainPage" value="Continua">
				</form>
			<%
				} else {
			%>
				<form action="Create_account.jsp" method="POST">
					<input type="submit" name="submitToMainPage" value="Inapoi">
				</form>
			<%
				}
			%>
			<hr>
		</div>
	</body>
</html>