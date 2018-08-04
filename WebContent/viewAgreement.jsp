<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import = "com.bms.domain.Agreement" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
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
		
		<% Agreement agreement = (Agreement)request.getAttribute("agreementObj");
		
		   String prospectName = (String)request.getAttribute("prospectName");
		   
		   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  	
		%>
		<ul class="sidenav">
			<li><a href="adminHome.do">DashBoard</a></li>
			<li><a href="listProspect.do">Prospect</a></li>
			<li><a href="listProposal.do">Proposal</a></li>
			<li><a class="active" href="listAgreement.do">Agreement</a></li>
			<li><a href="listProject.do">Project</a></li>
			<li><a href="listMilestone.do">Payment</a></li>
			<li><a href="listEmployee.do">Employee</a></li>	
		</ul>
		<div class="content">
			<div class="navbar">
  				<a href="toAddAgreementPage.do">Add Agreement</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<h1 class="header-list">Agreement List</h1>
				<div class="container table-center">
					<table class="table-vertical table-hover">
						<%-- <tr>
							<td> Agreement ID: </td>
							<td><%= agreement.getAgreementId() %></td>
						</tr>
						<tr>
							<td> Prospect ID: </td>
							<td><%= agreement.getProspectId() %></td>
						</tr> --%>
						<tr>
							<th> Prospect Name: </th>
							<td><%= prospectName %></td>
						</tr>
						<tr>
							<th> Date of Agreement: </th>
							<td><%= formatter.format(agreement.getDateOfAgreement()) %></td>
						</tr>
						<tr>
							<th> Finishing Date: </th>
							<td><%= formatter.format(agreement.getFinishingDate()) %></td>
						</tr>
						<tr>
							<th> Period of Contract(In no of months) : </th>
							<td><%= agreement.getPeriodOfContract() %></td>
						</tr>
						<tr>
							<th> Estimate Amount : </th>
							<td><%= agreement.getEstimateAmount() %></td>
						</tr>
						<tr>
							<th> Termination Conditions: </th>
							<td><%= agreement.getTerminationConditions() %></td>
						</tr>
						<tr>
					</table>
					
					<% if(!agreement.isConfirm())
					{%>
						<p class="err">This agreement is not confirmed</p>
						<div class="col-sm-6">
						<form action="confirmAgreement.do" method="post">
							<input type="hidden" name="agreementId" value="<%=agreement.getAgreementId()%>">
							<button type="submit" class="btn" onclick="return confirm('Once confirmed you wont be able to edit. Sure you want to confirm ?');"><i class="fa fa-check"></i> Confirm Agreement</button>
						</form>
						</div>
					<%}  else {%>
						<p class="succ"> This is a confirmed agreement </p>
					<%} %>
					<div class="col-sm-6" style="float: right;">
					<form action="downloadFile.do" method="post">
                       <input type="hidden" name="url" value="<%=agreement.getLinkToFile()%>">
                       <button class="btn"><i class="fa fa-download"></i> Download</button>
                    </form>
                    </div>
    			</div>
			</div>
		</div>
	</body>
</html>