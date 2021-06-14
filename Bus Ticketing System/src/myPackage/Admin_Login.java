package myPackage;

import javax.swing.*; //IMPORT NECESSARY PACKAGES
import java.awt.*;
import javax.swing.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_Login extends JFrame {

	//Initialization of Components in the Frame
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField jpfPassword;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JSeparator separator;
	private JLabel lblAdmin_Login;
	private JLabel lblSuccess;
	private JLabel lblNotSuccess;
	private JButton btnLogin;

	/*
	 * CREATE THE FRAME
	 */
	public Admin_Login() {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsername = new JLabel("Username: ");
		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblUsername.setBounds(10, 108, 147, 43);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblPassword.setBounds(0, 165, 147, 43);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtUsername.setBounds(157, 124, 232, 27);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		jpfPassword = new JPasswordField();
		jpfPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jpfPassword.setBounds(157, 181, 232, 27);
		contentPane.add(jpfPassword);
		
		separator = new JSeparator();
		separator.setBounds(10, 80, 416, 2);
		contentPane.add(separator);
		
		lblAdmin_Login = new JLabel("Admin Login");
		lblAdmin_Login.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin_Login.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblAdmin_Login.setBounds(98, 0, 238, 82);
		contentPane.add(lblAdmin_Login);
		
		lblSuccess = new JLabel("");
		lblSuccess.setForeground(Color.DARK_GRAY);
		lblSuccess.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSuccess.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSuccess.setBounds(142, 226, 247, 27);
		contentPane.add(lblSuccess);
		
		lblNotSuccess = new JLabel("");
		lblNotSuccess.setForeground(Color.RED);
		lblNotSuccess.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotSuccess.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNotSuccess.setBounds(10, 226, 379, 27);
		contentPane.add(lblNotSuccess);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminLogin();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.setBounds(290, 263, 99, 27);
		contentPane.add(btnLogin);
		
	}
	
	
	/*
	 * METHOD PROMPTING THE ADMIN TO LOGIN WITH CORRECT USERNAME AND PASSWORD
	 */
	public void adminLogin() {
		String user = txtUsername.getText();
		String password = jpfPassword.getText();
		
		if(user.equals("admin")&& password.equals("admin12345")) {
			lblNotSuccess.setText(null);
			lblSuccess.setText("Login Successful!");
			Check_Bookings frame = new Check_Bookings();
			frame.setVisible(true);
		}else {
			lblNotSuccess.setText("Please enter a valid Username and Password!");
			txtUsername.setText(null);
			jpfPassword.setText(null);
		}
	}
}
