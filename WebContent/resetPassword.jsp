<%@ page import="com.bms.web.action.ResetPasswordAction" %>
<%@ page import="com.bms.web.action.CheckTokenAction" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Reset Password</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
  			<%@include file="resources/css/style-dashboard.css" %>
  			<%@include file="resources/css/style-main.css" %>
		</style>
	</head>
	<body>

	<%
		String username = request.getParameter("username");
	
		System.out.println("in resetpassword.jsp : username : " + username);
		
		session.setAttribute("token", request.getParameter("token"));
		
		ResetPasswordAction reset = new ResetPasswordAction();
		
		CheckTokenAction checkTokenAction = new CheckTokenAction();
		
		System.out.println("*********************");
		
		try{
		
		if(!(checkTokenAction.checkToken(request, response))){
			
			response.sendRedirect("error.jsp");
		}
		else{
			
			System.out.println("in resetpassword.jsp : token match : ");
			
		}
		}catch(Exception e){
			
			response.sendRedirect("error.jsp");
		}
		
		
		
	%>
	<script type="text/javascript">
		function confirm(){
			
			var newpass = document.getElementById("newpass").value;
			
			var confirmpass = document.getElementById("confirmpass").value;
			
		//	var flag = 0;
			
			if(newpass != confirmpass){
				
				alert('Passwords not matching');
			  	
			}else{
				
				//flag = 1;
			}
			
		
		}
	</script>
	<div class="content-reset">
		<form name="passwordresetform" class="form-css" action="passwordUpdate.jsp" method="post" >
			<div class="header-form form-group row">
				<h3 class="header-signin" >Reset password</h3>
		    </div>
		    <div class="form-group">
		    	<label>UserName : <%=username %></label>
		    	<input type="hidden" id="username" class="form-control" name="username" value="<%=username %>">
		    </div>
		    <div class="form-group">
		    	<label>New Password : </label>
		    	<input type="password" name="password" class="form-control" id="newpass" placeholder="Password">		    
		    </div>
		    <div class="form-group">
		    	<label>Confirm Password : </label>
		    	<input type="password" name="confirmpassword" class="form-control" id="confirmpass" placeholder="Confirm Password" onblur="confirm()">
		    </div>
		    <div class="form-group">
		    	<input type="submit" class="btn btn-primary active" name="submit" value="Submit" >
		    </div>
		</form>
		</div>
	</body>
</html>