package studentPortal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {
	
	public DatabaseConnect() throws ClassNotFoundException, SQLException {
		database();
	}
	
	public void database() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://1270.0.1/department";
		String userName = "root";
		String pass = "";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, userName, pass);
		Statement st = con.createStatement();
	}
}
