package view_tools;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Title extends JLabel {

	public Title() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Title(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public Title(Icon image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	public Title(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public Title(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public Title(String text) {
		super(text);
		setFont(new Font("San serif",Font.PLAIN,18));
	}
	
	public Title(String text, Color color) {
		this(text);
		setForeground(color);
	}

}
