package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dashboard.Utility;
import model.Search;
import model.StockModel;
import view_tools.CostantValues;
import view_tools.Table;
import view_tools.TableBoard;
import views.LowStock;
import views.StockEntries;

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
			String prod_name = StockEntries.getNamefield().getText();
			String prod_size = StockEntries.getSizefield().getText();
			String sizetype = StockEntries.getSizetype().getSelectedItem().toString();
			if((prod_name.length() == 0) || (prod_size.length() == 0) || (sizetype.length() == 0)) {
				JOptionPane.showMessageDialog(null, "All fields must be field to register a new product");
			}else {
				prod_size += sizetype;
				new StockModel(prod_name.toUpperCase(),prod_size,0);
				String[] rowData = {prod_name.toUpperCase(),prod_size,""};
				StockEntries.getStockTableBoard().getBoardTable().addData(rowData);
				
				clearFields();
			}
		}else if(evt.getSource() == combo) {
			qty = (Integer) combo.getSelectedItem();
			filterStockByQuantity();
		}

	}
	
	public static void initiateStock() {
		new StockModel();
		Table table = StockEntries.getStockTableBoard().getBoardTable();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		
		ArrayList<ArrayList<Object>> list = StockModel.getData();
		for(ArrayList<Object> row: list) {
			dtm.addRow(row.toArray());
		}
		
		table.setTablemodel(dtm);
		StockEntries.getStockTableBoard().setBoardTable(table);
		StockEntries.getStockTableBoard().setBoardTableAdapter(StockModel.getData());
	
	}
	
	public static void filterStockByQuantity() {
		Table table = LowStock.getLowStockTableBoard().getBoardTable();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
	
		Utility.database_thread = new Thread(StockModel.fetchLowStock(qty));
		Utility.database_thread.start();
		try {
			Utility.database_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ArrayList<ArrayList<Object>> data = StockModel.getData();
		table.fillTable(data);
	}
	public void clearFields() {
		StockEntries.getNamefield().setText("");
		StockEntries.getSizefield().setText("");
		StockEntries.getQuantityfield().setText("");
		StockEntries.getSizetype().setSelectedIndex(0);
		
		StockEntries.getQuantityfield().setScreenText("");
	}

}
