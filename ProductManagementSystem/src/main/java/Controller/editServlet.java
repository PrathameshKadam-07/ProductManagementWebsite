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

public class editServlet extends HttpServlet {

    public editServlet() {
        super();
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("productid"));
		String pname = request.getParameter("productname");
		int price = Integer.parseInt(request.getParameter("price")) ;
		int qty = Integer.parseInt(request.getParameter("quantity"));
		
		ProductBean pb = new ProductBean(pid,pname,price,qty);
		productDoa pd = new productDoa();
		RequestDispatcher rd = request.getRequestDispatcher("./editProduct.html");
		try {
			int n =pd.editProduct(pb);
			if(n>0) {
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
