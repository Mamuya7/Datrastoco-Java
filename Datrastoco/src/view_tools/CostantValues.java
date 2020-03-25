package view_tools;

public interface CostantValues {
	public final static String SALESMODULE = "SALES";
	public final static String STOCKLIST = "STOCKLIST";
	public final static String EXPENSESMODULE = "EXPENSES";
	public final static String DRAWINGMODULE = "DRAWING";
	public final static String PURCHASESMODULE = "PURCHASES";
	public final static String PRICELISTMODULE = "PRICELIST";
	public final static String LOWSTOCKMODULE = "LOWSTOCK";
	public final static String INDIRECTEXPENSES = "INDIRECTEXP";
	public final static String POST_VIEW = "POSTVIEW";
	public final static String DRAWINGVIEW = "DRAWINGVIEW";
	public final static String LOWSTOCK_TABLE_BOARD = "LOWSTOCK_TABLE_BOARD";
	public final static String CASHBOOKVIEW = "CASHBOOKVIEW";
	public final static String DEBTORSVIEW = "DEBTORVIEW";
	public final static String USERVIEW = "USERVIEW";
	public final static String PRODUCTVIEW = "PRODUCTVIEW";
	
	public static final String purchase_list = "Purchases Ledger";
	public static final String sales_list = "Sales Ledger";
	
	public static final String[] stocklist_columns = {"No.","Product Name","Product Size","Product Category",
			"Product Company","Quantity","Buying Price","Selling Price","Amount"};
	public static final String[] purchase_columns = {"No.","Product Name","Product Size","Quantity","Amount"};
	public static final String[] sales_columns = {"No.","Product Name","Product Size","Quantity","Amount"};
	public static final String[] pricelist_columns = {"ID","Product Name","Product Size","Buying "
			+ "Price","Selling Price"};
	public static final String[] lowStock_columns = {"No.","Product","Quantity","BuyingPrice"};
	public static final String[] week_days = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	public static final String[] expenses_columns = {"No.","Date","Transaction","Details","Amount"};
	public static final String[] ACCOUNTS = {"No.","Date","Amount"};
	public static final String[] drawing_columns = {"No.","Drawer","Added Information","Amount"};
	public static final String[] cash_book_columns = {"No.","Details","Debit","Credit"};
	public static final String[] debtor_columns = {"No.","Details","Debit","Credit"};
}
