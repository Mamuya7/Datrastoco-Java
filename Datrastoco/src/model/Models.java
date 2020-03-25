package model;

import dashboard.Dashboard;
import database_contract.Database;
import database_contract.Database.*;

public interface Models{
	public static final String url = "jdbc:mysql://localhost:3306/datrastoco";
	public static final String user = "root";
	public static final String password = "";
	

	public static final String insert_sales = "insert into " + SalesLedger.TABLE_NAME+ 
			" ("+ SalesLedger.STOCK_ID+","+SalesLedger.QUANTITY+","+SalesLedger.AMOUNT+","
					+ SalesLedger.PAYMENT+") values (?,?,?,?)";
	String insert_new_stock = "insert into "+ Database.Stock.TABLE_NAME+" ("
			+Database.Stock.PRODUCT_NAME + ","
			+Database.Stock.PRODUCT_SIZE + ","
			+Database.Stock.PRODUCT_QUANTITY + ","
			+Database.Stock.PRODUCT_CATEGORY + ","
			+Database.Stock.PRODUCT_COMPANY + ") values (?,?,?,?,?)";
	public static final String insert_expense = "insert into expenses (date,transaction,"
			+ "details,amount) values(?,?,?,?)";
	public static final String insert_purchase = "insert into "+ PurchasesLedger.TABLE_NAME+" ("
			+ PurchasesLedger.STOCK_ID + ","
			+ PurchasesLedger.QUANTITY + ","
			+ PurchasesLedger.AMOUNT + ") values (?,?,?)";
	public static final String insert_into_ = "insert into ";
	public static final String account = " (date,amount) values (?,?)";
	public static final String insert_drawings = "insert into drawings (drawer,details,amount)"
			+ " values (?,?,?)";
	public static final String insert_cash = "insert into cashbook (transaction,debit,credit)"
			+ " values (?,?,?)";
	public static final String insert_debtor = "insert into debtor (name,transaction,debit,credit)"
			+ " values (?,?,?,?)";
	public static final String insert_new_sales_account_date ="insert into " + SalesAccount.TABLE_NAME
			+ "(" + SalesAccount.DATE + ","+ SalesAccount.AMOUNT+") values (CURRENT_DATE(),?)";
	public static final String insert_new_purchases_account_date ="insert into " + PurchasesAccount.TABLE_NAME
			+ "(" + PurchasesAccount.DATE + ","+ PurchasesAccount.AMOUNT+") values (CURRENT_DATE(),?)";

	
	public static final String fetch_stock = "select * from "+ Stock.TABLE_NAME;
	public static final String fetch_sales = "select * from "+ SalesLedger.TABLE_NAME+" inner join "
			+ Stock.TABLE_NAME + " on "+ SalesLedger.TABLE_NAME+"."+ SalesLedger.STOCK_ID + " = "
			+ Stock.TABLE_NAME+"."+Stock.PRODUCT_ID + " where " +SalesLedger.TABLE_NAME+"."+SalesLedger.DATE+ " like 'CURRENT_DATE()%'";
	public static final String fetch_price_list = "select stock.prod_name, stock.prod_size, "
			+ "stock_invoice.buying_price, stock_invoice.selling_price from stock inner join "
			+ "stock_invoice on stock.id = stock_invoice.stock_id";
	public static final String fetch_lowstock_list = "select * from stock inner join stock_invoice on "
			+ "stock.id = stock_invoice.stock_id where stock.prod_quantity <= ?";
	public static final String fetch_cashbook_records = "select cashbook.transaction,cashbook.debit,"
			+ "cashbook.credit from cashbook where cashbook.date like ?%";
	public static final String fetch_users = "select users.name from users";
	public static final String fetch_sales_account = "select * from "
			+ SalesAccount.TABLE_NAME + " where " + SalesAccount.DATE + " like CURRENT_DATE()";
	public static final String fetch_purchases_account = "select * from "
			+ PurchasesAccount.TABLE_NAME + " where " + PurchasesAccount.DATE + " like CURRENT_DATE()";
	

