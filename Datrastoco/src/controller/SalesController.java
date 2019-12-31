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
import views.SalesEntries;

public class SalesController implements ActionListener{
	private static int id = 0;
	public SalesController(JButton button, JButton post, JRadioButton defaultprice, JRadioButton discountprice) {
		button.addActionListener(this);
		post.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent avt) {
		if(avt.getSource() == SalesEntries.getPost()) {
			String date = Dashboard.getTheDate();
			
			if(date == null || date == "") {
				date = JOptionPane.showInputDialog("Weka tarehe ya leo kwa mfumo wa YYYY-MM-DD");
			}
			date += "%'";
			Search.fetchTotal(Models.cash_sales + date);
			double value = Search.getTotal();
			SalesModel.post(value);
		}
		if(avt.getSource() == SalesEntries.getSave()) {
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
				
				String[] rowData = {salesdata.getProdName(),
						salesdata.getProdSize(),
						String.valueOf(salesdata.getQuantity()),
						String.valueOf(salesdata.getAmount())};
				
				SalesEntries.getSalesTableBoard().getBoardTable().addData(rowData);
				salesdata.clearFields();
			}
		}
		
	}
	
	public static void initiateSales() {
		Utility.database_thread = new Thread(SalesModel.loadSales());
		Utility.database_thread.start();
		try {
			Utility.database_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SalesEntries.getSalesTableBoard().getBoardTable().fillTable(SalesModel.getData());
		SalesEntries.getSalesTableBoard().setBoardTableAdapter(SalesModel.getData());
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		SalesController.id = id;
	}
	public void clearFields() {
		
		SalesEntries.getNamefield().setText("");
		SalesEntries.getSizefield().setText("");
		SalesEntries.getQuantityfield().setText("");
		SalesEntries.getPricefield().setText("");
		
		SalesEntries.getPaymentType().setSelectedIndex(0);
		
		SalesEntries.getQuantityfield().setScreenText("");
		SalesEntries.getPricefield().setScreenText("");
	}
}
