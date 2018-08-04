<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Error</title>
		<style type="text/css">
			body{
				font-family: sans-serif;
			}
			p{
				color: red;
				font-size: 20px;
				text-align: center;
				margin-top: 80px;
			}
			h1{
				font-size: 48px;
				font-weight: 900;
				letter-spacing: 2px;
				color: red;
				text-align: center;
				margin-top: 80px;
				
			}
		</style>
	</head>
	<body>
		<h1>Error Found</h1>
		<p>${ERROR_MSG}</p>
	</body>	
</html>