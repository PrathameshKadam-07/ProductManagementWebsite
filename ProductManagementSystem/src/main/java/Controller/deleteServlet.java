package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ProductBean;
import Model.productDoa;

public class deleteServlet extends HttpServlet {
    public deleteServlet() {
        super();
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("productid"));
		String pname = request.getParameter("productname");
		int qty = Integer.parseInt(request.getParameter("quantity"));
		
	ProductBean pb = new ProductBean(pid,pname,qty);
	productDoa pd = new productDoa();
	RequestDispatcher rd1 = request.getRequestDispatcher("./deleteProduct.html");
	RequestDispatcher rd2 = request.getRequestDispatcher("./invalid.jsp");
	
	try {
		int n = pd.deleteProduct(pb);
		if(n>0) {
			rd1.forward(request, response);
		}
		else if(n==0) {
			request.setAttribute("qty", qty);
			rd2.forward(request, response);
		}
		else {
			rd1.forward(request, response);
		}
		
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