	public static final String update_stock_on_sale ="update "+Stock.TABLE_NAME+" set "
			+ Stock.PRODUCT_QUANTITY + " = " + Stock.PRODUCT_QUANTITY + " - ? where "
			+ Stock.PRODUCT_ID + " = ? and NOT(" + Stock.PRODUCT_QUANTITY + " - ?) < 0";
//	public static final String update_stock_on_sale ="update "+Stock.TABLE_NAME+" set "
//			+ Stock.PRODUCT_QUANTITY + " = " + Stock.PRODUCT_QUANTITY + " - ? ,"+ Stock.AMOUNT
//			+" = "+Stock.AMOUNT+" - ("+Stock.BUYING_PRICE+" * ?) where "
//			+ Stock.PRODUCT_ID + " = ? and NOT(" + Stock.PRODUCT_QUANTITY + " - ?) < 0";
	public static final String update_stock_on_purchase ="update "+ Stock.TABLE_NAME +" set "
			+ Stock.PRODUCT_QUANTITY + " = " + Stock.PRODUCT_QUANTITY + " + ? ,"+ Stock.BUYING_PRICE 
			+" = ? / ? ,"+ Stock.AMOUNT +" = "+ Stock.AMOUNT +" + ? where "+ Stock.PRODUCT_ID + " = ?";
	public static final String update_stock_prices = "update "+Stock.TABLE_NAME+ " set "
			+ Stock.BUYING_PRICE +" = ?, "+Stock.SELLING_PRICE+" = ? where "+ Stock.PRODUCT_ID +" = ?";
	
	public static final String expense_data = "select date,transaction,details,amount from expenses";
	public static final String sales_data = "select stock.prod_name,stock.prod_size,"
			+ "daily_purchases.quantity,daily_purchases.price from stock inner join stock_invoice "
			+ "on stock.id = stock_invoice.stck_inv_id inner join daily_purchases on "
			+ "stock_invoice.stck_inv_id = daily_purchases.stock_invoice_id";
	public static final String purchases_data = "select "
			+ Stock.TABLE_NAME +"."+ Stock.PRODUCT_NAME+","
			+ Stock.TABLE_NAME +"."+ Stock.PRODUCT_SIZE+","
			+ PurchasesLedger.TABLE_NAME +"."+ PurchasesLedger.QUANTITY + "," 
			+ PurchasesLedger.TABLE_NAME +"."+ PurchasesLedger.AMOUNT 
			+ " from " + Stock.TABLE_NAME + " inner join " + PurchasesLedger.TABLE_NAME
			+ " on " + Stock.TABLE_NAME +"."+ Stock.PRODUCT_ID+ " = " 
			+ PurchasesLedger.TABLE_NAME +"."+ PurchasesLedger.STOCK_ID
			+ " where " + PurchasesLedger.TABLE_NAME +"."+ PurchasesLedger.DATE+ " like '";
	public static final String cash_sales = "select daily_sales.price from daily_sales where "
			+ "daily_sales.payment = 'cash' and daily_sales.date like '";
	
	public static final String sales_total = "select price from daily_sales where date like '";
	public static final String purchase_total = "select price from daily_purchases where date like '";
	public static final String stock_total = "select stock.prod_quantity * stock_invoice.buying_price "
			+ "from stock inner JOIN stock_invoice on stock.id = stock_invoice.stck_inv_id";
	public static final String product_names = "select stock.prod_name, stock.prod_size from stock";
	public static final String user_names = "select users.user_first_name from users";
	public static final String productsize = "select prod_size from stock where prod_name = '";
	public static final String all_stock_condition = "select * from stock where prod_name = ? "
			+ "and prod_size = ?";
	public static final String all_stock = "select * from stock";
	public static final String invoice_list = "select * from stock inner join stock_invoice on "
			+ "stock.id = stock_invoice.stock_id";
	

	
	public abstract Runnable query();
	public abstract Runnable insert();
	public abstract Runnable update();
}
