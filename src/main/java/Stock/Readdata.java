package Stock;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class readdata
 */
@WebServlet("/Readdata")
public class Readdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Readdata() {
        super();
        // TODO Auto-generated construct++or stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//res.getWriter().append("").append(req.getContextPath());
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		int Product_Id=0;
		String Item= null;
		String Supplier= null;
		int Quantity=0;
		String Remark= null;
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			pw.println("");
			pw.println("");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/ankit","root","0000");
			pw.println("");
			pstm = conn.prepareStatement("select * from warehouse ORDER BY Product_ID");
			rs = pstm.executeQuery();
			pw.println("<h2>\n"+"Displaying records:\n"+"</h2>\n"+"<table border=2>\n"+"<tr>\n"+"<th>\n"+"Product Id\n"+"</th>\n"+"<th>\n"+"Item\n"+"</th>\n"+"<th>\n"+"Supplier\n"+"</th>\n"+"<th>\n"+"Quantity\n"+"</th>\n"+"<th>\n"+"Remark\n"+"</th>\n"+"</tr>");
			while(rs.next()) {
				Product_Id=rs.getInt(1);
				Item=rs.getString(2);
				Supplier=rs.getString(3);
				Quantity=rs.getInt(4);
				Remark=rs.getString(5);
				pw.println("<tr>\n"+"<td>\n"+Product_Id+"\n</td>\n"+"<td>\n"+Item+"\n</td>\n"+"<td>\n"+Supplier+"\n</td>\n"+"<td>\n"+Quantity+"\n</td>\n"+"<td>\n"+Remark+"\n</td>\n"+"</tr>");
				}
			}catch(Exception e) {}
			
	}

	

}
