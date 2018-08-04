<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.bms.domain.Payment"%>
<%@page import="com.bms.domain.Project"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	List<Payment> PAYMENT_LIST = (List<Payment>) request.getAttribute("paymentList");
	if(PAYMENT_LIST.isEmpty()){
		request.setAttribute("ERROR_MSG", "NO payments list");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	List<Project> PROJECT_LIST= (List<Project>) request.getAttribute("projectList");
	if(PROJECT_LIST.isEmpty()){
		request.setAttribute("ERROR_MSG", "NO project list");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Milestone</title>
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
			<li><a href="listProject.do">Project</a></li>
			<li><a class="active" href="listMilestone.do">Payment</a></li>
			<li><a href="listEmployee.do">Employee</a></li>	
		</ul>
		<div class="content">
			<div class="navbar">
  				<a href="listMilestone.do">List Milestones</a> 
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<div class="form-css">
				<form action="addMilestone.do" method="post">
					<h1 class="header-list">Add Payment Milestone</h1>
					<p>${message}</p>
					<div class="form-group">
						<label>Project Name: </label>
						<select name="paymentId" class="form-control">
						<%
							for(Payment payment: PAYMENT_LIST){%>
							<option value=<%=payment.getPaymentId()%>>
							<%for(Project project:PROJECT_LIST)
							{
								if(project.getProjectID().equals(payment.getProjectId())){
									out.print(project.getProjectName());
								}
							}
							%></option>
							<%}%>	
						</select>
					</div>
					<div class="form-group">
						<label>Description: </label>
					    <textarea rows="5" cols="4" class="form-control" name="description" required="required"></textarea>
					</div>
					<div class="form-group">
						<label>Amount: </label>
						<input type="number" class="form-control" name="amount" required="required"/>
					</div>
					<div class="form-group">
						<label>Due Date:</label>
						<input type="date" class="form-control" name="dueDate" required="required"/>
					</div>
					<div class="form-group align-center">
						<input type="hidden" name="payed" value="false">
						<input type="reset" class="btn btn-danger active" value="Reset"/>
						<input type="submit" class="btn btn-default active reset-style" value="Create MileStone" />
					</div>					
				</form>
				</div>
			</div>
		</div>
	</body>
</html>