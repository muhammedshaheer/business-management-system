<%@ page import="com.bms.web.action.ResetPasswordAction" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password updated</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
  			<%@include file="resources/css/style.css" %>
		</style>
</head>
<body>
<%
	//System.out.println("we are here");

	String password = request.getParameter("password");

	ResetPasswordAction reset = new ResetPasswordAction();
	
	try{
		
		reset.execute(request, response);
	
	}catch(NullPointerException e){
	
		out.println("Some error occured");
		
		e.printStackTrace();
		
		System.out.println("caught");
	}
	
	response.sendRedirect("login.jsp");
%>


</body>
</html>