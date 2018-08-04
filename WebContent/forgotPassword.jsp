<%@ page import="com.bms.web.action.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Forgot Password</title>		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
  			<%@include file="resources/css/style.css" %>
		</style>
		
		<%
			//String username = request.getParameter("username");	
			String username = (String) session.getAttribute("username");
			String mailID = username + "@gmail.com";				
			SentResetLinkAction send = new SentResetLinkAction();
			try{
				send.execute(request, response);
			}
			catch(NullPointerException e){				
				request.getRequestDispatcher("error.jsp").forward(request, response);
				e.printStackTrace();
			} 
		%>
	</head>
	
	<body>
	
	
		<h1 style="text-align: center;margin-top: 160px;">Reset link sent to : <%=mailID %></h1>
		<h2 style="text-align: center;margin-top: 32px;">Return to -> <a href="login.jsp">Login page</a></h2>
		<h4 style="text-align: center;margin-top: 16px;"><a href="forgotPassword.jsp?resent=true">Resent password link</a></h4>
		<%
			if(request.getParameter("resent").equals("true")){
		%>
		<div id="resent"><p>Your password reset link has been resent ^-^ </p></div>
		<%} %>
	</body>
</html>