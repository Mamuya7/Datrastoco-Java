package data;

import javax.swing.JOptionPane;
import views.StockEntries;

public class ProductData implements DataInterface{
	
	private int prodId;
	private String prodName;
	private String prodSize;
	private String size;
	private String prodUnits;
	private String prodCategory;
	private String prodCompany;
	private double quantity = 0;

	public ProductData() {
	}


	public ProductData(int prodId, String prodName, String prodSize, String prodCategory, String prodCompany,
			double quantity) {
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodSize = prodSize;
		this.prodCategory = prodCategory;
		this.prodCompany = prodCompany;
		this.quantity = quantity;
	}

	public void initProduct() {
		setSize(StockEntries.getSizefield().getText());
		setProdUnits(StockEntries.getSizetype().getSelectedItem().toString());
		
		setProdName(StockEntries.getNamefield().getText().toUpperCase());
		setProdSize(getSize() + getProdUnits());
		setQuantity(StockEntries.getQuantityfield().getTextInDouble());
		setProdCategory(StockEntries.getCategoryfield().getText().toUpperCase());
		setProdCompany(StockEntries.getCompanyfield().getText().toUpperCase());
	}
	
	@Override
	public void clearFields() {
		StockEntries.getNamefield().setText("");
		StockEntries.getSizefield().setText("");
		StockEntries.getQuantityfield().setText("");
		StockEntries.getSizetype().setSelectedIndex(0);
		StockEntries.getCompanyfield().setText("");
		StockEntries.getCategoryfield().setText("");
		StockEntries.getQuantityfield().setScreenText("");
	}

	@Override
	public boolean validateFields() {
		boolean status = false;
		if((this.prodName.length() == 0) || (this.size.length() == 0)) {
			status = false;
		}else {
			if(this.prodCategory.length() == 0)
				setProdCategory("none");
			if(this.prodCompany.length() == 0)
				setProdCompany("none");
			status = true;
		}
		return status;
	}
	@Override
	public void updateTable(boolean result) {
		if(result) {
			JOptionPane.showMessageDialog(null, "bidhaa mpya " 
		+ getProdName() + " ya " + getProdSize() + " imerekodiwa");
		}else {
			JOptionPane.showMessageDialog(null, "Bidhaa haijarekodiwa, rudia kurekodi tena!");
		}
	}
	
	public int getProdId() {
		return prodId;
	}

	public void setProdId(int id) {
		this.prodId = id;
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
	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}

	public String getProdCompany() {
		return prodCompany;
	}

	public void setProdCompany(String prodCompany) {
		this.prodCompany = prodCompany;
	}


	public String getProdUnits() {
		return prodUnits;
	}


	public void setProdUnits(String prodUnits) {
		this.prodUnits = prodUnits;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


}
