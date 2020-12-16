<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "listamosului.baseclasses.Account" %>

<% 
	if((Account) session.getAttribute("account") == null) {
		session.invalidate();
		response.sendRedirect("Login.jsp");
	}
%>