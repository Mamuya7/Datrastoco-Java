package views;

import java.awt.BorderLayout;

import javax.swing.*;

import controller.ExpenseController;
import view_tools.CostantValues;
import view_tools.DateSelector;
import view_tools.Functions;
import view_tools.JNumberField;
import view_tools.TableBoard;
import view_tools.Title;

public class ExpenseView extends JPanel{
	private static final Title title = new Title("Matumizi Ya Siku");
	
	private static final JLabel transaction_label = new JLabel("Transaction");
	private static final JLabel details_label = new JLabel("Details");
	private static final JLabel date_label = new JLabel("Date");
	private static final JLabel amount_label = new JLabel("Amount");
	
	private static JTextField transaction = new JTextField();
	private static JTextArea details = new JTextArea();
	private static DateSelector dateSelector = new DateSelector();
	private static JNumberField amount = new JNumberField();
	private static JButton save = new JButton("Save");
	
	private static TableBoard table = new TableBoard(CostantValues.expenses_columns);
	
	public ExpenseView() {
		new ExpenseController(save);
		
		JPanel panel = new JPanel();
		GroupLayout grp = new GroupLayout(panel);
		panel.setLayout(grp);
		
		grp.setAutoCreateContainerGaps(true);
		grp.setAutoCreateGaps(true);
		
		grp.setVerticalGroup(
				grp.createSequentialGroup()
				.addGroup(
						grp.createParallelGroup()
						.addComponent(date_label)
						.addComponent(transaction_label)
						.addComponent(details_label)
						.addComponent(amount_label))
				.addGroup(
						grp.createParallelGroup()
						.addComponent(dateSelector)
						.addComponent(transaction)
						.addComponent(details)
						.addComponent(amount)
						.addComponent(save))
				);
		grp.setHorizontalGroup(
				grp.createSequentialGroup()
				.addGroup(
						grp.createParallelGroup()
						.addComponent(date_label)
						.addComponent(dateSelector))
				.addGroup(
						grp.createParallelGroup()
						.addComponent(transaction_label)
						.addComponent(transaction))
				.addGroup(
						grp.createParallelGroup()
						.addComponent(details_label)
						.addComponent(details))
				.addGroup(
						grp.createParallelGroup()
						.addComponent(amount_label)
						.addComponent(amount))
				.addGroup(grp.createParallelGroup().addComponent(save))
				);
		
		setLayout(new BorderLayout());
		add(Functions.alignTitleTopCenter(title, panel),BorderLayout.NORTH);
		add(table,BorderLayout.CENTER);
	}

	public static JTextField getTransaction() {
		return transaction;
	}

	public static void setTransaction(JTextField transaction) {
		ExpenseView.transaction = transaction;
	}

	public static JTextArea getDetails() {
		return details;
	}

	public static void setDetails(JTextArea details) {
		ExpenseView.details = details;
	}

	public static DateSelector getDateSelector() {
		return dateSelector;
	}

	public static void setDateSelector(DateSelector dateSelector) {
		ExpenseView.dateSelector = dateSelector;
	}

	public static JNumberField getAmount() {
		return amount;
	}

	public static void setAmount(JNumberField amount) {
		ExpenseView.amount = amount;
	}

	public static JButton getSave() {
		return save;
	}

	public static void setSave(JButton save) {
		ExpenseView.save = save;
	}

	public static TableBoard getTable() {
		return table;
	}
	
}
