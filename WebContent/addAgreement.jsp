<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.bms.domain.Prospect"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

	List<Prospect> PROSPECT_LIST = (List<Prospect>) request.getAttribute("prospectList");

	if(PROSPECT_LIST.isEmpty()){
		
		request.setAttribute("ERROR_MSG", "NO prospects");
		
		request.getRequestDispatcher("error.jsp").forward(request, response);
		
	}

%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Agreement</title>
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
			<li><a class="active" href="listAgreement.do">Agreement</a></li>
			<li><a href="listProject.do">Project</a></li>
			<li><a href="listMilestone.do">Payment</a></li>
			<li><a href="listEmployee.do">Employee</a></li>	
		</ul>
		<div class="content">
			<div class="navbar">
				<a href="listAgreement.do">List Agreement</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<div class="form-css">
				<form action="addAgreement.do" enctype="multipart/form-data" method="post">
					<h1 class="header-list">Add Agreement</h1>
					<p>${message}</p>
					<div class="form-group">
						<label>Prospect </label>
                        <select name="prospectId" class="form-control"> 
							<%
								for(Prospect prospect: PROSPECT_LIST){%>
								<option value=<%=prospect.getProspectID()%>><%=prospect.getProspectName()%></option>
							<%}%>
						</select>
					</div>
					<div class="form-group">
						<label>Date Of Agreement:</label>
						<input type="date" class="form-control" name="dateOfAgreement"/>
					</div>
					<div class="form-group">
						<label>Finishing Date:</label>
						<input type="date" class="form-control" name="finishingDate"/>
					</div>
					<div class="form-group">
						<label>Estimate Amount:</label>
						<input type="number" class="form-control" name="estimateAmount"/>
					</div>
					<div class="form-group">
						<label>Period Of Contract(Enter in number of months):</label>
						<input type="number" class="form-control"  name="periodOfContract"/>
					</div>
					<div class="form-group">
						<label>Termination Conditions:</label>
						<textarea rows="5" cols="4" class="form-control" name="terminationConditions"></textarea>
	
					</div>
					<div class="form-group">
						<label>Upload File:</label>
						<input type="file" class="form-control" name="uploadLink"/>
					</div>
					<div class="form-group align-center">
						<input type="hidden" name="confirm" value="false">
						<input type="reset" class="btn btn-danger active" value="Reset"/>
						<input type="submit" class="btn btn-default active reset-style" value="Add">
					</div>					
				</form>
				
				</div>
			</div>
		</div>
	</body>
</html>