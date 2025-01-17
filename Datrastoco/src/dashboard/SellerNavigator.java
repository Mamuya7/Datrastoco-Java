package dashboard;

import javax.swing.*;

import controller.MenuController;
import view_tools.CostantValues;
import views.*;

public class SellerNavigator extends JMenuBar implements CostantValues {
	private static JMenu ledgers = new JMenu("Buy & Sale");
	private static JMenu cash_flow = new JMenu("CashFlow");
	private static JMenu accounts = new JMenu("Accounts");
	private static JMenu stock = new JMenu("Stock Control");
	private static JMenu registration = new JMenu("Registration");
	
	private static JMenuItem post = new JMenuItem("Post");
	
	private static JMenuItem user = new JMenuItem("User Registration");
	private static JMenuItem product = new JMenuItem("Product Registration");
	
	private static JMenuItem sales = new JMenuItem("Sales");
	private static JMenuItem purchases = new JMenuItem("Purchases");
	private static JMenuItem pricelist = new JMenuItem("Price List");
	
	private static JMenuItem cashbook = new JMenuItem("Cash Book");
	private static JMenuItem drawings =  new JMenuItem("Drawings");
	private static JMenuItem direct_expenses = new JMenuItem("Direct Expenses");
	private static JMenuItem ind_expenses = new JMenuItem("Indirect Expenses");
	
	private static JMenuItem stocklist = new JMenuItem("Stock List");
	private static JMenuItem lowstock = new JMenuItem("Low Stock");
	
	public SellerNavigator() {
		super();
		add(ledgerItems());
		add(cashFlowItems());
		add(accountItems());
		add(stockItems());
		add(registrationItems());
		initializeCardView();
	}

	private void initializeCardView() {
		Dashboard.getCard().removeAll();
		Dashboard.getCard().add(SALESMODULE,new SalesView());
		Dashboard.getCard().add(PURCHASESMODULE,new PurchasesEntries());
		Dashboard.getCard().add(STOCKLIST,new StockListView());
		Dashboard.getCard().add(PRICELISTMODULE,new PricelistEntries());
		Dashboard.getCard().add(LOWSTOCKMODULE, new LowStock());
		Dashboard.getCard().add(INDIRECTEXPENSES, new ExpenseView());
//		Dashboard.getCard().add(POST_VIEW, new AccountsView());
		Dashboard.getCard().add(DRAWINGVIEW, new DrawingView());
		Dashboard.getCard().add(CASHBOOKVIEW,new CashBookView());
		Dashboard.getCard().add(DEBTORSVIEW,new DebtorsView());
		Dashboard.getCard().add(USERVIEW,new UserView());
		Dashboard.getCard().add(PRODUCTVIEW,new StockEntries());
	}
	
	private JMenu stockItems() {
		new MenuController(stocklist);
		new MenuController(pricelist);
		new MenuController(lowstock);
		
		stock.add(stocklist);
//		stock.add(pricelist);
		stock.add(lowstock );
		
		return stock;
	}

	private JMenu ledgerItems() {
		new MenuController(sales);
		new MenuController(purchases);
		
		ledgers.add(sales);
		ledgers.add(purchases);
		return ledgers;
	}
	
	private JMenu cashFlowItems() {
		new MenuController(cashbook);
		new MenuController(drawings);
		new MenuController(direct_expenses);
		new MenuController(ind_expenses);
		
		cash_flow.add(cashbook);
		cash_flow.add(drawings);
		cash_flow.add(direct_expenses);
		cash_flow.add(ind_expenses);
		return cash_flow;
	}
	private JMenu accountItems() {
		new MenuController(post);
		
//		accounts.add(post);
		return accounts;
	}
	private JMenu registrationItems() {
		new MenuController(user);
		new MenuController(product);
		
		registration.add(user);
		registration.add(product);
		return registration;
	}
	public static JMenuItem getSales() {
		return sales;
	}

	public static JMenuItem getPurchases() {
		return purchases;
	}

	public static JMenuItem getIndirectExpenses() {
		return ind_expenses;
	}

	public static JMenuItem getDrawings() {
		return drawings;
	}

	public static JMenuItem getNewStock() {
		return stocklist;
	}

	public static JMenuItem getPricelist() {
		return pricelist;
	}

	public static JMenuItem getLowStock() {
		return lowstock;
	}

	public static JMenuItem getPost() {
		return post;
	}

	public static void setPost(JMenuItem post) {
		SellerNavigator.post = post;
	}

	public static JMenuItem getCashbook() {
		return cashbook;
	}

	public static void setCashbook(JMenuItem cashbook) {
		SellerNavigator.cashbook = cashbook;
	}

	public static JMenuItem getDirect_expenses() {
		return direct_expenses;
	}

	public static void setDirect_expenses(JMenuItem direct_expenses) {
		SellerNavigator.direct_expenses = direct_expenses;
	}

	public static JMenuItem getProduct() {
		return product;
	}

	public static void setProduct(JMenuItem product) {
		SellerNavigator.product = product;
	}

}
