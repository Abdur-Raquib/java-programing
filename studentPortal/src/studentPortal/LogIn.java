package studentPortal;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class LogIn {

	private JFrame frame;
	
	private JPanel contentPane;
	private JTextField logEmail;
	private JButton btnNewButton_1;
	private JRadioButton rdbtnNewRadioButton;
	private JPasswordField logPass;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 70, 1160, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(533, 160, 77, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(498, 214, 112, 31);
		contentPane.add(lblNewLabel_1);
		
		logEmail = new JTextField();
		logEmail.setBounds(606, 160, 250, 30);
		contentPane.add(logEmail);
		logEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Teacher","root","");
					String email = logEmail.getText();
					@SuppressWarnings("deprecation")
					String password = logPass.getText();
					Statement stm = con.createStatement();
					String sql = "select * from teacherreg where email='"+email+"' and password='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
//						setVisible(false);
//						new Home().setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "email or passwor is incorrect");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(665, 284, 106, 39);
		contentPane.add(btnNewButton);
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(584, 284, 106, 39);
		contentPane.add(btnNewButton_1);
		
		rdbtnNewRadioButton = new JRadioButton("show");
		rdbtnNewRadioButton.setFocusable(false);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					logPass.setEchoChar((char)0);
				}
				else {
					logPass.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton.setBounds(862, 220, 67, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		logPass = new JPasswordField();
		logPass.setBounds(606, 214, 250, 31);
		contentPane.add(logPass);
	}

}
