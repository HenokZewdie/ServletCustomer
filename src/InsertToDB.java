

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Catch;

/**
 * Servlet implementation class InsertToDB
 */
@WebServlet("/InsertToDB")
public class InsertToDB extends HttpServlet {
	PreparedStatement preparedStmt = null;
	
	private static final long serialVersionUID = 1L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root","password");
				
			String Title = request.getParameter("Title");
			String FName = request.getParameter("FName");
			String LName = request.getParameter("LName");
			String Street = request.getParameter("Street");
			int ZIP = Integer.parseInt(request.getParameter("ZIP"));
			String City = request.getParameter("City");
			String State = request.getParameter("State");
			String Email = request.getParameter("Email");
			String Duty = request.getParameter("Duty");
			String Company = request.getParameter("Company");
			
			String FullName = FName.concat(" ").concat(LName);	
					
			
			String query = ("INSERT into `Customer`.`CustInfo`(`FullName`, `Title`,`FirstName`, `LastName`, `StreetAddress`, `City`, `State`, `ZipCode`, `EmailAddress`, `Position`, `Company`) "
					+ "VALUES (?,?,?,?,?, ?, ?,?,?,?,?)");
			 preparedStmt = con.prepareStatement(query);


			preparedStmt.setString(1, FullName);
			preparedStmt.setString(2, Title);
			preparedStmt.setString(3, FName);
			preparedStmt.setString(4, LName);
			preparedStmt.setString(5, Street);
			preparedStmt.setString(6, City);
			preparedStmt.setString(7, State);
			preparedStmt.setInt(8, ZIP);
			preparedStmt.setString(9, Email);
			preparedStmt.setString(10, Duty);
			preparedStmt.setString(11, Company);
			preparedStmt.executeUpdate();
		
	}catch (Exception e) {
		// TODO: handle exception
	}
	
	
	} 


}	



