

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String FullName = request.getParameter("delete");
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root","password"); 
			PreparedStatement preparedStmt = null;
			String Deletequery = (" Delete FROM CustInfo WHERE FirstName = ?");
			preparedStmt= con.prepareStatement(Deletequery); 
			preparedStmt.setString(1, FullName);
			preparedStmt.executeUpdate();
			PrintWriter out = response.getWriter();

			out.println(FullName + "  is now Deleted");
			
			String nextURL = "/Display.jsp";
			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
