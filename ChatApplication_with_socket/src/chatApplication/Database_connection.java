package chatApplication;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class Database_connection {
	private PreparedStatement p;
	private ResultSet rs;
	private Connection con;
	public static void main(String agr[]) {
		try {
			Database_connection db = new Database_connection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Database_connection() throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost/team_speak"; // table details
		String username = "root"; // MySQL credentials
		String password = "";
		String query = "select *from users"; 
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = (Connection) DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established successfully");
	        p = con.prepareStatement(query);
	        rs = p.executeQuery();
	        while(rs.next()) {
	        	System.out.println(rs.getInt("id"));
	        	System.out.println(rs.getString("username"));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public ResultSet getdb() {
		return rs;
	}
}
