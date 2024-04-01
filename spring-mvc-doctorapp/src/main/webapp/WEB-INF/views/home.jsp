<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Doctor</title>
<style>
div {
	display: flex;
	text-align: right;
}
</style>
</head>
<body>
	<div>
		<a href="admin">Admin</a> <br>
	</div>
	<h3>Search doctor by speciality</h3>
	<form action="search">
		Search by speciality<input type="text" name="speciality" placeholder="speciality">
		<br> <hr>
		<input type="submit" value="search">
	</form>
	
	<h2>All Doctors</h2>
	${doctors }
	<h2 style = "{color:red}"> ${message }</h2> <br>
</body>
</html>
