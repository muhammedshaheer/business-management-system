<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.springframework.transaction.annotation.Propagation"%>
<%@page import="java.util.List"%>
<%@page import="com.bms.domain.Proposal"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 

	List<Proposal> proposalList = (List<Proposal>) request.getAttribute("proposalList");

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List of Proposals</title>
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
					form.action = "viewProposal.do";	
					var input = document.createElement("input");					
					input.setAttribute("type", "hidden");	
					input.setAttribute("name", "proposalID");	
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
  				<a style="float: right;" href="logout">Logout</a>
			</div>
			<div class="main">
			<% if(null !=proposalList){%>
				<h1 class="header-list">Proposal List</h1>
				
				
				<div class="search-container">
					<div class="search-input">
			      		<i class="fa fa-search"></i><input type="text" id ="searchInput" onkeyup="search()" autofocus="autofocus" autoTab="true" type="focus" placeholder="Search for Proposals" />
	    			</div>
    			</div>
				<div>
					<p id="noProposal" class="err" style="display:none;">No Proposals Found</p>
				</div>
				
					<table class="table table-style table-hover" style="margin-top: 20px;" id="table">
						<tr>
							<!-- <th>Proposal ID</th> -->
							<th>Proposal Name</th>
							<th>Late Modified</th>
							<th>Download Link</th>
						</tr>
						<%for(Proposal proposal:proposalList){ %>
							<tr data-toggle="tooltip" data-placement="left" title='<%= proposal.getDescription()%>'>
								<%-- <td><%=proposal.getProposalID() %></td> --%>
								<td id=<%=proposal.getProposalID()%> class="view hover-cell"><%=proposal.getProposalName()%></td>
								<td id='<%=proposal.getProposalID()%>' class="view"><%=formatter.format(proposal.getDateOfModification())%></td>
								<td class="align-center" style="vertical-align: middle;font-size: 24px;"><a id=<%=proposal.getLinkToFile() %> class="download"><i class="fa fa-download" id=<%=proposal.getLinkToFile() %> ></i></a></td>
							</tr>	
						<%}%>
					</table>
				<%} else{ %>
				
						<h1 class="header-list">No Proposals Added</h1>
						
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
			      			
			      			$("#noProposal").hide();
			    	
			        		tr[i].style.display = "";
			        
			      		} else {
			    	  
			        		tr[i].style.display = "none";
			        
			       		}
			      		
			      	}
			    
			    }
			  	
			  	if(flag==0){
			  		
			  		$("#table").hide();
			  		
			  		$("#noProposal").show();
			  		
			  	}else{
			  		
			  		
			  	}
			  	
			}
			   
		</script>	
	</body>
</html>