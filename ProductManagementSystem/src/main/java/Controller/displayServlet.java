package Controller;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ProductBean;
import Model.productDoa;

public class displayServlet extends HttpServlet {

    public displayServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		productDoa pd = new productDoa();
		RequestDispatcher rd = request.getRequestDispatcher("./displayAll.jsp");
		try {
			List<ProductBean> list = pd.displayProduct();
			request.setAttribute("productList", list);
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
