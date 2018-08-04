<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import = "java.util.ArrayList,java.util.List,com.bms.domain.PaymentMilestone,com.bms.domain.Project,com.bms.domain.Payment" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Payment Milestone</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
  			<%@include file="resources/css/style-dashboard.css" %>
  			<%@include file="resources/css/style-main.css" %>
		</style>
	</head>
	<body>
		
	<script type="text/javascript">
		
				
				$(document).ready(function() {
					
					var msg = '${ERROR_MSG}';
					
					if("" != msg){
						
						alert(msg);
						
					}
	
				$(".invoice").click(function() {
	
					var form = document.createElement("form");
	
					form.method = "post";
	
					form.action = "generateInvoice.do";
	
					var input = document.createElement("input");
					
					input.setAttribute("type", "hidden")
	
					input.setAttribute("name", "milestoneId");
	
					input.setAttribute("value", event.target.id);
	
					form.appendChild(input);
	
					form.style.visiblity='hidden'; 
					
					document.body.appendChild(form);
	
					form.submit();
	
				});
				});
		</script>
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
  				<a href="toAddMilestonePage.do">Add Milestones</a> 
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<% 
					List<PaymentMilestone> milestoneList = (List<PaymentMilestone>)request.getAttribute("milestoneList");
					List<Project> projectList = (List<Project>)request.getAttribute("projectList");
					List<Payment> paymentList = (List<Payment>)request.getAttribute("paymentList");
	      		%>    
	      		<% 
	      			if(null == milestoneList){%>
	         		<h1>no added milestones</h1>
	         		<%} else { %>
	         		<h1 class="header-list">Payment Milestone</h1>
	            	<table class="table table-style table-hover">
		            	<tr>
			               	<th>Project Name</th>
			               	<th>Description</th>
			               	<th>Due Date</th>
			               	<th>Amount</th>
			               	<th>Status</th>
			               	<th>Invoice</th>
		            	</tr>
	              		<%for(PaymentMilestone milestone:milestoneList) { %>
	               		<tr>
	               			<td>
	               				<%
				   					for(Payment payment: paymentList){
					   					if(milestone.getPaymentId().equals(payment.getPaymentId())){
					      					for(Project project:projectList){
				               					if(project.getProjectID().equals(payment.getProjectId())){
						            				out.print(project.getProjectName());
					            				}
				          					}
					    				}
				  				}%>
	              			</td>
	              			<td><%= milestone.getDescription()%></td>
				            <td><%= milestone.getDueDate() %></td>
				            <td><%= milestone.getAmount() %></td>
	              			<td>
	              				<% if(milestone.isPayed()){%>
	              					Payed
	              				<%} else { %>
	              					Not payed
	              				<%} %>
	              			</td>
	              			<td><a id=<%=milestone.getMilestoneId() %> class="invoice">Generate Invoice</a>
	              		</tr>
	              		<%} %>
	              </table>
	              <% }%>
			</div>
		</div>	               
	</body>
</html>