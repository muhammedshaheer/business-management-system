<%@ page import="com.bms.domain.Project"%>
<%Project project = (Project)request.getAttribute("project"); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View project</title>
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
			<li><a class="active" href="listProject.do">Project</a></li>
			<li><a href="listMilestone.do">Payment</a></li>
			<li><a href="listEmployee.do">Employee</a></li>	
		</ul>
		<div class="content">
			<div class="navbar">
  				<a href="toAddProject">Add project</a>
				<a href="listProject.do">List Project</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<h1 class="header-list"><%=project.getProjectName() %></h1>
				<div class="container table-center">
				<table class="table-vertical table-hover">		
					<tr>
						<th>Project name</th>
						<td><%=project.getProjectName() %></td>
					</tr>
					<tr>
						<th>Commencement date</th>
						<td><%=project.getCommencementDate() %></td>
					</tr>
					<tr>
						<th>Completion date</th>
						<td><%=project.getCompletionDate() %></td>
					</tr>
					<tr>
						<th>Project status</th>
						<td><%=project.getStatus() %></td>
					</tr>
					<tr>
						<th>Project head</th>
						<td><%=project.getProjectHead() %></td>
					</tr>					
				</table>
				</div>
			</div>
		</div>	
	</body>
</html>