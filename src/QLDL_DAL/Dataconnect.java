package QLDL_DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dataconnect {
	public static Connection connet() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/qldl","root","");
	}
	
	public static int getID(String table, String column) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con=connet();
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from "+table+" WHERE "+column+"=(select max("+column+") from "+table+")");  
		if(rs.next()==false)
			return 0;
		return rs.getInt(1)+1;
	}
}
