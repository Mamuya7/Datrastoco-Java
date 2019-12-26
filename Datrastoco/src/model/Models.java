package model;

public interface Models{
	public static final String url = "jdbc:mysql://localhost:3306/datrastoco";
	public static final String user = "root";
	public static final String password = "";
	

	public static final String insert_sales = "insert into daily_sales (stock_invoice_id,"
			+ "quantity,price,payment) values (?,?,?,?)";
	public static final String insert_expense = "insert into expenses (date,transaction,"
			+ "details,amount) values(?,?,?,?)";
	public static final String insert_purchase = "insert into daily_purchases (stock_invoice_id,"
			+ "quantity,price) values (?,?,?)";
	public static final String insert_into_ = "insert into ";
	public static final String account = " (date,amount) values (?,?)";
	public static final String insert_drawings = "insert into drawings (drawer,details,amount)"
			+ " values (?,?,?)";
	public static final String insert_cash = "insert into cashbook (transaction,debit,credit)"
			+ " values (?,?,?)";
	public static final String insert_debtor = "insert into debtor (name,transaction,debit,credit)"
			+ " values (?,?,?,?)";
	
	public static final String fetch_price_list = "select stock.prod_name, stock.prod_size, "
			+ "stock_invoice.buying_price, stock_invoice.selling_price from stock inner join "
			+ "stock_invoice on stock.id = stock_invoice.stock_id";
	public static final String fetch_lowstock_list = "select * from stock inner join stock_invoice on "
			+ "stock.id = stock_invoice.stock_id where stock.prod_quantity <= ?";
	public static final String fetch_cashbook_records = "select cashbook.transaction,cashbook.debit,"
			+ "cashbook.credit from cashbook where cashbook.date like ?%";
	
	public static final String expense_data = "select date,transaction,details,amount from expenses";
	public static final String sales_data = "select stock.prod_name,stock.prod_size,"
			+ "daily_purchases.quantity,daily_purchases.price from stock inner join stock_invoice "
			+ "on stock.id = stock_invoice.stck_inv_id inner join daily_purchases on "
			+ "stock_invoice.stck_inv_id = daily_purchases.stock_invoice_id";
	public static final String purchases_data = "select stock.prod_name,stock.prod_size,"
			+ "daily_purchases.quantity,daily_purchases.price from stock inner join stock_invoice "
			+ "on stock.id = stock_invoice.stck_inv_id inner join daily_purchases on "
			+ "stock_invoice.stck_inv_id = daily_purchases.stock_invoice_id where daily_purchases.date like '";

	public static final String cash_sales = "select daily_sales.price from daily_sales where "
			+ "daily_sales.payment = 'cash' and daily_sales.date like '";
	public static final String purchase_account = "";
	
	public static final String sales_total = "select price from daily_sales where date like '";
	public static final String purchase_total = "select price from daily_purchases where date like '";
	public static final String stock_total = "select stock.prod_quantity * stock_invoice.buying_price "
			+ "from stock inner JOIN stock_invoice on stock.id = stock_invoice.stck_inv_id";
	
	public static final String all_sales = "select * from daily_sales inner join stock_invoice on"
			+ " daily_sales.stock_invoice_id = stock_invoice.stck_inv_id inner join stock on"
			+ " stock_invoice.stock_id = stock.id where daily_sales.date like '";
	public static final String product_names = "select prod_name from stock";
	public static final String productsize = "select prod_size from stock where prod_name = '";
	public static final String product_details = "select * from stock inner join stock_invoice on "
			+ "stock.id = stock_invoice.stock_id";
	public static final String decrease_stock_quantity ="update stock set stock.prod_quantity = "
			+ "stock.prod_quantity - ? where stock.id = ? and NOT(stock.prod_quantity - ?) < 0";
	public static final String increase_stock_quantity ="update stock set stock.prod_quantity = "
			+ "stock.prod_quantity + ? where stock.id = ?";
	public static final String all_stock_condition = "select * from stock where prod_name = ? "
			+ "and prod_size = ?";
	public static final String all_stock = "select * from stock";
	public static final String invoice_list = "select * from stock inner join stock_invoice on "
			+ "stock.id = stock_invoice.stock_id";
	public static final String update_invoice = "update stock_invoice set buying_price = ?, "
			+ "selling_price = ? where stck_inv_id = ?";
	public static final String new_invoice = "insert into stock_invoice (stock_id) values (LAST_INSERT_ID())";

	
	public abstract void insert();
}
