package database_contract;

public class Database {
	public static final String DATABASE_NAME = "datrastoco";
	
	public static class Stock{
		public static String TABLE_NAME = "stock";
		
		public static String PRODUCT_ID = "id";
		public static String PRODUCT_NAME = "prod_name";
		public static String PRODUCT_SIZE = "prod_size";
		public static String PRODUCT_QUANTITY = "quantity";
		public static String BUYING_PRICE = "buying_price";
		public static String SELLING_PRICE = "selling_price";
		public static String AMOUNT = "amount";
		public static String DATE = "date";
	}
	
	public static class SalesLedger{
		public static String TABLE_NAME = "daily_sales";
	}
}
