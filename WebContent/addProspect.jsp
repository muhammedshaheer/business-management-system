<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.bms.domain.Customer" %>
<%@ page import = "com.bms.domain.Employee" %>

<%
	List<Customer> CUSTOMER_LIST = (List<Customer>)request.getAttribute("CUSTOMER_LIST");
	List<Employee> EMPLOYEE_LIST = (List<Employee>)request.getAttribute("EMPLOYEE_LIST");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Prospect</title>
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
		var nextyyyy = yyyy + 1;
 		if(dd<10){
      	  dd='0'+dd
   		} 
    	if(mm<10){
     	   mm='0'+mm
    	} 

		today = yyyy+'-'+mm+'-'+dd;
		nextYear = nextyyyy+'-'+mm+'-'+dd;
		document.getElementById("responseDeadline").setAttribute("min", today);
		document.getElementById("responseDeadline").setAttribute("max", nextYear);
		document.getElementById("dateOfIdentification").setAttribute("max", today);
	
	});
			
			$(document).ready(function(){
				
				$("#selectCustomer").click(function(){
					
					
					
					var input = document.getElementById("selectCustomer").value;
					
					
					
					if("addNewCustomer" == input){
						
						document.getElementById("newCustomer").style.display = "block";
					
					} else{
						
						document.getElementById("newCustomer").style.display = "none";
					}
				
				});
				
				$("#selectType").click(function(){
					
					
					
					var input = document.getElementById("selectType").value;
					
					
					
					if("RFT" == input){
						
						document.getElementById("tender").style.display = "block";
					
					} else{
						
						document.getElementById("tender").style.display = "none";
					}
				
				});
				
				
				
		});
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
				<a href="listProspect.do">List Prospect</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<div class="form-css">
					<h1 class="header-list">Prospect Add</h1>
					<form action="addProspect.do" enctype="multipart/form-data" method="post">
						<p>${errorMessage}</p>
	
						<div class="form-group">
							<label>Prospect Name</label>
							<input type="text" class="form-control" name="prospectName" required/>
						</div>
					
						<div class="form-group">
							<label>Date of Identification</label>
							<input type="date" class="form-control" name="dateOfIdentification" id="dateOfIdentification" required/>
						</div>
					
						<div class="form-group">
							<label>Specification</label>
							<textarea rows="5" cols="5" name="specification" class="form-control" ></textarea>
						</div>
					
						<div class="form-group">
							<label>Type of Prospect</label>
							<select name="typeOfProspect" id="selectType" class="form-control">
								<option selected disabled value="" >---Select Prospect--</option>
								<option value="RFP">Request for Proposal(RFP)</option>
								<option value="RFT">Request for Tender(RFT)</option>
								<option value="ITO">Information to Offer(ITO)</option>
							</select>
						</div>
						
						<div id="tender" class="custom-div" style="display:none;">
							<h3 class="align-center custom-head">Company requirements:</h3>
							
							<div class="row" style="padding: 10px;">
								<div><label >Min. experience(in years): </label><input type="number" class="form-control" name="reqExpYears" /></div>
							</div>
								
							<div class="row" style="padding: 10px;">
								<div><label>Min. no. of professional staff: </label><input type="number" class="form-control" name="reqProfStaff" /></div>
							</div>	
							
							<div class="row" style="padding: 10px;">
								<div><label>Average annual turnover: </label><input type="number" class="form-control" name="reqAnnTurnover" /></div>
							</div>	
							
						</div>
					
						<div class="form-group">
							<label>Sector</label>
							<select name="sector" class="form-control">
								<option selected disabled value="" >---Select Sector--</option>
								<option value="Public">Public</option>
								<option value="Private">Private</option>
							</select>
						</div>
					
						<div class="form-group">
							<label>Customer</label>
							<select name="customer" id="selectCustomer" class="form-control"  required placeholder="---Choose Customer---"> 
								<option selected disabled value="">---Choose Customer---</option>
								<%for(Customer customer: CUSTOMER_LIST){%>
								<option value=<%=customer.getCustomerID()%>><%=customer.getCustomerName()%></option>
								<%}%>
								
								<option value="addNewCustomer">Add new customer</option>
								<option value="yes">Add</option>
							</select>
						</div>
					
						<div id="newCustomer" class="custom-div" style="display:none;">
							<h3 class="align-center custom-head">New Customer:</h3>
							
							<div class="row" style="padding: 10px;">
								<!-- <div class="col-sm-4"><label >Name of the Company</label></div> 
								<div class="col-sm-8"><input type="text" class="form-control" name="customerCompanyName"/></div> -->
								<div><label >Name of the Company : </label><input type="text" class="form-control" name="customerCompanyName" /></div>
							</div>
								
							<div class="row" style="padding: 10px;">
								<!-- <div ><label>Email ID</label></div>
								<div ><input type="email" class="form-control" name="customerEmailID"/></div> -->
								<div><label>Email ID : </label><input type="email" class="form-control" name="customerEmailID" /></div>
							</div>	
						</div>
				
						<div class="form-group">
							<label>Source</label>
							<input type="text" class="form-control" name="source" required/>
						</div>
					
						<div class="form-group">
							<label>Response Deadline</label>
							<input type="date" class="form-control" name="responseDeadline" id="responseDeadline" required/>
						</div>
					
						<div class="form-group">
							<label>Employee in Charge</label>
							<select name="employeeInCharge" class="form-control" required > 
								<option selected disabled value="" >---Select Employee--</option>
								<%for(Employee employee: EMPLOYEE_LIST){%>
								<option value=<%=employee.getEmployeeID()%>><%=employee.getFirstName() + " " + employee.getLastName()%></option>
								<% } %>
							</select>
						</div>
				
						<div class="form-group">
							<label>Budget</label>
							<input type="number" class="form-control" name="budget" required step=".001" id="myHTMLnumber"/>
						</div>
					
						<div class="form-group">
							<label>Status</label>
							<select name="status" class="form-control">
								<option value="Accept">Accept</option>
								<option value="Pending" selected>Pending</option>
								<option value="Reject">Reject</option>
							</select>
						</div>
				
						<div class="form-group">
							<label>Category</label>
							<select name="category" class="form-control">
								<option selected disabled value="" >---Select Category--</option>
								<option value="Hot">Hot</option>
								<option value="Warm">Warm</option>
								<option value="Cold">Cold</option>
								<option value="NA">NA</option>
							</select>
						</div>
				
						<div class="form-group">
							<label for="file">Upload File</label>
							<input type="file" id="file" class="form-control" size="60" name="uploadLink" required/>
						</div>
					
						<div class="form-group align-center">
							<input type="reset" class="btn btn-danger" value="Reset"/>
							<input type="submit" class="btn btn-default active reset-style"  value="Add and Upload"/>
						</div>
					
					</form>
				</div>
			</div>
		</div>	
	</body>
</html>