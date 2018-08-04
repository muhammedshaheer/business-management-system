<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import = "com.bms.domain.Prospect" %>
<%@ page import = "com.bms.domain.Customer" %>
<%@ page import = "com.bms.domain.Employee" %>

<%
	List<Customer> customerList = (List<Customer>)request.getAttribute("customerList");
	List<Employee> employeeList = (List<Employee>)request.getAttribute("employeeList");
	Prospect prospect = (Prospect)request.getAttribute("prospect");
	Customer customer = (Customer)request.getAttribute("customer");
	Employee employee = (Employee)request.getAttribute("employee");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit Prospect Details</title>
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
				<div class="form-css">
					<h1 class="header-list">Edit Prospect</h1>
					<form action="editProspect.do" enctype="multipart/form-data" method="post">
						<p>${errorMessage}</p>
						
						<input type="hidden" name="prospectID" value=<%=prospect.getProspectID() %>>
	
						<div class="form-group">
							<label>Prospect Name</label>
							<input type="text" class="form-control" name="prospectName" value=<%=prospect.getProspectName() %>>
						</div>
					
						<input type="hidden" class="form-control" name="dateOfIdentification" value=<%=prospect.getDateOfIdentification() %>/>
					
						<div class="form-group">
							<label>Specification</label>
							<textarea rows="5" cols="5" name="specification" class="form-control"><%=prospect.getSpecification() %></textarea>
						</div>
					
						<div class="form-group">
							<label>Type of Prospect</label>
							<select name="typeOfProspect" class="form-control">
							<%
								if(prospect.getProspectType().equals("RFP")){%>
									<option value="RFP" selected="selected">Request for Proposal(RFP)</option>
									<option value="RFT">Request for Tender(RFT)</option>
									<option value="ITO">Information to Offer(ITO)</option>
								<%} else if(prospect.getProspectType().equals("RFT")){%>
									<option value="RFP">Request for Proposal(RFP)</option>
									<option value="RFT" selected="selected">Request for Tender(RFT)</option>
									<option value="ITO">Information to Offer(ITO)</option>
								<%} else if(prospect.getProspectType().equals("ITO")){%>
									<option value="RFP">Request for Proposal(RFP)</option>
									<option value="RFT">Request for Tender(RFT)</option>
									<option value="ITO" selected="selected">Information to Offer(ITO)</option>
								<%} %>
							</select>
						</div>
					
						
							<input type="hidden" class="form-control" name="sector" value=<%=prospect.getSector() %> readonly/>
		
					
						
							<input type="hidden" class="form-control" name="customer" value=<%=prospect.getCustomerID() %> readonly/>	
					
				
						<div class="form-group">
							<label>Source</label>
							<input type="text" class="form-control" name="source" value=<%=prospect.getSource() %>>
						</div>
					
						<div class="form-group">
							<label>Response Deadline</label>
							<input type="date" class="form-control" name="responseDeadline" value=<%=prospect.getResponseDeadline() %>/>
						</div>
					
						<div class="form-group">
							<label>Employee in Charge</label>
							<select name="employeeInCharge" class="form-control"> 
								<option value=<%=employee.getEmployeeID()%>><%=employee.getFirstName() + " " + employee.getLastName()%></option>
								<%for(Employee emp:employeeList){ 
										if(!((emp.getEmployeeID()).equals(employee.getEmployeeID()))){
									%>
								<option value=<%=emp.getEmployeeID() %>><%=emp.getFirstName() + " " + emp.getLastName() %></option>
								<%}
								}%>
							</select>
						</div>
				
						<div class="form-group">
							<label>Budget</label>
							<input type="text" class="form-control" name="budget" value=<%=prospect.getBudget() %>>
						</div>
					
						<div class="form-group">
							<label>Status</label>
							<select id=<%=prospect.getProspectID() %> name="status" class="form-control">
								<option value=<%=prospect.getStatus()%>><%=prospect.getStatus()%></option>
								<%for(String status:Prospect.prospectStatus()){ 
										if(!status.equals(prospect.getStatus())){
									%>
								<option value=<%=status %>><%=status %></option>
								<%}
								}%>
							</select>
						</div>
				
						<div class="form-group">
							<label>Category</label>
							<select id=<%=prospect.getProspectID() %> name="category" class="form-control">
								<option value=<%=prospect.getCategory()%>><%=prospect.getCategory()%></option>
								<%for(String category:Prospect.prospectCategory()){ 
										if(!category.equals(prospect.getCategory())){
									%>
								<option value=<%=category%>><%=category%></option>
								<%}
								}%>
							</select>
						</div>
				
						<div class="form-group">
							<label>Upload File</label>
							<input type="file" class="form-control" name="uploadLink" required/>
						</div>
					
						<div class="form-group align-center">
							<input type="submit" class="btn btn-default active reset-style"  value="Update" onclick="return confirm('Save changes?');"/>
						</div>
					
					</form>
				</div>
			</div>
		</div>	
	</body>
</html>