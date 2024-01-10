package Stock;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Loginpage")
public class Loginpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Loginpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		try {
		String n = req.getParameter("user name");
		String p = req.getParameter("password");
		
		if(p.equals("0000") && n.equals("Avdhesh")) {
			RequestDispatcher rd = req.getRequestDispatcher("Options.html");
			rd.forward(req, res);
		}
		else {
			pw.print("Password or username incorrect!!!");		}
		}
		catch(Exception e) {
		    // ... handle errors ...
		} finally {
		    // ... cleanup that will execute whether or not an error occurred ...
		}
	}

}
