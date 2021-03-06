<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bms.domain.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Customer customer = (Customer) request.getAttribute("customer");
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  	
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View Customer</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
  			<%@include file="resources/css/style-dashboard.css" %>
  			<%@include file="resources/css/style-main.css" %>
		</style>
	</head>
	<body>
		<ul class="sidenav">
			<li><a href="adminHome.do">DashBoard</a></li>
			<li><a href="listProspect.do">Prospect</a></li>
			<li><a href="listProposal.do">Proposal</a></li>
			<li><a href="listAgreement.do">Agreement</a></li>
			<li><a href="listProject.do">Project</a></li>
			<li><a href="listMilestone.do">Payment</a></li>
			<li><a href="listEmployee.do">Employee</a></li>	
		</ul>
		<div class="content">
			<div class="navbar">
  				<a href="addCustomer.do">Add Customer</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<h1 class="header-list"><%=customer.getCustomerName() %></h1>
				<table class="table-vertical table-hover">		
					<tr>
						<th>Name</th>
						<td><%=customer.getCustomerName() %></td>
					</tr>
					<tr>
						<th>Contact Person</th>
						<td><%=customer.getContactPerson() %></td>
					</tr>
					<tr>
						<th>Email-Id</th>
						<td><%=customer.getCustomerEmailID() %></td>
					</tr>
					<tr>
						<th>Phone</th>
						<td><%=customer.getCustomerPhone() %></td>
					</tr>					
				</table>
			</div>
		</div>
	</body>
</html>