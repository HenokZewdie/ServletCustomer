

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateCustomer
 */
@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String nextURL = "/Display.jsp";
			String message = "" ;
			Class.forName("com.mysql.jdbc.Driver"); 
			String Address = request.getParameter("Address");
			String ZIP = request.getParameter("ZIP");
			String City = request.getParameter("City");
			String State = request.getParameter("State");
			HttpSession session = request.getSession();
			String fullName = session.getAttribute("name").toString();
			//System.out.println(fullName);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root","password");
			String query = ("UPDATE CustInfo SET StreetAddress  = ?,ZipCode  = ?,"
					+ " City  = ?, State  = ?  WHERE FullName = ? ");
			PreparedStatement  preparedStmt= null;
			
			preparedStmt= con.prepareStatement(query); 
			preparedStmt.setString(1, Address); 
			preparedStmt.setString(2, ZIP); 
			preparedStmt.setString(3, City); 
			preparedStmt.setString(4, State); 
			preparedStmt.setString(5, fullName);
			preparedStmt.executeUpdate();
			
			String Searchquery = ("SELECT * FROM CustInfo WHERE FullName = '"+fullName+"'"); 
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(Searchquery);
			while(rs.next()){
				  // from the current pointer till the end of the table
				message+=(rs.getString(2)+"\t"+rs.getString(1) + "\n"	
							+rs.getString(5) + "\t" + rs.getString(6) +"\n" 
							+ rs.getString(7) +rs.getInt(8) + "\n"
							+ rs.getString(9) + "\n"
							+ rs.getString(10) + "  "+ rs.getString(11) +"\n"); } 	
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		}catch (Exception e) {
			// TODO: handle exception
		}	
	}
}