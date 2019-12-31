package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dashboard.Utility;
import data.ProductData;
import model.Models;
import model.PriceList;
import model.Search;
import views.PricelistEntries;

public class PricelistController implements ActionListener {
	
	public PricelistController(JButton save) {
		save.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent avt) {
		String name = PricelistEntries.getNamefield().getText();
		String size = PricelistEntries.getSizefield().getText();
		double buying = Double.valueOf(PricelistEntries.getBuyingPricefield().getText());
		double selling = Double.valueOf(PricelistEntries.getSellingPricefield().getText());
		
		ProductData.fill(name, size, buying, selling);
		ProductData.classify();
		
		new PriceList(ProductData.getInvoice_id(),ProductData.getBuyprice(),ProductData.getSellprice());
		
		String[] rowData = {name,size,String.valueOf(buying),String.valueOf(selling)};
		PricelistEntries.getTableBoard().getBoardTable().addData(rowData);
		
	}

	public static void loadPricelist() {
		Search search = new Search();
		Utility.database_thread = new Thread(search.fetch(Models.fetch_price_list));
		Utility.database_thread.start();
		try {
			Utility.database_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		PricelistEntries.getTableBoard().getBoardTable().fillTable(search.getTable_data());
		PricelistEntries.getTableBoard().setBoardTableAdapter(search.getTable_data());
	}

	public void clearFields() {
		PricelistEntries.getNamefield().setText("");
		PricelistEntries.getSizefield().setText("");
		PricelistEntries.getBuyingPricefield().setText("");
		PricelistEntries.getSellingPricefield().setText("");
		

		PricelistEntries.getBuyingPricefield().setScreenText("");
		PricelistEntries.getSellingPricefield().setScreenText("");
	}

}
