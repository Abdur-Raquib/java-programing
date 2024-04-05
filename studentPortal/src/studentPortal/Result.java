package studentPortal;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class Result extends JPanel {
	private JTable tb1data;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Result(){
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 222, 632, 275);
		add(scrollPane);
		
		tb1data = new JTable();
		scrollPane.setViewportView(tb1data);
		
		data();

	}
	
	public void data(){
		try {
			String url = "jdbc:mysql://127.0.0.1/university";
			String userName = "root";
			String pass = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, pass);
			Statement st = con.createStatement();
			String query = "select * from department";
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) tb1data.getModel();
			
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for(int i=0; i<cols; i++) {
				colName[i]=rsmd.getColumnName(i+1);
			}
			
			model.setColumnIdentifiers(colName);
			String dept,name,build;
			while(rs.next()) {
				dept = rs.getString(1);
				name = rs.getString(2);
				build = rs.getString(3);
				
				String[] row = {dept,name,build};
				model.addRow(row);
			}
			
		}catch ( ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
}
