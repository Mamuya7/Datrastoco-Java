package views;

import java.awt.Color;

import javax.swing.*;

import view_tools.*;

public class UserView extends JPanel {
	private Title title = new Title("User Registartion",Color.ORANGE);
	
	private static final JLabel fnameLabel = new JLabel("First Name");
	private static final JLabel snameLabel = new JLabel("Second Name");
	private static final JLabel contactLabel = new JLabel("Phone Number");
	private static final JLabel addressLabel =  new JLabel("Address");
	
	private static JTextField fnameField = new JTextField();
	private static JTextField snameField = new JTextField();
	private static JNumberField contactField = new JNumberField();
	private static JTextField addressField = new JTextField();
	
	private static JButton register = new JButton("Register");
	
	public UserView() {
		
	}


	public static JTextField getFnameField() {
		return fnameField;
	}


	public static void setFnameField(JTextField fnameField) {
		UserView.fnameField = fnameField;
	}


	public static JTextField getSnameField() {
		return snameField;
	}


	public static void setSnameField(JTextField snameField) {
		UserView.snameField = snameField;
	}


	public static JNumberField getContactField() {
		return contactField;
	}


	public static void setContactField(JNumberField contactField) {
		UserView.contactField = contactField;
	}


	public static JTextField getAddressField() {
		return addressField;
	}


	public static void setAddressField(JTextField addressField) {
		UserView.addressField = addressField;
	}


	public static JButton getRegister() {
		return register;
	}


	public static void setRegister(JButton register) {
		UserView.register = register;
	}
}
