<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="com.bms.domain.Prospect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<title>Add Proposal</title>
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
	$(document).ready(function(){
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
 	if(dd<10){
      	  dd='0'+dd
   	} 
    	if(mm<10){
     	   mm='0'+mm
    	} 

	today = yyyy+'-'+mm+'-'+dd;
	document.getElementById("datefield").setAttribute("max", today);
	
	});
</script>
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
				<a href="listProposal.do">List Proposal</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<div class="form-css">
				<form action="addProposal.do" method="post" enctype="multipart/form-data" >
					<h1 class="header-list">Add Proposal</h1>
					<p>${message}</p>
					<div class="form-group">
						<label>Prospect :</label>
						<select name="prospectID" class="form-control"> 
							<%
								for(Prospect prospect: PROSPECT_LIST){
										Date today = new Date();
										today.setHours(0);
										Date deadline = prospect.getResponseDeadline();							
										if (deadline.compareTo(today) >= 0) {%>					        
								<option value=<%=prospect.getProspectID()%>><%=prospect.getProspectName()%></option>
							<%}}%>
						</select>
					</div>
					<div class="form-group">
						<label>Proposal Name:</label>
						<input type="text" class="form-control" name="proposalName" maxlength="30"/>
					</div>
					<div class="form-group">
						<label>Description: </label>
						<textarea rows="5" cols="5" name="description" class="form-control" ></textarea>
					</div>
					<div class="form-group">
						<label>Date of Acceptance: </label>
						<input type="date" class="form-control" name="dateOfAcceptance" id="datefield"/>
					</div>
					<div class="form-group">
						<label>Upload File: </label>
						<input type="file" class="form-control" name="uploadLink"/>
					</div>
					<div class="form-group align-center">
						<input type="hidden" name="confirm" value="false">
						<input type="reset" class="btn btn-danger active" value="Reset"/>
						<input type="submit" class="btn btn-default active reset-style" value="Add and Upload"/>
					</div>					
				</form>
				</div>
			</div>
		</div>
	</body>
</html>