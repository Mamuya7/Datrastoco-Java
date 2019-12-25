package data;

public final class ExpenseData {
	private static String date;
	private static String transaction;
	private static String details;
	private static Double amount;
	private static int result;
	private static Object[] newDataRow;
	
	
	public ExpenseData() {
		setDate(null);
		setTransaction(null);
		setDetails(null);
		setAmount(0.0);
	}
	
	public ExpenseData(String transaction, String details, Double amount) {
		setTransaction(transaction);
		setDetails(details);
		setAmount(amount);
		
		newDataRow = new Object[]{0,"",transaction,details,amount};
	}
	public ExpenseData(String date, String transaction, String details, Double amount) {
		setDate(date);
		setTransaction(transaction);
		setDetails(details);
		setAmount(amount);
		newDataRow = new Object[]{0,date,transaction,details,amount};
	}

	public static String getDate() {
		return date;
	}
	public static void setDate(String date) {
		ExpenseData.date = date;
	}
	public static String getTransaction() {
		return transaction;
	}
	public static void setTransaction(String transaction) {
		ExpenseData.transaction = transaction;
	}
	public static String getDetails() {
		return details;
	}
	public static void setDetails(String details) {
		ExpenseData.details = details;
	}
	public static Double getAmount() {
		return amount;
	}
	public static void setAmount(Double amount) {
		ExpenseData.amount = amount;
	}

	public static int getResult() {
		return result;
	}

	public static void setResult(int result) {
		ExpenseData.result = result;
	}

	public static Object[] getNewDataRow() {
		return newDataRow;
	}

	public static void setNewDataRow(Object[] newDataRow) {
		ExpenseData.newDataRow = newDataRow;
	}
}
