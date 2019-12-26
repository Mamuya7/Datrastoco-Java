package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dashboard.Utility;
import data.Product;
import model.Models;
import model.PriceList;
import model.Search;
import views.PricelistEntries;

public class PricelistController implements ActionListener,Controller {
	
	public PricelistController(JButton save) {
		save.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent avt) {
		String name = PricelistEntries.getNamefield().getText();
		String size = PricelistEntries.getSizefield().getText();
		double buying = Double.valueOf(PricelistEntries.getBuyingPricefield().getText());
		double selling = Double.valueOf(PricelistEntries.getSellingPricefield().getText());
		
		Product.fill(name, size, buying, selling);
		Product.classify();
		
		new PriceList(Product.getInvoice_id(),Product.getBuyprice(),Product.getSellprice());
		
		String[] rowData = {name,size,String.valueOf(buying),String.valueOf(selling)};
		PricelistEntries.getTableBoard().getBoardTable().addData(rowData);
		
	}

	public static void loadPricelist() {
		Utility.database_thread = new Thread(Search.fetch(Models.fetch_price_list));
		Utility.database_thread.start();
		try {
			Utility.database_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		PricelistEntries.getTableBoard().getBoardTable().fillTable(Search.getTable_data());
		PricelistEntries.getTableBoard().setBoardTableAdapter(Search.getTable_data());
	}

	@Override
	public void clearFields() {
		PricelistEntries.getNamefield().setText("");
		PricelistEntries.getSizefield().setText("");
		PricelistEntries.getBuyingPricefield().setText("");
		PricelistEntries.getSellingPricefield().setText("");
		

		PricelistEntries.getBuyingPricefield().setScreenText("");
		PricelistEntries.getSellingPricefield().setScreenText("");
	}

}
