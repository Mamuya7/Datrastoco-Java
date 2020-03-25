package data;

import views.CashBookView;

public class CashTransaction implements DataInterface{

	private String associate;
	private String date;
	private String transaction;
	private double credit;
	private double debit;
	
	public CashTransaction() {
		setDate(CashBookView.getDateSelector().getFullDate());
		setTransaction(CashBookView.getTransactionCombo().getSelectedItem().toString());
		setAssociate(CashBookView.getAssociateSearchField().getText());
		
		switch(CashBookView.getTransactionCombo().getSelectedIndex()) {
			case 0:
				break;
			case 1:
			case 3:
				setCredit(CashBookView.getAmountField().getTextInDouble());
				setDebit(0.0);
				break;
			case 2:
			case 4:
				setCredit(0.0);
				setDebit(CashBookView.getAmountField().getTextInDouble());
				break;
		}
	}
	public CashTransaction(String transaction, double credit, double debit) {
		this();
		setTransaction(transaction);
		setCredit(credit);
		setDebit(debit);
	}
	@Override
	public void clearFields() {
		CashBookView.getAssociateSearchField().setText("");
		CashBookView.getTransactionCombo().setSelectedIndex(0);
		CashBookView.getAmountField().setText("");
		CashBookView.getAmountField().setScreenText("");
	}

	@Override
	public boolean validateFields() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void updateTable(boolean result) {
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public double getDebit() {
		return debit;
	}
	public void setDebit(double debit) {
		this.debit = debit;
	}
	public String getAssociate() {
		return associate;
	}
	public void setAssociate(String associate) {
		this.associate = associate;
	}

}
