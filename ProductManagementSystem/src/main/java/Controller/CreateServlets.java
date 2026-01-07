package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.LoginBean;
import Model.LoginDoa;

public class CreateServlets extends HttpServlet {
 
    public CreateServlets() {
        super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		
		LoginBean lb = new LoginBean(uname,pass);
		LoginDoa ld = new LoginDoa();
		
		try {
			int n = ld.createUser(lb);
			if(n>0) {
				response.sendRedirect("./login.jsp");
				}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
