<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bms.domain.Proposal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<%
		Proposal proposal = (Proposal) request.getAttribute("proposal");

  		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  	
	%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View proposal</title>
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
		<script type="text/javascript">
		
			$(document).ready(function(){
				
				var status='<%=proposal.getStatus()%>';
				
				if("Accept" == status){
					
					$("#acceptButton").hide();
					$("#editButton").hide();
					
				} else{
					
					$("#acceptButton").show();
					$("#editButton").show();
					
				}
				
				$(document).ready(function() {
					$(".download").click(function() {
								var form = document.createElement("form");
								form.method = "post";
								form.action = "downloadFile.do";
								var input = document.createElement("input");
								input.setAttribute("type", "hidden");
								input.setAttribute("name", "url");	
								input.setAttribute("value", event.target.id);	
								form.appendChild(input);	
								form.style.visiblity='hidden'; 					
								document.body.appendChild(form);	
								form.submit();	
							});});
			
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
  				<a href="toAddProposalPage.do">Add Proposal</a>
				<a href="listProposal.do">List Proposal</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<h1 class="header-list"><%=proposal.getProposalName() %></h1>
				<div class="container table-center">
					<table class="table-vertical table-hover">
						<tr>
							<th>Proposal Name</th>
							<td><%=proposal.getProposalName() %></td>
						</tr>
						<tr>
							<th>Proposal ID</th>
							<td><%=proposal.getProposalID() %></td>
						</tr>
						<tr>
							<th>Date of Acceptance</th>	
							<td><%=formatter.format(proposal.getDateOfAcceptance()) %></td>
						</tr>
						<tr>
							<th>Last Modified</th>
							<td><%= formatter.format(proposal.getDateOfModification()) %>
						<tr>
						<tr>
							<th>Download</th>
							<td class="align-center" style="vertical-align: middle;font-size: 24px;">
								<a id='<%=proposal.getLinkToFile()%>' class="download"><i class="fa fa-download" id='<%=proposal.getLinkToFile()%>'></i></a>
							</td>
						</tr>			
					</table>
					<form method="post">
						
						<input type="hidden" value='<%=proposal.getProposalID()%>' name="proposalID">
						
						<button class="btn" onclick='this.form.action="updateProposalStatus.do";' id="acceptButton">Accept Proposal</button>
						<button class="btn" onclick='this.form.action="toEditProposalPage.do";' id="editButton">Edit Proposal</button>
			
					
					</form>
					
					
    			</div>
			</div>
		</div>
	</body>
</html>