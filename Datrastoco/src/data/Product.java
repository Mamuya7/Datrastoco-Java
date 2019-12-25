package data;

import java.util.ArrayList;

import views.PurchasesEntries;
import views.SalesEntries;

public class Product {
	public static ArrayList<ArrayList<Object>> products = null;
	private static int stock_id = 0;
	private static int invoice_id = 0;
	private static String name = null;
	private static String size = null;
	private static int quantity = 0;
	private static double amount = 0;
	private static double buyprice = 0;
	private static double sellprice = 0;
	private static int paymentType = 0;
	
	public Product(int c) {
		if(c == 1) {
			String name = SalesEntries.getNamefield().getText();
			String size = SalesEntries.getSizefield().getText();
			String quantity = SalesEntries.getQuantityfield().getText();
			String price = SalesEntries.getPricefield().getText();
			int payment = SalesEntries.getPaymentType().getSelectedIndex();

			Product.fill(name,size,Integer.parseInt(quantity),
					Double.parseDouble(price),payment);
			Product.classify();
		}
		if(c == 2) {
			String name = PurchasesEntries.getNamefield().getText();
			String size = PurchasesEntries.getSizefield().getText();
			int quantity = Integer.valueOf(PurchasesEntries.getQuantityfield().getText());
			double amount = PurchasesEntries.getPricefield().getTextInDouble();
			Product.fill(name, size, quantity, amount);
			Product.classifyMore();
		}
	}
	public static void classify() {
		for(ArrayList<Object> row: products) {
			if(name.equalsIgnoreCase((String) row.get(1))) {
				if(size.equalsIgnoreCase((String) row.get(2))) {
					setStock_id(Integer.parseInt(String.valueOf(row.get(0))));
					setInvoice_id(Integer.parseInt((String) row.get(4)));
				}
			}
		}
	}
	public static void classifyMore() {
		for(ArrayList<Object> row: products) {
			if(name.equalsIgnoreCase((String) row.get(1))) {
				if(size.equalsIgnoreCase((String) row.get(2))) {
					setStock_id(Integer.parseInt(String.valueOf(row.get(0))));
					setInvoice_id(Integer.parseInt((String) row.get(4)));
					setBuyprice(Double.parseDouble((String) row.get(7)));
				}
			}
		}
	}
	public static void fill(String name2, String size2, int quanty, double price, int payment) {
		setName(name2);
		setSize(size2);
		setQuantity(quanty);
		setAmount(price);
		setPaymentType(payment);
		
	}
	public static void fill(String name2, String size2, double buyprice, double sellprice) {
		setName(name2);
		setSize(size2);
		setBuyprice(buyprice);
		setSellprice(sellprice);
	}
	public static int getStock_id() {
		return stock_id;
	}
	public static void setStock_id(int id) {
		Product.stock_id = id;
	}
	public static int getInvoice_id() {
		return invoice_id;
	}
	public static void setInvoice_id(int invoice_id) {
		Product.invoice_id = invoice_id;
	}
	public String getName() {
		return name;
	}
	public static void setName(String name) {
		Product.name = name;
	}
	public String getSize() {
		return size;
	}
	public static void setSize(String size) {
		Product.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public static void setQuantity(int quantity) {
		Product.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public static void setAmount(double amount) {
		Product.amount = amount;
	}
	public static double getSellprice() {
		return sellprice;
	}
	public static void setSellprice(double sellprice) {
		Product.sellprice = sellprice;
	}
	public static double getBuyprice() {
		return buyprice;
	}
	public static void setBuyprice(double buyprice) {
		Product.buyprice = buyprice;
	}
	public static ArrayList<ArrayList<Object>> getProducts() {
		return products;
	}
	public static void setProducts(ArrayList<ArrayList<Object>> arrayList) {
		Product.products = arrayList;
	}
	public static void setPaymentType(int payment) {
		Product.paymentType = payment;
	}
	public int getPaymentType() {
		return paymentType;
	}
}
