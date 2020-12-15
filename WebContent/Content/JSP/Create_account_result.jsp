<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "listamosului.tools.DataValidation, listamosului.managers.AccountManager, java.util.*" %>
<%@ page import= "listamosului.managers.UserManager, java.time.LocalDate, listamosului.baseclasses.User" %>
<%@ page import= "listamosului.baseclasses.Account" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<%
			boolean goToMainPage = false;
		
			String email = request.getParameter("email");
			String username = request.getParameter("user");
			String password = request.getParameter("pass");
			String lastName = request.getParameter("lastname");
			String firstName = request.getParameter("firstname");
			String address = request.getParameter("address");
			String bday = request.getParameter("birthday");
			
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
					break;
				}
				
				if(!validation.checkUsername(username)) {
					break;
		%>
			<h2>Numele de utilizator este gresit!</h2>
			<h2>Nu folositi caracter speciale.</h2>
		<%
				}
				
				if(!validation.checkPassword(password)) {
					break;
		%>
			<h2>Parola este gresita!</h2>
			<h2>Nu folositi alte caracter speciale in loc de ?!+_</h2>
		<%
				}
				
				if(!validation.checkLName(lastName)) {
					break;
		%>
			<h2>Numele este gresit!</h2>
			<h2>Nu folositi caractere speciale!</h2>
		<%
				}
				
				if(!validation.checkFName(firstName)) {
					break;
		%>
			<h2>Prenumele este gresit!</h2>
			<h2>Nu folositi caractere speciale!</h2>
		<%
				}
				
				if(!validation.checkAddress(address)) {
					break;
		%>
			<h2>Adresa este gresita!</h2>
			<h2>Nu folositi caractere speciale!</h2>
		<%
				}
				
				if(!validation.checkDate(bday)) {
					break;
		%>
			<h2>Data nasterii este gresita!</h2>
			<h2>Introduceti o data valida in formatul "yyyy-MM-dd"</h2>
		<%
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
					final Account acc = new Account(0, username, password, user);
					
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
	</body>
</html>