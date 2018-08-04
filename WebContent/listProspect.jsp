<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@page import="org.springframework.transaction.annotation.Propagation"%>
<%@page import="java.util.List"%>
<%@page import="com.bms.domain.Prospect"%>
<%@page import="com.bms.domain.Employee"%>
<%@page import="com.bms.domain.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.concurrent.TimeUnit"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<% 
	List<Customer> customerList = (List<Customer>) request.getAttribute("customerList");
	List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
	List<Prospect> prospectList = (List<Prospect>) request.getAttribute("prospectList");
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List of Prospects</title>
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
				$(".viewProspect").click(function() {
					var form = document.createElement("form");
					form.method = "post";
					form.action = "viewProspect.do";
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "prospectID");
					input.setAttribute("value", event.target.id);
					form.appendChild(input);
					form.style.visiblity='hidden'; 
					document.body.appendChild(form);
					form.submit();
				});
			
				$(".viewCustomer").click(function() {		
					var form = document.createElement("form");
					form.method = "post";
					form.action = "viewCustomer.do";
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "customerID");
					input.setAttribute("value", event.target.id);
					form.appendChild(input);
					form.style.visiblity='hidden'; 
					document.body.appendChild(form);
					form.submit();
				});
				
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
				});
				
				$(".saveCategory").click(function() {					
					var form = document.createElement("form");	
					form.method = "post";	
					form.action = "updateProspectCategory.do";	
					var input1 = document.createElement("input");					
					input1.setAttribute("type", "hidden");
					input1.setAttribute("name", "prospectID");
					input1.setAttribute("value", event.target.id);
					form.appendChild(input1);					
					var chosen = $("select[name='category'][id=" + event.target.id + "]").val();									
					var input2 = document.createElement("input");					
					input2.setAttribute("type", "hidden");
					input2.setAttribute("name", "category");
					input2.setAttribute("value", chosen);
					form.appendChild(input2);	
					form.style.visiblity='hidden'; 					
					document.body.appendChild(form);	
					form.submit();	
				});
				
				$(".saveStatus").click(function() {	
					var form = document.createElement("form");
					form.method = "post";
					form.action = "updateProspectStatus.do";
					var input1 = document.createElement("input");	
					input1.setAttribute("type", "hidden");
					input1.setAttribute("name", "prospectID");
					input1.setAttribute("value", event.target.id);
					form.appendChild(input1);					
					var chosen = $("select[name='status'][id=" + event.target.id + "]").val();										
					var input2 = document.createElement("input");					
					input2.setAttribute("type", "hidden");
					input2.setAttribute("name", "status");
					input2.setAttribute("value", chosen);
					form.appendChild(input2);
					form.style.visiblity='hidden'; 	
					document.body.appendChild(form);
					form.submit();	
				});
				
				$(".prospectCat").click(function() {
					var form = document.createElement("form");
					form.method = "post";
					form.action = "listProspect.do";
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "prospectCat");	
					input.setAttribute("value", event.target.id);	
					form.appendChild(input);	
					form.style.visiblity='hidden'; 					
					document.body.appendChild(form);	
					form.submit();	
				});

				$(".changeCategory").click(function() {					
					var selectedID = event.target.id;					
					$(".changeCategory[id=" + selectedID + "]").hide();					
					$(".category[id=" + selectedID + "]").hide();					
					$("select[name='category'][id=" + selectedID + "]").show();					
					$(".saveCategory[id=" + selectedID + "]").show();					
				});
				
				$(".updateStatus").click(function() {					
					var selectedID = event.target.id;					
					$(".updateStatus[id=" + selectedID + "]").hide();					
					$(".status[id=" + selectedID + "]").hide();					
					$("select[name='status'][id=" + selectedID + "]").show();					
					$(".saveStatus[id=" + selectedID + "]").show();				
				});
				
				$(".evaluate").click(function() {
					var form = document.createElement("form");
					form.method = "post";
					form.action = "evaluateTender.do";
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "prospectID");
					input.setAttribute("value", event.target.id);
					form.appendChild(input);
					form.style.visiblity='hidden'; 
					document.body.appendChild(form);
					form.submit();
				});
				
				$("#next").click(function(){
					
					$("#nextSet").val("next");
					
				});
				
				$("#previous").click(function(){
					
					$("#nextSet").val("previous");
					
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
  				<a href="addProspectPage.do">Add Prospect</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<% if(null != prospectList){%>
					<h1 class="header-list">Prospect List</h1>
					<div class="search-container">
						<div class="search-input">
			      			<i class="fa fa-search"></i><input type="text" id ="searchInput" onkeyup="search()" autofocus="autofocus" autoTab="true" type="focus" placeholder="Search for Prospects" />
	    				</div>
    				</div>
	    			<div style="margin-top: 20px;">
		    			<a class="prospectCat tablink" id="all">All</a>
		    			<a class="prospectCat tablink" id="accepted">Accepted</a>
		    			<a class="prospectCat tablink" id="rejected">Rejected</a>
		    			<a class="prospectCat tablink" id="pending">Pending</a>
					</div>
					<div class="col-md-12">
						<p id="noProspects" class="err" style="display:none;">No Prospects Found</p>
					</div>
					<table class="table-style table table-hover" id="table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Customer</th>
							<th>Response Deadline</th>
							<th>Employee In Charge</th>
							<th>Type</th>
							<th>Category</th>
							<th>Status</th>
							<th>Download Link</th>
						</tr>
					</thead>
					<tbody>
						<%for(Prospect prospect:prospectList){ %>
							<tr data-toggle="tooltip" data-placement="left" title='<%= prospect.getSpecification()	%>'>
								<td class="viewProspect hover-cell" id='<%=prospect.getProspectID() %>'>
									<%=prospect.getProspectName()%>
								</td>
								<td id=<%=prospect.getCustomerID()%> class="viewCustomer hover-cell">
									<%for(Customer customer:customerList){
										if(customer.getCustomerID()==prospect.getCustomerID()){%>
											<%=customer.getCustomerName() %>
											<%break;
										}
									}%>
								</td>
								<td><%=formatter.format(prospect.getResponseDeadline())%>
									<% Date today = new Date();
										today.setHours(0);
										Date deadline = prospect.getResponseDeadline();							
										if (deadline.compareTo(today) >= 0) {					        
											long diff = deadline.getTime() - today.getTime();
							    			long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;%>							    
							   				<div style='color:green;'><b><%=days + " days left" %></b></div>					        
										<%} else if (deadline.compareTo(today) < 0) {%>					        
											<div style='color:red;'><i><b>Responses closed!</b></i></div>					       
										<% }	%>						
								</td>						
								<td id=<%=prospect.getEmployeeInChargeID()%> class="viewEmployee hover-cell">
									<%for(Employee employee:employeeList){
										if(Integer.parseInt(employee.getEmployeeID())==prospect.getEmployeeInChargeID()){%>
											<%=employee.getFirstName()+ " " + employee.getLastName() %>
											<%break;
										}
									}%>
								</td>						
								<% if(prospect.getProspectType().equals("RFP")){%>
									<td id='<%=prospect.getProspectID() %>'>Request for Proposal (RFP)</td>
								<% }else if(prospect.getProspectType().equals("RFT")){%>
									<td id='<%=prospect.getProspectID() %>'> Request for Tender (RFT)
										<center><button class="evaluate btn btn-primary" id=<%=prospect.getProspectID()%>>Evaluate</button></center>
									</td>
								<% }else if(prospect.getProspectType().equals("ITO")){%>
									<td id='<%=prospect.getProspectID() %>'>Information to Offer (ITO)</td>
								<%}%>							
								<!-- Change category -->						
								<td id=<%=prospect.getProspectID()%>>						
									<div class="category" id=<%=prospect.getProspectID()%> style="float: left;">
										<%=prospect.getCategory() %>
									</div>
									<div style="float: right;">
									<a class="changeCategory" id=<%=prospect.getProspectID()%>> &nbsp;<i class="fa fa-refresh" ></i>Update</a>							
									<select id=<%=prospect.getProspectID() %> name="category" class="form-control" style='display:none;'>
										<option value=<%=prospect.getCategory()%>><%=prospect.getCategory()%></option>
										<%for(String category:Prospect.prospectCategory()){ 
											if(!category.equals(prospect.getCategory())){									%>
												<option value=<%=category%>><%=category%></option>
											<%}
										}%>
									</select>
									</div>							
									<a id=<%=prospect.getProspectID() %> class="saveCategory" style='display:none;' onclick="return confirm('Save changes?');">Save</a>
								</td> 						
								<!-- Update status -->
								<td id=<%=prospect.getProspectID()%>>						
									<div class="status" id=<%=prospect.getProspectID()%> style="float: left;">
										<b><%=prospect.getStatus() %></b>
									</div>
									<div style="float: right; ">									<% 
									if(!prospect.getStatus().equals("Accept")/* ||(deadline.compareTo(today) >= 0) */){ %>
										<a class="updateStatus" id=<%=prospect.getProspectID()%>> &nbsp;<i class="fa fa-refresh" ></i>Update</a>							
										<select id=<%=prospect.getProspectID() %> name="status" class="form-control" style='display:none;'>
											<option value=<%=prospect.getStatus()%>><%=prospect.getStatus()%></option>
												<%for(String status:Prospect.prospectStatus()){ 
													if(!status.equals(prospect.getStatus())){ %>
														<option value=<%=status %>><%=status %></option>
													<%}
												}%>
										</select>							
										<a id=<%=prospect.getProspectID() %> class="saveStatus" style='display:none;' onclick="return confirm('Save changes?');">Save</a>
									<%} %>	
									</div>
								</td>						
								<td class="align-center" style="font-size: 28px;">
									<a id='<%=prospect.getLinkToFile()%>' class="download"><i class="fa fa-download" id='<%=prospect.getLinkToFile()%>'></i></a>
								</td>				
							</tr>				
							<%}%>
						</tbody>
					</table>
					<form action="listProspect.do" method="post" id="listForm">
						<input type="hidden" id="nextSet" name="nextSet" value="" />
						<input type="submit" value="previous" id="previous"/>
						<input type="submit" value="next" id="next"/>			
					</form>
				<%} else {%>
					<h1 class="header-list">Prospect List</h1>
						<div class="search-container">
							<div class="search-input">
					      		<i class="fa fa-search"></i><input type="text" id ="searchInput" onkeyup="search()" autofocus="autofocus" autoTab="true" type="focus" placeholder="Search for Prospects" />
			    			</div>
		    			</div>
		    			<div style="margin-top: 20px;">
			    			<a class="prospectCat tablink" id="all">All</a>
			    			<a class="prospectCat tablink" id="accepted">Accepted</a>
			    			<a class="prospectCat tablink" id="rejected">Rejected</a>
			    			<a class="prospectCat tablink" id="pending">Pending</a>
			    		</div>
			    		<div class="col-sm-12">
							<p class="err">No prospects found in this section</p>
						</div>
				<%} %>
			</div>
		</div>
		<script type="text/javascript">
		
			function search() {
			
		var input, filter, table, tr, td, i, flag=0;
		  
	 	input = document.getElementById("searchInput");
	  
	  	filter = input.value.toUpperCase().trim();
	  
	  	table = document.getElementById("table");
	  	
	  	$("#table").show();
	  
	  	tr = table.getElementsByTagName("tr");
	  
	  	for (i = 0; i < tr.length; i++) {
	  		
	   	 	td = tr[i].getElementsByTagName("td");
	   	 	
	   	 	j=0;
	   	 	
	   	 	while(j<=3){
	   	 
	    		if (td[j]) {
	    		
	    	
	      			if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
	      			
	      				flag++;
	      			
	      				$("#noProspects").hide();
	    	
	        			tr[i].style.display = "";
	        			
	        			break;
	        
	      			} else {
	    	  
	        			tr[i].style.display = "none";
	        
	       			}
	      		
	      		}
	    		
	    		if(j==0){
	    			
	    			j++;
	    		} else{
	    			
	    			j=j+2;
	    		}
	  	  	 }
	    
	      }
	  	
	  	  if(flag==0){
	  		  
	  		  $("#table").hide();
	  		  
	  		  $("#noProspects").show();
	  		  
	  	  }
	  	
		}
	
			   
		</script>
	</body>

	
</html>