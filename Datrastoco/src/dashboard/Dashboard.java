package dashboard;

import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.*;

import controller.PurchasesController;

public class Dashboard extends JFrame{
	private static String theDate;
	private static final JPanel card = new JPanel(new CardLayout());
	public static void main(String[] args) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String today = sdf.format(date);
		setTheDate(today);
		Utility.init();
		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						new Dashboard();
					}
					
				});
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
