<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "listamosului.baseclasses.Account, listamosului.baseclasses.Wish" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista lui Mos Craciun</title>
		<link rel="stylesheet" type="text/css" href="../Styles/ChristmasStyle.css"/>
	</head>
	
	<script>
		<%@include file="Redirect.jsp"%>
	</script>
	
	<%
		Account account = (Account) session.getAttribute("account");
	%>
	
	<body>
		<div id="header">
			<hr>
			<h1>Mos Craciun</h1>
			<hr>
		</div>
		
		<div id="body">
			<hr>
			<h2>Ho Ho! Buna <%= account.getUser().getLastName() %> <%=  account.getUser().getFirstName() %></h2>
			
			<%
				String cuminte;
				if(account.getUser().isNice()) {
					cuminte = "cuminte";
				} else {
					cuminte = "obraznic";
				}
			%>
			
			<h2>Anul acesta ai fost <%= cuminte %></h2>
			
			<h2>Scrie-i o scrisoare lui Mos Craciun:</h2>
			<form action="Wish_is_sent.jsp" method="POST">
			<textarea class="wisharea" id="wisharea" name="wisharea" rows="25" cols="40" style="font-size: 20px;">
			<%
				Wish wish = (Wish) session.getAttribute("wish");
				if(wish != null) {
					out.print(wish.getWish());
				} else {
					out.print("Scrisoare catre Mos Craciun...");
				}
			%>
			</textarea> 
			<br><hr>
			
				<input type="submit" name="submitWish" value="Trimite">
			</form>
			<br>
			<form action="Login.jsp" method="POST">
				<input type="submit" name="submitToLogin" value="Delogheaza-te">
			</form>
			<hr>
		</div>
	</body>
</html>