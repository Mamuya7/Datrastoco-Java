package dashboard;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import controller.LoginContoller;

public class Login extends JPanel {
	private static final JLabel usernameLabel = new JLabel("USERNAME");
	private static final JLabel passwordLabel = new JLabel("PASSWORD");
	
	private static JTextField username = new JTextField(20);
	private static JPasswordField password = new JPasswordField(20);
	
	private static JButton login = new JButton("Login");
	public Login() {
		setLayout(new GridBagLayout());
		
		new LoginContoller(login);
		
		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0; cons.gridy = 0;
		add(usernameLabel,cons);
		cons.gridy = 1;
		add(username,cons);
		cons.gridy = 2; cons.insets = new Insets(20,0,0,0);
		add(passwordLabel,cons);
		cons.gridy = 3; cons.insets = new Insets(0,0,0,0);
		add(password,cons);
		cons.gridy = 4; cons.insets = new Insets(20,0,0,0);
		add(login,cons);
	}
	public static JTextField getUsername() {
		return username;
	}
	public static void setUsername(JTextField username) {
		Login.username = username;
	}
	public static JPasswordField getPassword() {
		return password;
	}
	public static void setPassword(JPasswordField password) {
		Login.password = password;
	}
}
