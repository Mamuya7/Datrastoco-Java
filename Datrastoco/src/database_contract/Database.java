package database_contract;

public class Database {
	public static final String DATABASE_NAME = "datrastoco";
	
	public static class Stock{
		public static String TABLE_NAME = "stock";
		
		public static String PRODUCT_ID = "id";
		public static String PRODUCT_NAME = "prod_name";
		public static String PRODUCT_SIZE = "prod_size";
		public static String PRODUCT_QUANTITY = "prod_quantity";
		public static String PRODUCT_CATEGORY = "prod_category";
		public static String PRODUCT_COMPANY = "prod_company";
		public static String BUYING_PRICE = "buying_price";
		public static String SELLING_PRICE = "selling_price";
		public static String AMOUNT = "amount";
		public static String DATE = "date";
	}
	
	public static class SalesLedger{
		public static String TABLE_NAME = "daily_sales";
		
		public static String STOCK_ID = "stock_id";
		public static String QUANTITY = "quantity";
		public static String AMOUNT = "amount";
		public static String PAYMENT = "payment";
		public static String DATE = "date";
	}	
	public static class PurchasesLedger{
		public static String TABLE_NAME = "daily_purchases";
		
		public static String STOCK_ID = "stock_id";
		public static String QUANTITY = "quantity";
		public static String AMOUNT = "amount";
		public static String PAYMENT = "payment";
		public static String DATE = "date";
	}	
	public static class SalesAccount{
		public static String TABLE_NAME = "sales_ac";
		
		public static String SALES_AC_ID = "id";
		public static String DATE = "date";
		public static String AMOUNT = "amount";
	}	
	public static class PurchasesAccount{
		public static String TABLE_NAME = "purchases_ac";
		
		public static String PURCHASES_AC_ID = "id";
		public static String DATE = "date";
		public static String AMOUNT = "amount";
	}
}
