package dashboard;

import java.awt.CardLayout;

import javax.swing.*;

import controller.PurchasesController;

public class Dashboard extends JFrame{
	private static String theDate;
	private static final JPanel card = new JPanel(new CardLayout());
	public static void main(String[] args) {
		String today = JOptionPane.showInputDialog("Enter todays date in form of YYYY-MM-DD");
		setTheDate(today);
		new Utility();
		new Dashboard();
	}
	
	public Dashboard() {
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(new SellerNavigator());
		add(getCard());
		pack();
	}
	private void initializeAdminCardView() {
		getCard().removeAll();
	}

	public static JPanel getCard() {
		return card;
	}

	public static String getTheDate() {
		return theDate;
	}

	public static void setTheDate(String theDate) {
		Dashboard.theDate = theDate;
	}
}
