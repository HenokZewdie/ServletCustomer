<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<h2>${name}</h2>
<form action="UpdateCustomer" method = "post">
Address<input type = "text" name = "Address"">
<br>ZIP Code<input type = "text" name = "ZIP" >
<br>City<input type = "text" name = "City">
<br>State<input type = "text" name = "State">
<br><input type = "submit" value = "Update Customer">

</form>
</body>
</html>