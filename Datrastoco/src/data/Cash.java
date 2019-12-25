package data;

import views.CashBookView;

public class Cash {

	private String date;
	private String details;
	private double credit;
	private double debit;
	
	public Cash() {
		setDate(CashBookView.getDateSelector().getFullDate());
	}
	public Cash(String details, double credit, double debit) {
		setDetails(details);
		setCredit(credit);
		setDebit(debit);
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
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

}
