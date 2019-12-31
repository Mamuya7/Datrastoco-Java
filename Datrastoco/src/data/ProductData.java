package data;

import java.util.ArrayList;

public class ProductData {
	public static ArrayList<ProductData> products = new ArrayList<ProductData>();
	
	private int id;
	private String prodName;
	private String prodSize;
	private double quantity;
	private double buyingPrice;
	private double sellingPrice;
	private double amount;

	public ProductData() {
	}
	
	public ProductData(int id, String prodName, String prodSize, double quantity, double buyingPrice, double sellingPrice, double amount) {
		setId(id);
		setProdName(prodName);
		setProdSize(prodSize);
		setQuantity(quantity);
		setBuyingPrice(buyingPrice);
		setSellingPrice(sellingPrice);
		setAmount(amount);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static ArrayList<ProductData> getProduct() {
		return products;
	}

	public static void setProduct(ArrayList<ProductData> product) {
		ProductData.products = product;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdSize() {
		return prodSize;
	}

	public void setProdSize(String prodSize) {
		this.prodSize = prodSize;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
