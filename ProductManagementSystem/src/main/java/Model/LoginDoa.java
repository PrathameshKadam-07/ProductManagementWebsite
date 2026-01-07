package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.LoginBean;
import Service.DBconnection;

public class LoginDoa {
public String Athentication(LoginBean lb) throws SQLException,ClassNotFoundException {
		Connection con = DBconnection.getConnection();
		
		PreparedStatement ps = con.prepareStatement("select * from userLogin where username=? and password=?");
		ps.setString(1,lb.getuname());
		ps.setString(2,lb.getPass());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) 
		{
			return "success";
		}
		else 
		{
			return "Failed";
		}
}

public int createUser(LoginBean lb) throws SQLException,ClassNotFoundException {
	Connection con = DBconnection.getConnection();
		
	PreparedStatement ps = con.prepareStatement("insert into userLogin values(?,?)");
	ps.setString(1,lb.getuname());
	ps.setString(2,lb.getPass());
	int rs = ps.executeUpdate();
	
	return rs;
}
}
