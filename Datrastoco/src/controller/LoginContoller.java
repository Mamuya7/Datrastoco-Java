package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LoginContoller implements ActionListener{

	public LoginContoller(JButton button) {
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
}
