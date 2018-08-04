<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Customer</title>
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
  				<a href="addCustomer.jsp">Add Customer</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<div class="form-css">
				<form action="addCustomer.do" method="post">
					<h1 class="header-list">Add Customer</h1>
					<p>${errorMessage}</p>
					<div class="form-group">
						<label>Customer Name: </label>
						<input type="text" class="form-control" name="customerName" required/>
					</div>
					<div class="form-group">
						<label>Contact Person: </label>
						<input type="text" class="form-control" name="contactPerson" required/>
					</div>
					<div class="form-group">
						<label>Email ID:</label>
						<input type="email" class="form-control" name="customerEmailID" required/>
					</div>
					<div class="form-group">
						<label>Phone Number: </label>
						<input type="text" class="form-control" name="customerPhone" required/>
					</div>
					<div class="form-group align-center">
						<input type="reset" class="btn btn-danger active" value="Reset"/>
						<input type="submit" class="btn btn-default active reset-style" value="Add"/>
					</div>					
				</form>
				</div>
			</div>
		</div>
	</body>
</html>