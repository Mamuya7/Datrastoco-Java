package data;

import views.SalesView;

public class SalesData extends ProductData implements DataInterface {
	
	private double amount;
	private int payment;
	
	public SalesData() {
		setProdName(SalesView.getNamefield().getText());
		setProdSize(SalesView.getSizefield().getText());
		setQuantity(SalesView.getQuantityfield().getTextInDouble());
		setAmount(SalesView.getPricefield().getTextInDouble());
		setPayment(SalesView.getPaymentType().getSelectedIndex());
		setProdId(findProductId());
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
		SalesView.getNamefield().setText("");
		SalesView.getPaymentType().setSelectedIndex(0);
		SalesView.getPricefield().setText("");
		SalesView.getPricefield().setScreenText("");
		SalesView.getQuantityfield().setText("");
		SalesView.getQuantityfield().setScreenText("");
		SalesView.getSizefield().setText("");
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
