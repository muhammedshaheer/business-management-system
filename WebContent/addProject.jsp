<%@ page import="java.util.ArrayList" %>
<%System.out.println("in add project.jsp"); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add project</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
  			<%@include file="resources/css/style-dashboard.css" %>
  			<%@include file="resources/css/style-main.css" %>
		</style>
	</head>
	<body>
		<script type="text/javascript">
			var letters = /^[0-9]+$/;
			function validateId() {
				var uadd = document.project.projectID;
				if(uadd.value.match(letters))
				{
					document.project.projectName.focus();
					return true;
				}
				else
				{
				  	alert('Project Id must have numeric characters only');
				  	uadd.focus();
				  	return false;
				}
			}
			
			function validateAgreementId() {
				var uadd = document.project.agreementID;
				if(uadd.value.match(letters))
				{
				  	return true;
				}
				else
				{
				  	alert('Agreement Id must have numeric characters only');
				  	uadd.focus();
				  	return false;
				}
			}
		
		</script>
		
		<ul class="sidenav">
			<li><a href="adminHome.do">DashBoard</a></li>
			<li><a href="listProspect.do">Prospect</a></li>
			<li><a href="listProposal.do">Proposal</a></li>
			<li><a href="listAgreement.do">Agreement</a></li>
			<li><a class="active" href="listProject.do">Project</a></li>
			<li><a href="listMilestone.do">Payment</a></li>
			<li><a href="listEmployee.do">Employee</a></li>	
		</ul>
		<div class="content">
			<div class="navbar">
				<a class="active" href="listProject.do">List Project</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<div class="form-css">
				<form id="project" name="project" action="addProject.do" method="post">
					<h1 class="header-list">Add Project</h1>
					<p>${errorMessage}</p>
					<p>${successMessage}</p>
					<div class="form-group">
						<label>Project Name: </label>
						<input type="text" class="form-control" name="projectName" required/>
					</div>
					<div class="form-group">
						<label>Commencement Date:</label>
						<input type="date" class="form-control" name="commencementDate" required/>
					</div>
					<div class="form-group">
						<label>Completion Date: </label>
						<input type="date" class="form-control" name="completionDate" />
					</div>
					<div class="form-group">
						<label>Status: </label>
						<select name="status" class="form-control" form="project">
 			 				<option value="Not Started" selected="selected">Not started</option>
  			 				<option value="In Progress">In progress</option>
  			 				<option value="Testing">Testing</option>
  			 				<option value="Deployed">Deployed</option>
						</select>
					</div>
					<div class="form-group">
						<label>Prospect Name: </label>
						<!-- <input type="text" class="form-control" name="agreementID" placeholder="Agreement ID" onblur="validateAgreementId()" required/> -->
						<select name="prospectName" class="form-control" form="project" required>
							<%
								ArrayList<String> prospectNames = (ArrayList<String>) request.getAttribute("prospectNames"); 
								for (String i : prospectNames){
							%>
 			 				<option value="<%=i%>" ><%=i %></option>
							<%} %>
						</select>
					</div>
					<div class="form-group">
						<label>Project Head: </label>
						<!-- <input type="text" class="form-control" name="projectHead" placeholder="Project Head" required/> -->
						<select name="projectHead" class="form-control" form="project" required>
						<%
								ArrayList<String> employees = (ArrayList<String>) request.getAttribute("employees"); 
								for (String i : employees){
							%>
 			 				<option value="<%=i%>" ><%=i %></option>
							<%} %>
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