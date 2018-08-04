<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bms.domain.Prospect"%>
<%@page import="com.bms.domain.Customer"%>
<%@page import="com.bms.domain.Employee"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Prospect prospect = (Prospect) request.getAttribute("prospect");
	Customer customer = (Customer) request.getAttribute("customer");
	Employee employee = (Employee) request.getAttribute("employee");
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  	
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View prospect</title>
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
		
		</script>
		
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
  				<a href="addProspectPage.do">Add Prospect</a>
  				<a href="listProspect.do">List Prospect</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<h1 class="header-list"><%=prospect.getProspectName() %></h1>
				<div class="table-center">
				<table class="table-vertical table-hover" style="margin-bottom: 10px;">
					<%-- <tr>
						<th>ID</th>
						<td><%=prospect.getProspectID() %></td>
					</tr> --%>
					<tr>
						<th>Name</th>
						<td><%=prospect.getProspectName() %></td>
					</tr>
					<tr>
						<th>Date of Identification</th>
						<td><%=formatter.format(prospect.getDateOfIdentification()) %></td>
					</tr>
					<tr>
						<th>Specification</th>
						<td><%=prospect.getSpecification() %></td>
					</tr>			
					<tr>
						<th>Type</th>
							<% if(prospect.getProspectType().equals("RFP")){%>
							<td>Request for Proposal (RFP)</td>
							<% }else if(prospect.getProspectType().equals("RFT")){%>
							<td>Request for Tender (RFT)</td>
							<% }else if(prospect.getProspectType().equals("ITO")){%>
							<td>Information to Offer (ITO)</td>
							<%}%>
					</tr>			
					<tr>
						<th>Sector</th>
						<td><%=prospect.getSector() %></td>
					</tr>
					<tr>
						<th>Customer</th>
						<td><%=customer.getCustomerName() %></td>
					</tr>			
					<tr>
						<th>Source</th>
						<td><%=prospect.getSource() %></td>
					</tr>			
					<tr>
						<th>Response Deadline</th>
						<td><%=formatter.format(prospect.getResponseDeadline()) %></td>
					</tr>
					<tr>
						<th>Employee in charge</th>
						<td><%=employee.getFirstName() + " " + employee.getLastName() %></td>
					</tr>		
					<tr>
						<th>Budget</th>
						<td><%double budget = prospect.getBudget(); budget/=1000;%><%=budget %></td>
					</tr>			
					<tr>
						<th>Status</th>
						<td><%=prospect.getStatus() %></td>
					</tr>			
					<tr>
						<th>Category</th>
						<td><%=prospect.getCategory() %></td>
					</tr>			 	
					<tr>
						<th>Download</th>
						<td class="align-center" style="vertical-align: middle;font-size: 24px;"><a id='<%=prospect.getLinkToFile()%>' class="download"><i class="fa fa-download" id='<%=prospect.getLinkToFile()%>'></i></a></td>
					</tr>
				</table>
				<div class="col-sm-6" style="float: right;">
				<form action="toEditProspect.do" method="post" style='display:inline;margin-left: 10px;'>
					<input type="hidden" name="prospectID" value="<%=prospect.getProspectID()%>">
					<button type="submit" class="btn"><i class="fa fa-edit" style="font-size: 18px;"></i> Edit Details</button>
				</form>	
				</div>
				<div class="col-sm-6" style="float: left;">
				<% if (!prospect.getStatus().equals("Accept")){%>				
				<form action="acceptProspect.do" method="post" style='display:inline;margin-left: 10px;'>
					<input type="hidden" name="prospectID" value="<%=prospect.getProspectID()%>">
					<button type="submit" class="btn" onclick="return confirm('Are you sure you want to accept?');" ><i class="fa fa-check" style="font-size: 18px;"></i> Accept Prospect</button>
				</form>
				<%}%>
				</div>
				</div>
			</div>
		</div>
		
		
	</body>
</html>