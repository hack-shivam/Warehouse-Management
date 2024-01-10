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
@WebServlet("/Insert")
public class Insertdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//res.getWriter().append("Served at: ").append(req.getContextPath());
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		int Product_Id=Integer.parseInt(req.getParameter("id"));
		String Item= req.getParameter("item");
		String Supplier= req.getParameter("sup");
		int Quantity=Integer.parseInt(req.getParameter("qty"));
		String Remark= req.getParameter("rem");
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			pw.println("");
			pw.println("");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/ankit","root","0000");
			pw.println("");
			
			
			pstm=conn.prepareStatement("insert into warehouse values(?,?,?,?,?)");
			pstm.setInt(1, Product_Id);
			pstm.setString(2, Item);
			pstm.setString(3, Supplier);
			pstm.setInt(4, Quantity);
			pstm.setString(5,Remark);
			
			pstm.executeUpdate();
			//pw.println("Record Inserted!");
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
