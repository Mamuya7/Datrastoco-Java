package data;

import javax.swing.JOptionPane;

public class Debtor {

	private String name;
	private String transaction;
	private SalesData salesdata;
	
	public Debtor(SalesData salesdata) {
		setName(JOptionPane.showInputDialog("Weka jina la mkopaji"));
		setTransaction("Sales of " + salesdata.getProdName());
		setSalesdata(salesdata);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	public SalesData getSalesdata() {
		return salesdata;
	}
	public void setSalesdata(SalesData salesdata) {
		this.salesdata = salesdata;
	}

}
