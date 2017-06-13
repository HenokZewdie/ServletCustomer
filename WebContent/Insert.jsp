<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="InsertToDB" method = "post">
Title<input type = "text" name = "Title"">
<br>First Name<input type = "text" name = "FName" >
<br>Last Name<input type = "text" name = "LName">
<br>Street<input type = "text" name = "Street">
<br>ZIP Code<input type = "text" name = "ZIP" >
<br>City<input type = "text" name = "City">
<br>State<input type = "text" name = "State">
<br>Email<input type = "text" name = "Email" >
<br>Duty<input type = "text" name = "Duty">
<br>Company<input type = "text" name = "Company">

<br><input type = "submit" value = "Register Customer">
</form>
</body>
</html>