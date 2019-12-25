package dashboard;

import controller.PricelistController;
import controller.PurchasesController;
import controller.SalesController;
import controller.StockController;

public class Utility{
	public static Thread database_thread;
	public static Thread database_vice_thread;
	
	public Utility() {
		SalesController.initiateSales();
		PurchasesController.load_purchases();
		PricelistController.loadPricelist();
		StockController.filterStockByQuantity();
		StockController.initiateStock();
	}
}
