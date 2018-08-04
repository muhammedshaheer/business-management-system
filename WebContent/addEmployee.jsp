<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Employee</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
  			<%@include file="resources/css/style-dashboard.css" %>
  			<%@include file="resources/css/style-main.css" %>
		</style>
		<script type="text/javascript">
			var letters = /^[0-9]+$/;
			function validateId() {
				var uadd = document.employee.id;
				if(uadd.value.match(letters))
				{
				  	document.employee.firstName.focus();
				  	return true;
				}
				else
				{
				  	alert('Employee Id must have numeric characters only');
				  	uadd.focus();
				  	return false;
				}
			}
			
			function validatePhone() {
				var uadd = document.employee.phoneNumber;
				if(uadd.value.match(letters))
				{
				  	document.employee.submit.focus();
				  	return true;
				}
				else
				{
				  	alert('PhoneNumber must have numeric characters only');
				  	uadd.focus();
				  	return false;
				}
			}
			
		</script>
	</head>
	<body>
		<ul class="sidenav">
			<li><a href="adminHome.do">DashBoard</a></li>
			<li><a href="listProspect.do">Prospect</a></li>
			<li><a href="listProposal.do">Proposal</a></li>
			<li><a href="listAgreement.do">Agreement</a></li>
			<li><a href="listProject.do">Project</a></li>
			<li><a href="listMilestone.do">Payment</a></li>
			<li><a class="active" href="listEmployee.do">Employee</a></li>	
		</ul>
		<div class="content">
			<div class="navbar">
  				<a href="listEmployee.do">List Employee</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<div class="form-css">
				<form name="employee" action="addEmployee.do" method="post">
					<h1 class="header-list">Add Employee</h1>
					<p>${errorMessage}</p>
					<div class="form-group">
						<label>Employee Id: </label>
						<input type="text" class="form-control" name="id" onblur="validateId()" />
					</div>
					<div class="form-group">
						<label>First Name: </label>
						<input type="text" class="form-control" name="firstName" required="required"/>
					</div>
					<div class="form-group">
						<label>Last Name: </label>
						<input type="text" class="form-control" name="lastName" required="required"/>
					</div>
					<div class="form-group">
						<label>Designation: </label>
						<select name="designation" class="form-control" >
							<option value="selected" selected="selected" disabled="disabled" required="required">--select--</option>
							<option value="CEO">CEO</option>
							<option value="CTO">CTO</option>
							<option value="CFO">CFO</option>
							<option value="sales">Sales Executive</option>
							<option value="sales">Sales</option>
							<option value="Manager">Managers</option>
						</select>
					</div>
					<div class="form-group">
						<label>Email Id:</label>
						<input type="email" class="form-control" name="emailId" required="required" />
					</div>
					<div class="form-group">
						<label>Phone Number: </label>
						<input type="text" class="form-control" name="phoneNumber" required="required" onblur="validatePhone()" />
					</div>
					<div class="form-group align-center">
						<input type="reset" class="btn btn-danger active" value="Reset"/>
						<input type="submit" class="btn btn-default active reset-style" value="Add" />
					</div>					
				</form>
				</div>
			</div>
		</div>	
	</body>

</html>