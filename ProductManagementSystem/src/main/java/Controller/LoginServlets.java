package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Authenticator.RequestorType;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.LoginBean;
import Model.LoginDoa;

public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServlets() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		
		LoginBean lg = new LoginBean(uname,pass);
		LoginDoa ld = new LoginDoa();
		RequestDispatcher rd1 = request.getRequestDispatcher("./login.jsp");
		PrintWriter out = response.getWriter();
		
		try {
			String n = ld.Athentication(lg);
			if(n.equals("success")) {
				response.sendRedirect("./home.jsp");
			}
			else
			{
				request.setAttribute("msg", "Invalid Password or Username");
				rd1.forward(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
