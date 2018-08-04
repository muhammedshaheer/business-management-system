<%@page import="com.bms.domain.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% List<Employee> employees = (List<Employee>)request.getAttribute("database");
%>

<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Employee List</title>
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
				
				$(".viewEmployee").click(function() {			
					var form = document.createElement("form");
					form.method = "post";
					form.action = "viewEmployee.do";
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "employeeID");
					input.setAttribute("value", event.target.id);
					form.appendChild(input);
					form.style.visiblity='hidden'; 
					document.body.appendChild(form);
					form.submit();
				});
				
				$(".changeDesignation").click(function() {					
					var selectedID = event.target.id;					
					$(".changeDesignation[id=" + selectedID + "]").hide();					
					$(".designation[id=" + selectedID + "]").hide();					
					$("select[name='designation'][id=" + selectedID + "]").show();					
					$(".saveDesignation[id=" + selectedID + "]").show();					
				});
				
				$(".saveDesignation").click(function() {					
					var form = document.createElement("form");	
					form.method = "post";	
					form.action = "changeEmployeeRole.do";	
					var input1 = document.createElement("input");					
					input1.setAttribute("type", "hidden");
					input1.setAttribute("name", "employeeID");
					input1.setAttribute("value", event.target.id);
					form.appendChild(input1);					
					var chosen = $("select[name='designation'][id=" + event.target.id + "]").val();									
					var input2 = document.createElement("input");					
					input2.setAttribute("type", "hidden");
					input2.setAttribute("name", "designation");
					input2.setAttribute("value", chosen);
					form.appendChild(input2);	
					form.style.visiblity='hidden'; 					
					document.body.appendChild(form);	
					form.submit();	
				});
				
				$(".employeeDesig").click(function() {
					var form = document.createElement("form");
					form.method = "post";
					form.action = "listEmployee.do";
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "employeeDesig");	
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
			<li><a href="listMilestone.do">Payment</a></li>
			<li><a class="active" href="listEmployee.do">Employee</a></li>	
		</ul>
		<div class="content">
			<div class="navbar">
  				<a href="addEmployee.jsp">Add Employee</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
			<%if(null != employees){ %>
				<h1 class="header-list">Employee List</h1>
				
				<a class="employeeDesig tablink" id="all">All</a>
    			<a class="employeeDesig tablink" id="seniors">Senior Officers</a>
    			<a class="employeeDesig tablink" id="sales">Sales</a>
    			<a class="employeeDesig tablink" id="managers">Managers</a>
					<table class="table table-style">
	    				<tr>
						    <!-- <th>ID</th> -->
							<th>NAME</th>
							<th>DESIGNATION</th>
							<th>EMAIL ID</th>
							<th>PHONE NUMBER</th>
					    </tr>				    	
	      				<%for(Employee e : employees){ %>
						<tr>
							<%-- <td><%=e.getEmployeeID() %></td> --%>
							<td class="viewEmployee" id='<%=e.getEmployeeID() %>'><%=e.getFirstName() + " " + e.getLastName() %></td>
							
							<td id=<%=e.getEmployeeID() %>>
							
								<div class="designation" id=<%=e.getEmployeeID()%> style="float: left;">
									<p><b><%=e.getDesignation() %></b></p>
								</div>
								<div  style="float: right;">
									<a class="changeDesignation" id=<%=e.getEmployeeID()%>><i class="fa fa-pencil" style="font-size: 16px;"></i> Change</a>
								</div>
								
								
								
								<select id=<%=e.getEmployeeID() %> name="designation" class="form-control" style='display:none;'>
								<option value=<%=e.getDesignation()%>><%=e.getDesignation()%></option>
								<%for(String designation:Employee.employeeDesignation()){ 
										if(!designation.equals(e.getDesignation())){
								%>
								<option value=<%=designation%>><%=designation%></option>
								<%}
								}%>
								</select>
							
								<a id=<%=e.getEmployeeID() %> class="saveDesignation" style='display:none;' onclick="return confirm('Save changes?');">Save</a>
							
							</td>
							
							<td><%=e.getEmailId()%></td>
							
							<td><%=e.getPhoneNumber() %></td>
							
						</tr>
						<%}%>					    
	    			</table>
	    			<%} else {%>
	    				<h1 class="header-list"> Employee List</h1>
	    				<div style="margin-top: 20px;">
		    				<a class="employeeDesig tablink" id="all">All</a>
	    					<a class="employeeDesig tablink" id="seniors">Senior Officers</a>
	    					<a class="employeeDesig tablink" id="sales">Sales</a>
	    					<a class="employeeDesig tablink" id="managers">Managers</a>
	    				</div>
    					<div class="col-sm-12">
							<p class="err">No employees found in this section</p>
						</div>
	    			<%} %>
			</div>
		</div>

	</body>
</html>