package dashboard;

import controller.*;

public class Utility{
	public static Thread database_thread;
	public static Thread database_vice_thread;
	private static Thread database_path;
	
	public Utility() {
		SearchController.loadProductsData();
		SalesController.initiateSales();
		PurchasesController.load_purchases();
		PricelistController.loadPricelist();
		StockController.filterStockByQuantity();
		StockController.initiateStock();
	}
	
	public static void queryDatabase(Runnable runnable) {
		try {
			database_path = new Thread(runnable);
			database_path.start();
			database_path.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
