package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import dashboard.Dashboard;
import dashboard.Utility;
import data.Product;
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
		Product product = new Product(2);
		
		if(avt.getSource() == button) {
			new PurchasesModel(product);
			if(PurchasesModel.getAffected() > 0) {
				String[] rowData = {product.getName(),product.getSize(),
						String.valueOf(product.getQuantity()),String.valueOf(product.getAmount())};
				PurchasesEntries.getPurchaseTableBoard().getBoardTable().addData(rowData);
				clean_fields();
				JOptionPane.showMessageDialog(null, "Manunuzi ya " + product.getName() + " yamehifadhiwa.",
						"Matokeo",JOptionPane.INFORMATION_MESSAGE);;
			}else {
				JOptionPane.showMessageDialog(null, "Samahan! Kuna tatizo limejitokeza, "
						+ "tunaomba rudia kuingiza rekodi hii kwa uangalifu zaidi. Karibu!!"
						+ "", "Tatizo", JOptionPane.ERROR_MESSAGE);
			}
		}else if(avt.getSource() == defprice) {
			double amount = Product.getBuyprice() * product.getQuantity();
			PurchasesEntries.getPricefield().setText(amount);
			PurchasesEntries.getPricefield().setEditable(false);
		}else if(avt.getSource() == disprice) {
			PurchasesEntries.getPricefield().setEditable(true);
		}
	}
	
	public static void load_purchases() {
		Utility.database_thread = new Thread(Search.fetch(Models.purchases_data + Dashboard.getTheDate()+"%'"));
		Utility.database_thread.start();
		try {
			Utility.database_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		PurchasesEntries.getPurchaseTableBoard().getBoardTable().fillTable(
				Search.getTable_data());
		PurchasesEntries.getPurchaseTableBoard().setBoardTableAdapter(Search.getTable_data());;
	}
	private void clean_fields() {
		PurchasesEntries.getNamefield().setText("");
		PurchasesEntries.getPricefield().setText("");
		PurchasesEntries.getQuantityfield().setText("");
		PurchasesEntries.getSizefield().setText("");
		PurchasesEntries.getDiscountprice().setSelected(true);
		PurchasesEntries.getPricefield().setEditable(true);
		
		PurchasesEntries.getPricefield().setScreenText("");
		PurchasesEntries.getQuantityfield().setScreenText("");
	}
	

}
