<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>DashBoard</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
  			<%@include file="resources/css/style-dashboard.css" %>
  			.column {
			    float: left;
			    width: 33.33%;
			    padding: 10px;
			}
			.row:after {
			    content: "";
			    display: table;
			    clear: both;
			}
			/* Responsive layout - makes the two columns stack on top of each other instead of next to each other */
			@media screen and (max-width: 600px) {
			    .column {
			        width: 100%;
			    }
			}
		</style>
		<script>
			window.onload = function () {
			
			var chart1 = new CanvasJS.Chart("Prospect", {
				animationEnabled: true,
				theme: "light2", // "light1", "light2", "dark1", "dark2"
				title:{
					text: "Prospect"
				},
				axisY: {
					title: "Count"
				},
				data: [{        
					type: "column",  
					showInLegend: true, 
					legendMarkerColor: "grey",
					legendText: "Status",
					dataPoints: [      
						{ y: ${prospectTotalCount}, label: "Total" },
						{ y: ${prospectAcceptCount},  label: "Accepted" },
						{ y: ${prospectRejectCount},  label: "Rejected" },
						{ y: ${prospectPendingCount},  label: "Pending" }
					]
				}]
			});
			chart1.render();
			
			var chart2 = new CanvasJS.Chart("Proposal", {
				animationEnabled: true,
				theme: "light2", // "light1", "light2", "dark1", "dark2"
				title:{
					text: "Proposal"
				},
				axisY: {
					title: "Count"
				},
				data: [{        
					type: "column",  
					showInLegend: true, 
					legendMarkerColor: "grey",
					legendText: "Status",
					dataPoints: [      
						{ y: ${proposalTotalCount}, label: "Total" },
						{ y: ${proposalAcceptCount},  label: "Accepted" }
					]
				}]
			});
			chart2.render();
			
			var chart3 = new CanvasJS.Chart("Agreement", {
				animationEnabled: true,
				theme: "light2", // "light1", "light2", "dark1", "dark2"
				title:{
					text: "Agreement"
				},
				axisY: {
					title: "Count"
				},
				data: [{        
					type: "column",  
					showInLegend: true, 
					legendMarkerColor: "grey",
					legendText: "Status",
					dataPoints: [      
						{ y: ${agreementTotalCount}, label: "Total" },
						{ y: ${agreementConfirmCount},  label: "Confirmed" }
					]
				}]
			});
			chart3.render();
			
			}
		</script>
	</head>
	<body>
	
		<script>
		$(document).ready(function() {
			$("#Prospect").click(function() {
				var form = document.createElement("form");
				form.method = "post";
				form.action = "generateReport.do";
				var input = document.createElement("input");
				input.setAttribute("type", "hidden");
				input.setAttribute("name", "reportType");
				input.setAttribute("value", "prospect");
				form.appendChild(input);
				form.style.visiblity='hidden'; 
				document.body.appendChild(form);
				form.submit();
			});
			
			$("#Proposal").click(function() {
				var form = document.createElement("form");
				form.method = "post";
				form.action = "generateReport.do";
				var input = document.createElement("input");
				input.setAttribute("type", "hidden");
				input.setAttribute("name", "reportType");
				input.setAttribute("value", "proposal");
				form.appendChild(input);
				form.style.visiblity='hidden'; 
				document.body.appendChild(form);
				form.submit();
			});
			
			$("#Agreement").click(function() {
				var form = document.createElement("form");
				form.method = "post";
				form.action = "generateReport.do";
				var input = document.createElement("input");
				input.setAttribute("type", "hidden");
				input.setAttribute("name", "reportType");
				input.setAttribute("value", "agreement");
				form.appendChild(input);
				form.style.visiblity='hidden'; 
				document.body.appendChild(form);
				form.submit();
			});
		});	
		</script>
	
		<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
		<ul class="sidenav">
			<li><a class="active" href="adminHome.do">DashBoard</a></li>
			<li><a href="listProspect.do">Prospect</a></li>
			<li><a href="listProposal.do">Proposal</a></li>
			<li><a href="listAgreement.do">Agreement</a></li>
			<li><a href="listProject.do">Project</a></li>
			<li><a href="listMilestone.do">Payment</a></li>
			<li><a href="listEmployee.do">Employee</a></li>	
			<li><a href="logout">Logout</a></li>		
		</ul>
		<div class="content">
  			<h1 style="text-align: center; font-weight: bold; font-size: 30px; letter-spacing: 2px; margin-top: 30px; margin-bottom: 20px;">DASHBOARD</h1>
  			<div class="row">
			  <div class="column" style="background-color:#fff;">
			    <div id="Prospect" style="height: 250px;"></div>
			  </div>
			  <div class="column" style="background-color:#fff;">
			    <div id="Project" style="height: 250px;">
			    	<h1 class="header-dash">Project</h1>
			    	<table class="table table-hover">
			    		<tr>
			    			<th>Total Projects</th>
			    			<td>${projectTotalCount}</td>
			    		</tr>
			    		<tr>
			    			<th>Project Not yet started</th>
			    			<td>${projectNotStartedCount}</td>
			    		</tr>
			    		<tr>
			    			<th>Project In Progress</th>
			    			<td>${projectInProgressCount}</td>
			    		</tr>
			    		<tr>
			    			<th>Project Testing</th>
			    			<td>${projectTestingCount}</td>
			    		</tr>
			    		<tr>
			    			<th>Project Deployed</th>
			    			<td>${projectDeployedCount}</td>
			    		</tr>
			    	</table>
			    </div>
			  </div>
			  <div class="column" style="background-color:#fff;">
			    <div id="Proposal" style="height: 250px;"></div>
			  </div>
			</div>
			<div class="row">
			  <div class="column" style="background-color:#fff;">
			    <div id="Payment" style="height: 250px;">
			    	<h1 class="header-dash">Payment</h1>
			    	<table class="table table-hover">
			    		<tr>
			    			<th>Total Payments</th>
			    			<td>${paymentTotalCount}</td>
			    		</tr>
			    		<tr>
			    			<th>Paid</th>
			    			<td>${paidCount}</td>
			    		</tr>
			    		<tr>
			    			<th>Not Paid</th>
			    			<td>${notPaidCount}</td>
			    		</tr>
			    	</table>
			    </div>
			  </div>
			  <div class="column" style="background-color:#fff;">
			    <div id="Agreement" style="height: 250px;"></div>
			  </div>
			  <div class="column" style="background-color:#fff;">
			    <div id="Employees" style="height: 250px;">
			    	<h1 class="header-dash">Employees</h1>
			    	<table class="table table-hover">
			    		<tr>
			    			<th>Total Employees</th>
			    			<td>${employeeTotalCount}</td>
			    		</tr>
			    		<tr>
			    			<th>Senior Officers</th>
			    			<td>${seniorOfficersCount}</td>
			    		</tr>
			    		<tr>
			    			<th>Sales</th>
			    			<td>${salesCount}</td>
			    		</tr>
			    		<tr>
			    			<th>Managers</th>
			    			<td>${managersCount}</td>
			    		</tr>
			    	</table>
			    </div>
			  </div>
			</div>
		</div>
	</body>
</html>