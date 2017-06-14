

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/SearchCustomer")
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("custName");
		String id =request.getParameter("custID");
		String Searchquery = "";

		HttpSession session = request.getSession();
		//User uer = new User();
		session.setAttribute("name", name);

		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root","password"); 
			if(id != null && !id.equals("")){
				int intId = Integer.parseInt(id);			
				Searchquery = ("SELECT * FROM CustInfo WHERE ID = "+intId); 
			}
			else{				
				Searchquery = ("SELECT * FROM CustInfo WHERE FullName = '"+name+"'"); 
			}
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(Searchquery);  //cursor pointer to the row of the table

			//executeQuery: to execute the select query
			String nextURL = "/Display.jsp";
			String message = "" ;

			if(!rs.isBeforeFirst()){	
				nextURL = "/Insert.jsp";
				session.setAttribute("message", message);

			}
			int counter = 0;
			String message1 = "";
			PrintWriter out = response.getWriter();
			while(rs.next()){
				counter++;
				//out.println();
				//System.out.println(total);
				// from the current pointer till the end of the table
				message+=(rs.getString(2)+"\t"+rs.getString(1) + "<br>"	
						+rs.getString(5) + "\t" + rs.getString(6) +"<br>" 
						+ rs.getString(7) +rs.getString(8) + "<br>"
						+ rs.getString(9) + "<br>"
						+ rs.getString(10) + "  "+ rs.getString(11) + "<br> ID: " + rs.getString(12)+"<br><br>"); } 

			if(counter >1){
				
				nextURL = "/ChooseID.jsp";
				//request.setAttribute("message", message);
			}
			//out.println(message);
			//out.print(id);
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  // to provide methods to execute different SQL queries


	}

}
