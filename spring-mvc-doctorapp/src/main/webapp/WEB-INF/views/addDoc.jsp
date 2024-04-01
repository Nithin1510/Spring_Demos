<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h2>Add Doctor Details</h2>
	<form action="addDoctor">
		Enter Doctor name <input type="text" name="doctorName"> <br>
		Enter your Speciality 
		<select name="speciality">
		<option value="select">--select--</option>
		<option value="ORTHO">ORTHOPEDIATRICIAN</option>
		<option value="PAEDIA">PAEDIATRICIAN</option>
		<option value="PHYSICIAN">GENERAL PHYSICIAN</option>
		<option value="GYNAEC">GYNAECOLOGIST</option>
		<option value="NEURO">NEUROLOGY</option>
		<option value="DERMA">DERMATOLOGIST</option>
		</select> <br>
		Enter your experience <input type="text" name="experience"> <br> 
		Enter your rating <input type="text" name = "ratings"> <br>
		Enter your consultation fees <input type="text" name="fees"> <br>
		<input type="submit" value="submit">
	</form>
</body>
</html>