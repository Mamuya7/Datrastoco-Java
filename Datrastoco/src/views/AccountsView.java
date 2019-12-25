package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.*;

import controller.AccountController;
import view_tools.*;

public class AccountsView extends JPanel{
	private static final CardLayout account_layout = new CardLayout();
	private static final JPanel card_account = new JPanel(account_layout);
	private static final String SALES_ACCOUNT = "sales account";
	private static final String DEFAULT_ACCOUNT = "default";
	
	private static DateSelector dateSelector = new DateSelector();
	private static TableBoard tableBoard = new TableBoard(CostantValues.ACCOUNTS);
	
	private static JButton button = new JButton("POST TO ACCOUNTS");
	private static JButton[] menus = new JButton[]{new JButton("Purchases"),
			new JButton("Sales"),new JButton("Stock")};
	private static final JPanel side_bar = new JPanel(new GridLayout(4,1));
	
	public AccountsView() {
		super(new BorderLayout());
		new AccountController(this,button,menus);
		
		addSideBarItems();
		installCard();
		
		JPanel entries = new JPanel(new BorderLayout());
		entries.add(dateSelector,BorderLayout.WEST);
		entries.add(button,BorderLayout.EAST);
		
		add(side_bar,BorderLayout.WEST);
		add(card_account,BorderLayout.CENTER);
		add(entries,BorderLayout.NORTH);
	}
	private void installCard() {
		card_account.add(DEFAULT_ACCOUNT, new TableBoard(CostantValues.ACCOUNTS));
		card_account.add(SALES_ACCOUNT,new TableBoard(CostantValues.ACCOUNTS));
		account_layout.show(card_account, DEFAULT_ACCOUNT);
	}
	private void addSideBarItems() {
		for(JButton button:menus) {
			side_bar.add(button);
		}
	}
	public static DateSelector getDateSelector() {
		return dateSelector;
	}

	public static void setDateSelector(DateSelector dateSelector) {
		AccountsView.dateSelector = dateSelector;
	}

	public static TableBoard getTableBoard() {
		return tableBoard;
	}

	public static void setTableBoard(TableBoard tableBoard) {
		AccountsView.tableBoard = tableBoard;
	}

	public static JButton getButton() {
		return button;
	}

	public static void setButton(JButton button) {
		AccountsView.button = button;
	}
	public static JPanel getCardAccount() {
		return card_account;
	}
	public static JButton[] getMenus() {
		return menus;
	}
	public static void setMenus(JButton[] menus) {
		AccountsView.menus = menus;
	}
	
}
