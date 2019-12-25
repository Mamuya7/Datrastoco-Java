package views;

import java.awt.BorderLayout;

import javax.swing.*;

import controller.DrawingController;
import view_tools.*;

public class DrawingView extends JPanel{
	private static final JLabel username = new JLabel("Drawer");
	private static final JLabel details = new JLabel("Details");
	private static final JLabel amount = new JLabel("Amount");
	
	private static JTextField usernameField = new JTextField();
	private static JTextArea detailsField = new JTextArea();
	private static JNumberField amountField = new JNumberField();
	
	private static JButton savebutton = new JButton("SAVE");
	
	private static TableBoard drawsTableBoard = new TableBoard(CostantValues.drawing_columns);
	
	public DrawingView() {
		super(new BorderLayout());
		new DrawingController(savebutton);
		
		JPanel entries = new JPanel();
		GroupLayout grp = new GroupLayout(entries);
		entries.setLayout(grp);
		
		grp.setAutoCreateContainerGaps(true);
		grp.setAutoCreateGaps(true);
		
		grp.setHorizontalGroup(
				grp.createSequentialGroup()
				.addGroup(
						grp.createParallelGroup()
						.addComponent(username)
						.addComponent(usernameField)
						)
				.addGroup(
						grp.createParallelGroup()
						.addComponent(details)
						.addComponent(detailsField)
						)
				.addGroup(
						grp.createParallelGroup()
						.addComponent(amount)
						.addComponent(amountField)
						)
				.addGroup(
						grp.createParallelGroup()
						.addComponent(savebutton)
						)
				);
		
		grp.setVerticalGroup(
				grp.createSequentialGroup()
				.addGroup(
						grp.createParallelGroup()
						.addComponent(username)
						.addComponent(details)
						.addComponent(amount)
						)
				.addGroup(
						grp.createParallelGroup()
						.addComponent(usernameField)
						.addComponent(detailsField)
						.addComponent(amountField)
						.addComponent(savebutton)
						)
				);
		
		add(entries,BorderLayout.NORTH);
		add(drawsTableBoard,BorderLayout.CENTER);
	}

	public static JTextField getUsernameField() {
		return usernameField;
	}

	public static void setUsernameField(JTextField usernameField) {
		DrawingView.usernameField = usernameField;
	}

	public static JTextArea getDetailsField() {
		return detailsField;
	}

	public static void setDetailsField(JTextArea detailsField) {
		DrawingView.detailsField = detailsField;
	}

	public static JNumberField getAmountField() {
		return amountField;
	}

	public static void setAmountField(JNumberField amountField) {
		DrawingView.amountField = amountField;
	}

	public static TableBoard getDrawsTableBoard() {
		return drawsTableBoard;
	}

	public static void setDrawsTableBoard(TableBoard drawsTableBoard) {
		DrawingView.drawsTableBoard = drawsTableBoard;
	}

	public static JButton getSavebutton() {
		return savebutton;
	}

	public static void setSavebutton(JButton savebutton) {
		DrawingView.savebutton = savebutton;
	}
	
	
}
