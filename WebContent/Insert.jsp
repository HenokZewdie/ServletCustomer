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
<h4>${name} is not in the database</h4>
<table> 
 <TR>
      <TD>Title</TD>
      <TD><input type = "text" name = "Title"></TD>
  </TR>
 <TR>
      <TD>First Name</TD>
      <TD><input type = "text" name = "FName" ></TD>
  </TR>
 <TR>
      <TD>Last Name</TD>
      <TD><input type = "text" name = "LName" ></TD>
  </TR>
 <TR>
      <TD>Street</TD>
      <TD><input type = "text" name = "Street" ></TD>
  </TR>
 <TR>
      <TD>ZIP Code</TD>
      <TD><input type = "text" name = "ZIP" ></TD>
  </TR>
 <TR>
      <TD>City</TD>
      <TD><input type = "text" name = "City" ></TD>
  </TR>
 <TR>
      <TD>State</TD>
      <TD><input type = "text" name = "State" ></TD>
  </TR>

 <TR>
      <TD>Email</TD>
      <TD><input type = "text" name = "Email" ></TD>
  </TR>
 <TR>
      <TD>Duty</TD>
      <TD><input type = "text" name = "Duty" ></TD>
  </TR>
 <TR>
      <TD>Company</TD>
      <TD><input type = "text" name = "Company" ></TD>
  </TR>

</table>


<br><input type = "submit" value = "Register Customer">
</form>
</body>
</html>