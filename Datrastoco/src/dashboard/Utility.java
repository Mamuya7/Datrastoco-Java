package dashboard;

import controller.*;
import model.SalesModel;

public abstract class Utility{
	public static Thread fetch_database_thread;
	public static Thread database_vice_thread;
	private static Thread query_database_thread;
	
	public static void init() {
		SearchController.loadProductsData();
		SalesController.initiateSales();
		PurchasesController.load_purchases();
		PricelistController.loadPricelist();
		StockController.filterStockByQuantity();
		StockController.initiateStock();
	}
	
	public static void queryDatabase(Runnable runnable) {
		try {
			query_database_thread = new Thread(runnable);
			query_database_thread.setName("querydatabase_thread");
			query_database_thread.start();
			query_database_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void fetchDatabase(Runnable runnable) {
		try {
			fetch_database_thread = new Thread(runnable);
			fetch_database_thread.setName("fetchdatabase_thread");
			fetch_database_thread.start();
			fetch_database_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
