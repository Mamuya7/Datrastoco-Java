package data;

import views.SalesEntries;

public class SalesData implements DataInterface {
	
	private int prodId;
	private String prodName;
	private String prodSize;
	private double quantity;
	private double amount;
	private int payment;
	
	public SalesData() {
		setProdName(SalesEntries.getNamefield().getText());
		setProdSize(SalesEntries.getSizefield().getText());
		setQuantity(SalesEntries.getQuantityfield().getTextInDouble());
		setAmount(SalesEntries.getPricefield().getTextInDouble());
		setPayment(SalesEntries.getPaymentType().getSelectedIndex());
		setProdId(findProductId());
	}
	
	private int findProductId() {
		int id = 0;
		for(ProductData product:ProductData.products) {
			if(product.getProdName().equalsIgnoreCase(prodName) && 
					product.getProdSize().equalsIgnoreCase(prodSize)) {
				id = product.getId();
				break;
			}
		}
		return id;
	}

	@Override
	public void clearFields() {
		SalesEntries.getNamefield().setText("");
		SalesEntries.getPaymentType().setSelectedIndex(0);
		SalesEntries.getPricefield().setText("");
		SalesEntries.getPricefield().setScreenText("");
		SalesEntries.getQuantityfield().setText("");
		SalesEntries.getQuantityfield().setScreenText("");
		SalesEntries.getSizefield().setText("");
	}

	@Override
	public void validateFields() {
		// TODO Auto-generated method stub

	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

}
