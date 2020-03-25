package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dashboard.Utility;
import data.ProductData;
import data.StockData;
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
		ProductData productdata = new ProductData();
		productdata.initProduct();
		StockData stockdata = new StockData();
		PriceList pricelistmodel = new PriceList(productdata);
		
		
		try {
			Thread thread =  new Thread(pricelistmodel.query());
			thread.start();
			thread.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		String[] rowData = {stockdata.getProdName(),stockdata.getProdSize(),
				String.valueOf(stockdata.getBuyingPrice()),String.valueOf(stockdata.getSellingPrice())};
		PricelistEntries.getTableBoard().getBoardTable().addData(rowData);
		productdata.clearFields();
		
	}

	public static void loadPricelist() {
		Search search = new Search();
		Utility.fetch_database_thread = new Thread(search.fetch(Models.fetch_price_list));
		Utility.fetch_database_thread.start();
		try {
			Utility.fetch_database_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		PricelistEntries.getTableBoard().getBoardTable().fillTable(search.getTable_data());
		PricelistEntries.getTableBoard().setBoardTableAdapter(search.getTable_data());
	}

}
