package data;

import views.PurchasesEntries;

public class PurchaseData extends ProductData  implements DataInterface{

	private double amount;
	private int payment;
	
	public PurchaseData() {
		setProdName(PurchasesEntries.getNamefield().getText());
		setProdSize(PurchasesEntries.getSizefield().getText());
		setQuantity(PurchasesEntries.getQuantityfield().getTextInDouble());
		setAmount(PurchasesEntries.getPricefield().getTextInDouble());
		setPayment(PurchasesEntries.getPaymentType().getSelectedIndex());
		setProdId(findProductId());
	}
	
	public PurchaseData(int prodId, String prodName, String prodSize, double quantity, double amount, int payment) {
		setProdId(prodId);
		setProdName(prodName);
		setProdSize(prodSize);
		setQuantity(quantity);
		setAmount(amount);
		setPayment(payment);
	}
	
	private int findProductId() {
		int id = 0;
		for(StockData product:StockData.products) {
			if(product.getProdName().equalsIgnoreCase(getProdName()) && 
					product.getProdSize().equalsIgnoreCase(getProdSize())) {
				id = product.getProdId();
				break;
			}
		}
		return id;
	}

	@Override
	public void clearFields() {
		PurchasesEntries.getNamefield().setText("");
		PurchasesEntries.getPricefield().setText("");
		PurchasesEntries.getQuantityfield().setText("");
		PurchasesEntries.getSizefield().setText("");
		PurchasesEntries.getDiscountprice().setSelected(true);
		PurchasesEntries.getPricefield().setEditable(true);
		
		PurchasesEntries.getPricefield().setScreenText("");
		PurchasesEntries.getQuantityfield().setScreenText("");
	}

	@Override
	public boolean validateFields() {
		return false;
		// TODO Auto-generated method stub
		
	}
	
	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
