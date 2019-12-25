package view_tools;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class JNumberField extends JTextField implements KeyListener {
	private String screenText = "";
	private int point = 0;
	public JNumberField() {
		super();
		addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent kvt) {
		char c = kvt.getKeyChar();
		
		if(Character.isDigit(c) || c == '.') {
			if(c == '.') {
				++point;
			}

			if(point <= 1) {
				this.screenText += c;
			}
			
			if(point > 1) {
				point = 1;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent kvt) {
		if(kvt.getKeyCode() == kvt.VK_BACK_SPACE) {
			this.screenText = this.getText();
			checkDecimalPoint(this.screenText.toCharArray());
		}
		this.setText(this.screenText);
	}

	@Override
	public void keyTyped(KeyEvent kvt) {
	}

	public void setText(double value) {
		String t = String.valueOf(value);
		super.setText(t);
	}

	public double getTextInDouble() {
		double number;
		if(super.getText().equals(null) || super.getText().equals("")) {
			number = 0;
		} else {
			number = Double.valueOf(super.getText());
		}
		return number;
	}
	
	private void checkDecimalPoint(char[] values) {
		int point = 0;
		for(char value:values) {
			if(value == '.') {
				++point;
			}
		}
		this.point = point;
	}

	public String getScreenText() {
		return screenText;
	}

	public void setScreenText(String screenText) {
		this.screenText = screenText;
	}

}
