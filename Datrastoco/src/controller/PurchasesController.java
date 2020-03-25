package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import dashboard.Dashboard;
import dashboard.Utility;
import data.ProductData;
import data.PurchaseData;
import model.Models;
import model.PurchasesModel;
import model.Search;
import views.PurchasesEntries;

public class PurchasesController implements ActionListener {
	private JButton button;
	private JRadioButton defprice;
	private JRadioButton disprice;
	
	public PurchasesController(JButton button, JRadioButton defprice, JRadioButton disprice) {
		button.addActionListener(this);
		defprice.addActionListener(this);
		disprice.addActionListener(this);
		
		this.button = button;
		this.defprice = defprice;
		this.disprice = disprice;
	}
	
	@Override
	public void actionPerformed(ActionEvent avt) {
		
		if(avt.getSource() == button) {
			PurchaseData purchasedata = new PurchaseData();
			PurchasesModel purchasemodel = new PurchasesModel(purchasedata);
			
			try {
				Thread thread =  new Thread(purchasemodel.query());
				thread.setName("purchases thread");
				thread.start();
				thread.join();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			if(purchasemodel.getAffected() > 0) {
				String[] rowData = {purchasedata.getProdName(),purchasedata.getProdSize(),
						String.valueOf(purchasedata.getQuantity()),
						String.valueOf(purchasedata.getAmount())};
				
				PurchasesEntries.getPurchaseTableBoard().getBoardTable().addData(rowData);
				
				purchasedata.clearFields();
				JOptionPane.showMessageDialog(null, "Manunuzi ya " + purchasedata.getProdName()
				+ " yamehifadhiwa.","Matokeo",JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Samahan! Kuna tatizo limejitokeza, "
						+ "tunaomba rudia kuingiza rekodi hii kwa uangalifu zaidi. Karibu!!"
						+ "", "Tatizo", JOptionPane.ERROR_MESSAGE);
			}
		}else if(avt.getSource() == defprice) {
			
		}else if(avt.getSource() == disprice) {
			
		}
	}
	
	public static void load_purchases() {
		Search search = new Search();
		PurchasesModel model = new PurchasesModel();
		
		Utility.fetchDatabase(search.fetch(Models.purchases_data + Dashboard.getTheDate()+"%'"));
		Utility.queryDatabase(model.post());
		
		PurchasesEntries.getPurchaseTableBoard().getBoardTable().fillTable(
				search.getTable_data());
		PurchasesEntries.getPurchaseTableBoard().setBoardTableAdapter(search.getTable_data());;
	}
	

}
