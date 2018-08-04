<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bms.domain.Requirement"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Requirement req = (Requirement)request.getAttribute("req");
	Requirement currentStat = (Requirement)request.getAttribute("currentStat");
	int count = (Integer)request.getAttribute("count");
	int total = (Integer)request.getAttribute("total");
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Evaluate Tender</title>
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
			<li><a class="active" href="listProspect.do">Prospect</a></li>
			<li><a href="listProposal.do">Proposal</a></li>
			<li><a href="listAgreement.do">Agreement</a></li>
			<li><a href="listProject.do">Project</a></li>
			<li><a href="listMilestone.do">Payment</a></li>
			<li><a href="listEmployee.do">Employee</a></li>	
		</ul>
		<div class="content">
			<div class="navbar">
  				<a href="addProspect.jsp">Add Prospect</a>
  				<a href="listProspect.do">List Prospect</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<h1 class="header-list">Tender Eligibility</h1>
				<div class="container table-center">
				<table class="table-vertical table-hover">	
				<tr>
					<th></th>
					<th>Available</th>
					<th>Required</th>
				</tr>	
				<tr>
					<th>Experience (in years)</th>
					<td><%=currentStat.getExperience()%></td>
					<td><%=req.getExperience()%></td>
				</tr>
				<tr>
					<th>Professional Staff (nos.)</th>
					<td><%=currentStat.getProfessionalStaff()%></td>
					<td><%=req.getProfessionalStaff()%></td>
				</tr>					
				<tr>
					<th>Average Annual Turnover (in lakhs)</th>
					<td><%=currentStat.getAverageAnnualTurnover()%></td>
					<td><%=req.getAverageAnnualTurnover()%></td>
				</tr>				
			</table>					
			<div>
				<p class="succ"><%=count + " out of " + total + " conditions satisfied."%></p>
			</div>
			</div>
			</div>
		</div>
	</body>
</html>