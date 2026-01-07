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

public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public searchServlet() {
        super();
  }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("productid")) ;
		String pname = request.getParameter("productname");
		ProductBean pb = new ProductBean();
		pb.setPid(pid);
		pb.setPname(pname);
		
 		productDoa pd = new productDoa();
 		RequestDispatcher rd = request.getRequestDispatcher("./invalidSearch.jsp");
 		try {
			String n = pd.searchProduct(pb);
			
			request.setAttribute("n", n);
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
