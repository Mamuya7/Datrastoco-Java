package data;

import views.DrawingView;

public class Draw {
	private static String drawer;
	private static String details;
	private static double amount;
	
	public Draw() {
		setDrawer(DrawingView.getUsernameField().getText());
		setDetails(DrawingView.getDetailsField().getText());
		setAmount(Double.parseDouble(DrawingView.getAmountField().getText()));
	}

	public Draw(String drawer2, String details2, double amount2) {
		setDrawer(drawer2);
		setDetails(details2);
		setAmount(amount2);
	}

	public String getDrawer() {
		return drawer;
	}

	public static void setDrawer(String drawer) {
		Draw.drawer = drawer;
	}

	public String getDetails() {
		return details;
	}

	public static void setDetails(String details) {
		Draw.details = details;
	}

	public double getAmount() {
		return amount;
	}

	public static void setAmount(double amount) {
		Draw.amount = amount;
	}

	public void clearFields() {
		DrawingView.getUsernameField().setText("");
		DrawingView.getDetailsField().setText("");
		DrawingView.getAmountField().setText("");
		DrawingView.getAmountField().setScreenText("");
	}
	
	
}
