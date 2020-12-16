<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import= "listamosului.baseclasses.Wish, listamosului.baseclasses.Account" %>
<%@ page import= "listamosului.managers.WishManager" %>


<%
	Account account = (Account) session.getAttribute("account");
	String wishText = request.getParameter("wisharea");
	System.out.println(wishText);
	
	Wish wish = (Wish) session.getAttribute("wish");
	if(wish == null) {
		wish = new Wish(0, wishText, account.getUser().getId());
		
		int inserted = WishManager.getInstance().insertWish(wish);
		
		if(inserted > 0) {
			session.setAttribute("wish", wish);
		}
	} else {
		wish.setWish(wishText);
		int updated = WishManager.getInstance().updateWish(wish);
		System.out.println(updated);
		
		if(updated > 0) {
			session.setAttribute("wish", wish);
			System.out.println("aici");
		}
	}
	
	response.sendRedirect("MainPage.jsp");
%>