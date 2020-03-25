package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import controller.CashBookController;
import controller.SearchController;
import view_tools.*;

public class CashBookView extends JPanel{
	private static final Title title = new Title("CashBook",Color.GREEN);
	
	private static final JLabel cashlabel = new JLabel("CASH SUMMARY OF:");
	private static final JLabel transactionlabel = new JLabel("Transaction");
	private static final JLabel associatelabel = new JLabel("Associate");
	private static final JLabel amountlabel = new JLabel("Amount");
	
	private static JSearchList associateListField = new JSearchList();
	private static JNumberField amountField = new JNumberField();
	private static JComboBox<String> transactionCombo = new JComboBox<String>();
	
	private static JSearchField associateSearchField = new JSearchField(associateListField);
	private static DateSelector dateSelector = new DateSelector();
	private static TableBoard cashTableBoard = new TableBoard(CostantValues.cash_book_columns);
	
	private static JButton submit = new JButton("Submit");
	private static JButton save_cashflow = new JButton("Save");
	
	public CashBookView() {
		super(new BorderLayout());
		new CashBookController(save_cashflow,submit);
		cashbookTransactions(transactionCombo);
		
		associateListField.setSearchField(associateSearchField);
		associateListField.setListAdapter(SearchController.fetchUsersAdapter());
		
		JPanel filterpane = createFilterPanel();
		JPanel cashflow_entrypane = createEntryPanel();
		
		JPanel entries = new JPanel(new BorderLayout());
		JPanel arranger = new JPanel(new BorderLayout());
		entries.add(arranger,BorderLayout.NORTH);
		
		arranger.add(filterpane,BorderLayout.NORTH);
		arranger.add(cashflow_entrypane,BorderLayout.CENTER);
		
		JPanel main = new JPanel(new BorderLayout());
		main.add(entries,BorderLayout.WEST);
		main.add(cashTableBoard,BorderLayout.CENTER);
		
		JPanel topPanel = Functions.alignTitleTopCenter(title, main);
		add(topPanel,BorderLayout.NORTH);
		add(main,BorderLayout.CENTER);
	}
	
	private static JPanel createFilterPanel() {
		JPanel panel = new JPanel();
		GroupLayout grp =  new GroupLayout(panel);
		panel.setLayout(grp);
		
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
		return panel;
	}
	private static JPanel createEntryPanel() {
		JScrollPane scrollAssociateList = new JScrollPane(associateListField);
		
		JPanel panel = new JPanel();
		GroupLayout grp =  new GroupLayout(panel);
		panel.setLayout(grp);
		
		grp.setAutoCreateContainerGaps(true);
		grp.setAutoCreateGaps(true);
		
		grp.setHorizontalGroup(
				grp.createSequentialGroup()
				.addGroup(
						grp.createParallelGroup()
						.addComponent(transactionlabel)
						.addComponent(associatelabel)
						.addComponent(amountlabel)
						)
				.addGroup(
						grp.createParallelGroup()
						.addComponent(transactionCombo)
						.addComponent(associateSearchField)
						.addComponent(scrollAssociateList)
						.addComponent(amountField)
						.addComponent(save_cashflow)
						)
				);
		grp.setVerticalGroup(
				grp.createSequentialGroup()
				.addGroup(
						grp.createParallelGroup()
						.addComponent(transactionlabel)
						.addComponent(transactionCombo)
						)
				.addGroup(
						grp.createParallelGroup()
						.addComponent(associatelabel)
						.addComponent(associateSearchField)
						)
				.addGroup(
						grp.createParallelGroup()
						.addComponent(scrollAssociateList)
						)
				.addGroup(
						grp.createParallelGroup()
						.addComponent(amountlabel)
						.addComponent(amountField)
						)
				.addGroup(
						grp.createParallelGroup()
						.addComponent(save_cashflow)
						)
				);
		return panel;
	}
	private static void cashbookTransactions(JComboBox<String> transactions) {
		transactions.addItem("");
		transactions.addItem("Payment to Creditor");
		transactions.addItem("Payment from Debtor");
		transactions.addItem("Cash Withdraw");
		transactions.addItem("Capital Injection");
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

	public static JComboBox<String> getTransactionCombo() {
		return transactionCombo;
	}

	public static void setTransactionCombo(JComboBox<String> transactionCombo) {
		CashBookView.transactionCombo = transactionCombo;
	}

	public static JNumberField getAmountField() {
		return amountField;
	}

	public static void setAmountField(JNumberField amountField) {
		CashBookView.amountField = amountField;
	}

	public static JSearchField getAssociateSearchField() {
		return associateSearchField;
	}

	public static void setAssociateField(JSearchField associateSearchField) {
		CashBookView.associateSearchField = associateSearchField;
	}

	public static JSearchList getAssociateListField() {
		return associateListField;
	}

	public static void setAssociateListField(JSearchList associateListField) {
		CashBookView.associateListField = associateListField;
	}
	
	
}
