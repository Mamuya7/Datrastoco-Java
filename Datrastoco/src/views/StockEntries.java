package views;

import java.awt.BorderLayout;

import javax.swing.*;

import controller.StockController;
import view_tools.CostantValues;
import view_tools.JNumberField;
import view_tools.TableBoard;

public class StockEntries extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final JLabel name = new JLabel("Product Name");
	private static final JLabel quantity = new JLabel("Product Quantity");
	private static final JLabel size  = new JLabel("Product Size");
	
	private static JTextField namefield = new JTextField();
	private static JNumberField quantityfield = new JNumberField();
	private static JTextField sizefield =  new JTextField();
	private static JComboBox<String> sizetype = new JComboBox<String>();
	
	private static JButton save = new JButton("SAVE");
	private static TableBoard stockTableBoard = new TableBoard(CostantValues.stock_columns);
	
	public StockEntries() {
		super();
		new StockController(save);
		sizetype.addItem("");
		sizetype.addItem("grams");
		sizetype.addItem("kgs");
		sizetype.addItem("mls");
		sizetype.addItem("ltr");
		sizetype.addItem("pcs");
		sizetype.addItem("pkt");
		
		JPanel entries = new JPanel();
		GroupLayout gl = new GroupLayout(entries);
		entries.setLayout(gl);
		
		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);
		
		gl.setHorizontalGroup(
				gl.createSequentialGroup()
					.addGroup(
							gl.createParallelGroup()
							.addComponent(name)
							.addComponent(namefield))
					.addGroup(
							gl.createParallelGroup()
							.addComponent(size)
							.addComponent(sizefield)
							.addComponent(sizetype))
					.addGroup(
							gl.createParallelGroup()
							.addComponent(quantity)
							.addComponent(quantityfield)
							.addComponent(save))
				);
		gl.setVerticalGroup(
				gl.createSequentialGroup()
				.addGroup(
						gl.createParallelGroup()
						.addComponent(name)
						.addComponent(size)
						.addComponent(quantity))
				.addGroup(
						gl.createParallelGroup()
						.addComponent(namefield)
						.addComponent(sizefield)
						.addComponent(quantityfield))
				.addGroup(
						gl.createParallelGroup()
						.addComponent(sizetype)
						.addComponent(save))
					
				);
		
		setLayout(new BorderLayout());
		add(entries,BorderLayout.NORTH);
		add(stockTableBoard,BorderLayout.CENTER);
		
	}

	public static JTextField getNamefield() {
		return namefield;
	}

	public static JNumberField getQuantityfield() {
		return quantityfield;
	}

	public static JTextField getSizefield() {
		return sizefield;
	}

	public static JButton getSave() {
		return save;
	}

	public static JComboBox<String> getSizetype() {
		return sizetype;
	}

	public static TableBoard getStockTableBoard() {
		return stockTableBoard;
	}

	public static void setStockTableBoard(TableBoard stockTableBoard) {
		StockEntries.stockTableBoard = stockTableBoard;
	}
}
