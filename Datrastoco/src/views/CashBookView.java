package views;

import java.awt.BorderLayout;

import javax.swing.*;

import controller.CashBookController;
import view_tools.*;

public class CashBookView extends JPanel{
	private static final JLabel cashlabel = new JLabel("CASH SUMMARY OF:");
	
	private static DateSelector dateSelector = new DateSelector();
	private static TableBoard cashTableBoard = new TableBoard(CostantValues.cash_book_columns);
	private static JButton submit = new JButton("Submit");
	
	public CashBookView() {
		super(new BorderLayout());
		new CashBookController(submit);
		
		JPanel filterpane = new JPanel();
		GroupLayout grp =  new GroupLayout(filterpane);
		filterpane.setLayout(grp);
		
		grp.setAutoCreateContainerGaps(true);
		grp.setAutoCreateGaps(true);
		
		grp.setHorizontalGroup(
				grp.createSequentialGroup()
				.addGroup(
						grp.createParallelGroup()
						.addComponent(cashlabel)
						)
				.addGroup(
						grp.createParallelGroup()
						.addComponent(dateSelector)
						.addComponent(submit)
						)
				);
		grp.setVerticalGroup(
				grp.createSequentialGroup()
				.addGroup(
						grp.createParallelGroup()
						.addComponent(cashlabel)
						.addComponent(dateSelector)
						)
				.addGroup(
						grp.createParallelGroup()
						.addComponent(submit)
						)
				);
		
		JPanel entries = new JPanel(new BorderLayout());
		entries.add(filterpane,BorderLayout.EAST);
		
		add(entries,BorderLayout.NORTH);
		add(cashTableBoard,BorderLayout.CENTER);
	}
	
	public static DateSelector getDateSelector() {
		return dateSelector;
	}
	public static void setDateSelector(DateSelector dateSelector) {
		CashBookView.dateSelector = dateSelector;
	}
	public static TableBoard getCashTableBoard() {
		return cashTableBoard;
	}
	public static void setCashTableBoard(TableBoard cashTableBoard) {
		CashBookView.cashTableBoard = cashTableBoard;
	}

	public static JButton getSubmit() {
		return submit;
	}

	public static void setSubmit(JButton submit) {
		CashBookView.submit = submit;
	}
	
	
}
