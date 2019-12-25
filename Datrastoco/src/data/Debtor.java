package data;

public class Debtor {

	private String name;
	private String transaction;
	
	public Debtor(String name, String transaction) {
		setName(name);
		setTransaction(transaction);
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

}
