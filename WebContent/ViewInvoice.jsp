<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import = "com.bms.domain.Invoice" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View Agreement</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
  			<%@include file="resources/css/style-dashboard.css" %>
  			<%@include file="resources/css/style-main.css" %>
		</style>
</head>
<body>
<%
Invoice invoice = (Invoice)request.getAttribute("invoice");

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

%>
<ul class="sidenav">
			<li><a href="adminHome.do">DashBoard</a></li>
			<li><a href="listProspect.do">Prospect</a></li>
			<li><a href="listProposal.do">Proposal</a></li>
			<li><a href="listAgreement.do">Agreement</a></li>
			<li><a href="listProject.do">Project</a></li>
			<li><a class="active" href="listMilestone.do">Payment</a></li>
			<li><a href="listEmployee.do">Employee</a></li>	
</ul>
            <div class="content">
			<div class="navbar">
  				<a href="toAddMilestonePage.do">Add Milestones</a> 
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<h1 class="header-list">Invoice</h1>
				<div class="container table-center">
<table class="table-vertical table-hover">
<tr>
<td>Invoice No:</td>
<td><%= invoice.getCustomerName() %></td>
</tr>

<tr>
<td>Description:</td>
<td><%= invoice.getDescription() %></td>
</tr>

<tr>
<td>Customer Name:</td>
<td><%= invoice.getCustomerName() %></td>
</tr>

<tr>
<td>Amount:</td>
<td><%= invoice.getAmount() %></td>
</tr>
<tr>
<td>Invoice Date:</td>
<td><%= formatter.format(invoice.getInvoiceDate()) %></td>
</tr>
<tr>
<td>Payment Due Date:</td>
<td><%= formatter.format(invoice.getPaymentDueDate()) %></td>
</tr>
</table>
<form action="downloadFile.do" method="post">
<input type="hidden" name="url" value="<%=invoice.getLinkToFile() %>">
<button class="btn"><i class="fa fa-download"></i> Download</button>
</form>
</div>
</div>
</div>
</body>
</html>