package Stock;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Update")
public class Updatedata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		res.getWriter().append("").append(req.getContextPath());
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		int Product_Id=Integer.parseInt(req.getParameter("id"));
		//String Item= req.getParameter("item");
		//String Supplier= req.getParameter("sup");
		int Quantity=Integer.parseInt(req.getParameter("qty"));
		//String Remark= req.getParameter("rem");
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			pw.println("");
			pw.println("");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/ankit","root","0000");
			pw.println("");
			
			
			pstm=conn.prepareStatement("Update warehouse set Quantity=? where Product_Id=?");
			pstm.setInt(1, Quantity);
			//pstm.setString(2,Remark);
			pstm.setInt(2,Product_Id);
			
			int i=pstm.executeUpdate();
			//pw.println("Record Updated!");
			RequestDispatcher rd = req.getRequestDispatcher("Options.html");
			rd.forward(req, res);
		}
		catch(Exception e) {
		    // ... handle errors ...
		} finally {
		    // ... cleanup that will execute whether or not an error occurred ...
		}
	}
	
}