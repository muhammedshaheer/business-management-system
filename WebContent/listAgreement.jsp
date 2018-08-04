<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.ArrayList,java.util.List,com.bms.domain.Agreement,com.bms.domain.Prospect,com.bms.service.ProspectService,com.bms.service.ProspectServiceImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List Agreement</title>
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
	
				$(".view").click(function() {
	
					var form = document.createElement("form");
	
					form.method = "post";
	
					form.action = "viewAgreement.do";
	
					var input = document.createElement("input");
					
					input.setAttribute("type", "hidden")
	
					input.setAttribute("name", "agreementId");
	
					input.setAttribute("value", event.target.id);
	
					form.appendChild(input);
	
					form.style.visiblity='hidden'; 
					
					document.body.appendChild(form);
	
					form.submit();
	
				});
				
				$(".confirm").click(function() {
					
					if(confirm("Once confirmed you cant edit the agreement!! Do you want to confirm ?"))
					{	
					var form = document.createElement("form");
	
					form.method = "post";
	
					form.action = "confirmAgreement.do";
	
					var input = document.createElement("input");
					
					input.setAttribute("type", "hidden")
	
					input.setAttribute("name", "agreementId");
	
					input.setAttribute("value", event.target.id);
	
					form.appendChild(input);
	
					form.style.visiblity='hidden'; 
					
					document.body.appendChild(form);
	
					form.submit();}
	
				});
			});
		</script>
		<ul class="sidenav">
			<li><a href="adminHome.do">DashBoard</a></li>
			<li><a href="listProspect.do">Prospect</a></li>
			<li><a href="listProposal.do">Proposal</a></li>
			<li><a class="active" href="listAgreement.do">Agreement</a></li>
			<li><a href="listProject.do">Project</a></li>
			<li><a href="listMilestone.do">Payment</a></li>
			<li><a href="listEmployee.do">Employee</a></li>	
		</ul>
		<div class="content">
			<div class="navbar" >
  				<a href="toAddAgreementPage.do">Add Agreement</a>
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
				<div>${message}</div>
				<% 
				  List<Agreement> agreements = (List<Agreement>)request.getAttribute("agreementlist");
				  List<Prospect> prospects = (List<Prospect>)request.getAttribute("prospectlist");
				%>
				
				<%if(null== agreements){ %>
				<h1>No added agreements</h1>
				<%} else if(null == prospects){ %>
				<h1>No accepted prospects</h1>
				<% } else { %>
				<h1 class="header-list">Agreement List</h1>
				
				
				
				<div class="search-container">
					<div class="search-input">
			      		<i class="fa fa-search"></i><input type="text" id ="searchInput" onkeyup="search()" autofocus="autofocus" autoTab="true" type="focus" placeholder="Search for Agreements" />
	    			</div>
    			</div>
    			<div>
    				<p id="noAgreement" class="err" style="display:none;">No agreements found</p>
    			</div>
    			
				<table class="table table-style" id="table" style="margin-top: 20px;">
					<tr>
						<th>Prospect Name</th>
						<th>Confirm Agreement</th>
					</tr>
					<%for(Agreement agreement: agreements) 
					{%>
					<tr>
					    <td id=<%=agreement.getAgreementId()%> class="view hover-cell">
					    
						<% 	for(Prospect prospect : prospects)
							{   
								if(agreement.getProspectId().equals(prospect.getProspectID()))
								{ %>
								<a id=<%=agreement.getAgreementId()%> class="view"><%=prospect.getProspectName() %></a>
								<%}
							
							}%>
						</td>
						
						<%if(!agreement.isConfirm()) {%>
						<td>
							<%-- <button type="submit" id=<%=agreement.getAgreementId()%> class="btn confirm"><i class="fa fa-check" style="font-size: 18px;"></i> Confirm</button> --%>
							<a id=<%=agreement.getAgreementId()%> class="confirm"><i class="fa fa-check" style="font-size: 16px;"></i> Confirm</a>
						</td>
					<%} else {%> 
					<td>Confirmed</td>
					<%} %>
					</tr>
					<%}%>
				</table>
				<%} %>
			</div>
		</div>
		<script type="text/javascript">
		
			function search() {
			
				var input, filter, table, tr, td, i, flag=0;
			  
			 	input = document.getElementById("searchInput");
			  
			  	filter = input.value.toUpperCase().trim();
			  
			  	table = document.getElementById("table");
			  	
			 	$("table").show();
			  		
			  	tr = table.getElementsByTagName("tr");
			  
			  	for (i = 0; i < tr.length; i++) {
			   	
			   	 	td = tr[i].getElementsByTagName("td")[0];
			   	 
			    	if (td) {
			    		
			    	
			      		if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			      			
			      			flag++;
			      			
			      			$("#noAgreement").hide();
			    	
			        		tr[i].style.display = "";
			        
			      		} else {
			    	  
			        		tr[i].style.display = "none";
			        
			       		}
			      		
			      	}
			    
			    }
			  	
			  	if(flag==0){
			  		
			  		$("#table").hide();
			  		
			  		$("#noAgreement").show();
			  		
			  	}else{
			  		
			  		
			  	}
			  	
			}
			   
		</script>	
			
	</body>
</html>