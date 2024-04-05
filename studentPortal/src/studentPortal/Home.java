package studentPortal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 70, 1160, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(21, 35, 1113, 530);
		frame.getContentPane().add(tabbedPane);
		Pre_registration pre_registration = new Pre_registration();
		Result result = new Result();
		Billing billing = new Billing();
		TeacherEvaluation te = new TeacherEvaluation();
		Profile profile = new Profile();
		
		JPanel panel = new JPanel();
		
		tabbedPane.addTab("Home", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(442, 73, 202, 40);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setBounds(442, 139, 202, 40);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("New button");
		btnNewButton_1_1_1.setBounds(442, 204, 202, 40);
		panel.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("New button");
		btnNewButton_1_1_2.setBounds(442, 277, 202, 40);
		panel.add(btnNewButton_1_1_2);
		
		JButton btnNewButton_1_1_3 = new JButton("New button");
		btnNewButton_1_1_3.setBounds(442, 344, 202, 40);
		panel.add(btnNewButton_1_1_3);
		
		JButton btnNewButton_1_1_4 = new JButton("New button");
		btnNewButton_1_1_4.setBounds(442, 408, 202, 40);
		panel.add(btnNewButton_1_1_4);
		tabbedPane.addTab("Pre_registration", null, pre_registration, null);
		tabbedPane.addTab("Result", null, result, null);
		tabbedPane.addTab("Billing", null, billing, null);
		tabbedPane.addTab("Teacher_Evaluation", null, te, null);
		tabbedPane.addTab("Profile", null, profile, null);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.setBounds(923, 26, 89, 23);
		frame.getContentPane().add(btnNewButton);



	}
}
