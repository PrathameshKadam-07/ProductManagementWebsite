package Model;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.ProductBean;
import Service.DBconnection;

public class productDoa {
public int addProduct(ProductBean pb) throws ClassNotFoundException, SQLException {
	Connection con = DBconnection.getConnection();
	
	PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?,?)");
	ps.setInt(1, pb.getPid());
	ps.setString(2, pb.getPname());
	ps.setInt(3, pb.getPrice());
	ps.setInt(4, pb.getQty());
	
	int rs =ps.executeUpdate();
	
	return rs;	
}

// Delete Product
public int deleteProduct(ProductBean pb) throws ClassNotFoundException, SQLException {
	Connection con = DBconnection.getConnection();
	int q = 0;
	
	PreparedStatement ps = con.prepareStatement("select * from product where pid = ?");
	ps.setInt(1, pb.getPid());
	ResultSet rs = ps.executeQuery();
	
	if(rs.next()) {
		q = rs.getInt(4);
		
		if(pb.getQty()>q) {
			return 0;
		}
		else if(pb.getQty() == q) {
			PreparedStatement ps1 = con.prepareStatement("delete from product where pid =?");
			ps1.setInt(1, pb.getPid());
			int rs1 = ps1.executeUpdate();
			return rs1;
		}
		else {
			q = q-pb.getQty();
			PreparedStatement ps2 = con.prepareStatement("update product set qty = ? where pid =?");
			ps2.setInt(1, q);
			ps2.setInt(2, pb.getPid());
			int rs2 = ps2.executeUpdate();
			return rs2;
		}
	}
	return -1;
}

//Edit Poduct
public int editProduct(ProductBean pb) throws ClassNotFoundException, SQLException {
	Connection con = DBconnection.getConnection();
	
	PreparedStatement ps = con.prepareStatement("update product set price =?,qty=? where pid =?");
	ps.setInt(1, pb.getPrice());
	ps.setInt(2, pb.getQty());
	ps.setInt(3, pb.getPid());
	
	int rs =ps.executeUpdate();
	
	return rs;	
}

//Search Product
public String searchProduct(ProductBean pb) throws ClassNotFoundException, SQLException {
	Connection con = DBconnection.getConnection();
	
	PreparedStatement ps = con.prepareStatement("select * from product where pid=?");
	ps.setInt(1, pb.getPid());
	ResultSet rs = ps.executeQuery();
	if(rs.next()) {
		 return "ProductID: "+rs.getInt(1)+" Product Name: "+rs.getString(2)+" Product Price"+rs.getString(3)+" Quantity"+rs.getString(4);
	}
	else {
		return null;
	}
}

//Display
public List<ProductBean> displayProduct() throws ClassNotFoundException, SQLException{
	List<ProductBean> list = new ArrayList<>();
	Connection con = DBconnection.getConnection();
	
	PreparedStatement ps = con.prepareStatement("select * from product");
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		ProductBean pb = new ProductBean();
		pb.setPid(rs.getInt(1));
		pb.setPname(rs.getString(2));
		pb.setPrice(rs.getInt(3));
		pb.setQty(rs.getInt(4));
		
		list.add(pb);
	}
	return list;
}
}
