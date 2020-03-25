package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dashboard.Utility;
import data.ProductData;
import data.StockData;
import model.Search;
import model.StockModel;
import view_tools.CostantValues;
import view_tools.Table;
import view_tools.TableBoard;
import views.LowStock;
import views.StockEntries;
import views.StockListView;

public class StockController implements ActionListener,CostantValues{
	private JButton button;
	private JComboBox<?> combo;
	private static Integer qty = 0;
	
	public StockController(JButton button) {
		button.addActionListener(this);
		this.button = button;
	}
	public StockController(JComboBox<Integer> combo) {
		combo.addActionListener(this);
		this.combo = combo;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {

		if(evt.getSource() == button) {
			ProductData productdata = new ProductData();
			productdata.initProduct();
			
			if(!productdata.validateFields()) {
				JOptionPane.showMessageDialog(null, "All fields must be field to register a new product");
			}
			else {
				StockModel stockmodel = new StockModel(productdata);
				
				try {
					Thread thread = new Thread(stockmodel.insert());
					thread.start();
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				productdata.updateTable(stockmodel.isInserted());
				productdata.clearFields();
			}
		}else if(evt.getSource() == combo) {
			qty = (Integer) combo.getSelectedItem();
			filterStockByQuantity();
		}

	}
	
	public static void initiateStock() {
		StockModel stm = new StockModel();
		Utility.fetchDatabase(stm.query());
		
		Table table = StockListView.getStockTableBoard().getBoardTable();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		
		ArrayList<StockData> prodlist = StockData.getProducts();
		for(StockData product: prodlist) {
			Object[] row = {
				product.getProdId(),
				product.getProdName(),
				product.getProdSize(),
				product.getProdCategory(),
				product.getProdCompany(),
				product.getQuantity(),
				product.getBuyingPrice(),
				product.getSellingPrice(),
				product.getAmount()
			};
			dtm.addRow(row);
		}
		
		table.setTablemodel(dtm);
		StockListView.getStockTableBoard().setBoardTable(table);
		StockListView.getStockTableBoard().setBoardTableAdapter(StockModel.getData());
	
	}
	
	public static void filterStockByQuantity() {
		Table table = LowStock.getLowStockTableBoard().getBoardTable();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
	
		Utility.fetch_database_thread = new Thread(StockModel.fetchLowStock(qty));
		Utility.fetch_database_thread.start();
		try {
			Utility.fetch_database_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ArrayList<ArrayList<Object>> data = StockModel.getData();
		table.fillTable(data);
	}

}
