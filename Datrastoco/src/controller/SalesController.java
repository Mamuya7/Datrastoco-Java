package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dashboard.Dashboard;
import dashboard.Utility;
import data.Debtor;
import data.SalesData;
import model.Models;
import model.SalesModel;
import model.Search;
import views.SalesView;

public class SalesController implements ActionListener{
	private static int id = 0;
	public SalesController(JButton button, JButton post, JRadioButton defaultprice, JRadioButton discountprice) {
		button.addActionListener(this);
		post.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent avt) {
		if(avt.getSource() == SalesView.getPost()) {
			String date = Dashboard.getTheDate();
			
			if(date == null || date == "") {
				date = JOptionPane.showInputDialog("Weka tarehe ya leo kwa mfumo wa YYYY-MM-DD");
			}
			date += "%'";
			Search.fetchTotal(Models.cash_sales + date);
			double value = Search.getTotal();
			SalesModel.poster(value);
		}
		if(avt.getSource() == SalesView.getSave()) {
			SalesData salesdata = new SalesData();
			SalesModel salesmodel;
			
			if(salesdata.getPayment() == 0) {
				JOptionPane.showMessageDialog(null,"Chagua aina ya malipo");
			}else {
				if(salesdata.getPayment() == 2) {
					Debtor debtor = new Debtor(salesdata);
					salesmodel = new SalesModel(debtor);
				}else {
					salesmodel = new SalesModel(salesdata);
				}
				
				try {
					Thread thread =  new Thread(salesmodel.query());
					thread.start();
					thread.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if(salesmodel.getEffect() == 0) {
					JOptionPane.showMessageDialog(null, "Idadi ya bidhaa unayojaribu "
							+ "kuuza ni nyingi kuliko zilizopo");
				}
				
				String[] rowData = {
						salesdata.getProdName(),
						salesdata.getProdSize(),
						String.valueOf(salesdata.getQuantity()),
						String.valueOf(salesdata.getAmount())};
				
				SalesView.getSalesTableBoard().getBoardTable().addData(rowData);
				salesdata.clearFields();
			}
		}
		
	}
	
	public static void initiateSales() {
		SalesModel model = new SalesModel();
		
		Utility.queryDatabase(model.post());
		Utility.fetchDatabase(SalesModel.loadSales());
		
		SalesView.getSalesTableBoard().getBoardTable().fillTable(SalesModel.getData());
		SalesView.getSalesTableBoard().setBoardTableAdapter(SalesModel.getData());
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		SalesController.id = id;
	}
	public void clearFields() {
		
		SalesView.getNamefield().setText("");
		SalesView.getSizefield().setText("");
		SalesView.getQuantityfield().setText("");
		SalesView.getPricefield().setText("");
		
		SalesView.getPaymentType().setSelectedIndex(0);
		
		SalesView.getQuantityfield().setScreenText("");
		SalesView.getPricefield().setScreenText("");
	}
}
