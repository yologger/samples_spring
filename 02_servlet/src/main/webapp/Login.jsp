<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
</head>
<body>
<form action="LoginController" method="post">
	name: <input type="text" name="name" size="10"/><br />
	id: <input type="text" name="id" size="10"/><br />
	password: <input type="password" name="password" size="10"/><br />
	hobby: <input type="checkbox" name="hobby" value="read"/>read
	<input type="checkbox" name="hobby" value="cook"/>cook
	<input type="checkbox" name="hobby" value="swim"/>swim
	<input type="checkbox" name="hobby" value="sleep"/>sleep<br />
	
	major: <input type="radio" name="major" value="programming">Programming
	<input type="radio" name="major" value="design">Design
	<input type="radio" name="major" value="soccer">Soccer
	<br />
	
	<select name="nation">
		<option value="korea">Korea</option>
		<option value="usa">USA</option>
		<option value="england">England</option>
	</select><br />
	
	<input type="submit" value="Submit"/>
	<input type="reset" value="Reset"/>
	
</form>
</body>
</html>