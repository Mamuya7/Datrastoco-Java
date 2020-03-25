package data;

import java.util.ArrayList;

import views.PricelistEntries;
import views.StockEntries;

public class StockData extends ProductData implements DataInterface{
	public static ArrayList<StockData> products = new ArrayList<StockData>();
	
	private double amount = 0;
	private double buyingPrice = 0;
	private double sellingPrice = 0;
	
	public StockData() {
		setProdName(PricelistEntries.getNamefield().getText());
		setProdSize(PricelistEntries.getSizefield().getText());
		setBuyingPrice(PricelistEntries.getBuyingPricefield().getTextInDouble());
		setSellingPrice(PricelistEntries.getSellingPricefield().getTextInDouble());
	}
	
	public StockData(ProductData productdata, double buyingprice, double sellingprice, double amount) {
		setProdId(productdata.getProdId());
		setProdName(productdata.getProdName());
		setProdSize(productdata.getProdSize());
		setQuantity(productdata.getQuantity());
		setBuyingPrice(buyingprice);
		setSellingPrice(sellingprice);
		setAmount(amount);
	}
	@Override
	public void clearFields() {
		PricelistEntries.getNamefield().setText("");
		PricelistEntries.getSizefield().setText("");
		PricelistEntries.getBuyingPricefield().setText("");
		PricelistEntries.getSellingPricefield().setText("");
		

		PricelistEntries.getBuyingPricefield().setScreenText("");
		PricelistEntries.getSellingPricefield().setScreenText("");
	}
	
	public double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public static ArrayList<StockData> getProducts() {
		return products;
	}

	public static void setProducts(ArrayList<StockData> products) {
		StockData.products = products;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
