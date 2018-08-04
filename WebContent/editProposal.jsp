<%@page import="com.bms.domain.Proposal"%>
<%@page import="com.bms.service.ProspectServiceImpl"%>
<%@page import="com.bms.service.ProspectService"%>
<%@page import="java.util.List"%>
<%@page import="com.bms.domain.Prospect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

	Proposal proposal = (Proposal)request.getAttribute("proposal");
	Prospect prospect = (Prospect) request.getAttribute("prospect");


	
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit Proposal</title>
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
			<li><a class="active" href="listProposal.do">Proposal</a></li>
			<li><a href="listAgreement.do">Agreement</a></li>
			<li><a href="listProject.do">Project</a></li>
			<li><a href="listMilestone.do">Payment</a></li>
			<li><a href="listEmployee.do">Employee</a></li>	
		</ul>
		<div class="content">
			<div class="navbar">
  				<a href="addProposal.jsp">Add Proposal</a>
				<a href="listProposal.do">List Proposal</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<div class="form-css">
				<form action="editProposal.do" method="post" enctype="multipart/form-data" >
					<h1 class="header-list">Edit Proposal</h1>
					<p>${message}</p>
					<div class="form-group">
						<label>Prospect :</label>
						<select name="prospectID" class="form-control"> 
							
								<option value=<%=prospect.getProspectID()%>><%=prospect.getProspectName()%></option>
							
						</select>
					</div>
					<div class="form-group">
					
						<label>Proposal Name:</label>
						<input type="text" class="form-control" name="proposalName" value ='<%=proposal.getProposalName()%>' required/>
						</div>
					<div class="form-group">
						<label>Description: </label>
						<textarea rows="5" cols="5" name="description" class="form-control" maxlength="100" required><%=proposal.getDescription() %></textarea>
					</div>
					<div class="form-group">
						<label>Date of Acceptance: </label>
						<input type="date" class="form-control" name="dateOfAcceptance" id="dateOfAcceptance" value=<%=proposal.getDateOfAcceptance()%> readonly/>
					</div>
					<input type="hidden" name="proposalID" value=<%=proposal.getProposalID() %>>
					<div class="form-group">
						<label>Upload File: </label>
						<input type="file" class="form-control" name="uploadLink" required/>
					</div>
					<div class="form-group align-center">
						<input type="hidden" name="confirm" value="false">
						
						<input type="reset" class="btn btn-danger active" value="Reset"/>
						<input type="submit" class="btn btn-default active reset-style" value="Edit"/>
					</div>					
				</form>
				</div>
			</div>
		</div>
	</body>
</html>