<%@page import="com.bms.domain.Project"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<% 	
	List<Project> projects = (List<Project>) request.getAttribute("projectList");
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Project List</title>
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
				
				var flag = '${noAgreement}';
				
				if(flag=="true")
					 alert("No agreements!");
				
				$(".viewProject").click(function() {			
					var form = document.createElement("form");
					form.method = "post";
					form.action = "viewProject.do";
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "projectID");
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
			<li><a class="active" href="listProject.do">Project</a></li>
			<li><a href="listMilestone.do">Payment</a></li>
			<li><a href="listEmployee.do">Employee</a></li>	
		</ul>
		
		<div class="content">
			<div class="navbar">  	 	
			
			<a href="toAddProject.do">Add Project</a>
			
  			<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
			
				<%
				if(null != projects){
				%>
				<h1 class="header-list">Project List</h1>
				
					<table class="table table-style">
	    				<tr>
						    <!-- <th>ID</th> -->
							<th>NAME</th>
							<th>COMMENCEMENT DATE</th>
							<th>COMPLETION DATE</th>
							<th>STATUS</th>
							<th>PROJECT HEAD</th>
					    </tr>				    	
	      				<%
	      				for(Project p : projects){
	      				%>
						<tr>
							<td class="viewProject" id=<%=p.getProjectID() %>><%=p.getProjectName() %></td>
							<td class="viewProject" id=<%=p.getProjectID() %>><%=p.getCommencementDate() %></td>
							<td class="viewProject" id=<%=p.getProjectID() %>><%=p.getCompletionDate()%></td>
							<td class="viewProject" id=<%=p.getProjectID() %>><%=p.getStatus()%></td>
							<td class="viewProject" id=<%=p.getProjectID() %>><%=p.getProjectHead()%></td>
						</tr>
						<%}
	      				}
	      				else{
						%>	
							<div>	<h1 class="header-list">${message}</h1></div>	
							
						<%
	      				}
	      				request.setAttribute("message", "");
						%>			    
	    			</table>
			</div>
		</div>

</body>
</html>