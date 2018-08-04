<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
		Subject currentUser = SecurityUtils.getSubject();
		
		if( null != currentUser.getPrincipal()){
			
				request.getRequestDispatcher("loginAction.do").forward(request, response);
				
				/* response.sendRedirect("home.do"); */
			
		}

	
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>		
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
  			<%@include file="resources/css/style.css" %>
		</style>
	</head>
	
	<body class="bg-img">
		<script type="text/javascript">
		
			
		</script> 
	
	
		<div class="form-css">
		<form name="loginform" action="" method="post" >
			<div class="header-form row header-img" >
				<h3 class="header-signin">SIGN IN</h3>
			</div>
			<div class="form-group input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<input type="text" autofocus="autofocus" name="username" autoTab="true" type="focus" placeholder="Username" onblur="getUserID()">
			</div>
    		<div class="form-group input-group">
    			<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    			<input type="password" name="password" placeholder="Password">
    		</div>
        	<div class="row form-group">
        		<div class="align-left col-sm-6">
        			<input type="checkbox" id="remember" name="rememberMe"> <label for="remember" class="check-remember"> Remember Me</label>
        		</div>
        		<!-- <div class="align-right col-sm-6" >
        			<a href="" id="forgot" class="forgot" onclick="askConfirmation()">Forgot Password?</a>
        		</div> -->
        		<p id="error" class="align-center form-group" style="color:red;">${errormessage}</p>
        	</div>
	        <div class="align-center form-group">
	        	<input type="submit" name="submit" value="Login" class="btn btn-primary active btn-login">
	        </div>
		</form>
		
		</div>	
		
	</body>
</html>