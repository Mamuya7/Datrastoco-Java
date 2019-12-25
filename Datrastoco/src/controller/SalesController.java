package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import dashboard.Utility;
import data.Debtor;
import data.Product;
import model.SalesModel;
import model.Search;
import view_tools.Table;
import views.SalesEntries;

public class SalesController implements ActionListener{
	private static int id = 0;
	public SalesController(JButton button, JRadioButton defaultprice, JRadioButton discountprice) {
		button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent avt) {
		Product product = new Product(1);
		
		if(product.getPaymentType() == 0) {
			JOptionPane.showMessageDialog(null,"Chagua aina ya malipo");
		}else {
			SalesModel salesmodel;
			if(product.getPaymentType() == 2) {
				Debtor debtor = new Debtor(
						JOptionPane.showInputDialog("Weka jina la mkopaji"),
						"Sales of " + product.getName());
				salesmodel = new SalesModel(product,debtor);
			}else {
				salesmodel = new SalesModel(product);
			}
			
			salesmodel.insert();
			
			String[] rowData = {product.getName(),
					product.getSize(),
					String.valueOf(product.getQuantity()),
					String.valueOf(product.getAmount())};
			
			SalesEntries.getSalesTableBoard().getBoardTable().addData(rowData);
			
			SalesEntries.getNamefield().setText("");
			SalesEntries.getSizefield().setText("");
			SalesEntries.getQuantityfield().setText("");
			SalesEntries.getPricefield().setText("");
			
			SalesEntries.getPaymentType().setSelectedIndex(0);
			
			SalesEntries.getQuantityfield().setScreenText("");
			SalesEntries.getPricefield().setScreenText("");
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
}
