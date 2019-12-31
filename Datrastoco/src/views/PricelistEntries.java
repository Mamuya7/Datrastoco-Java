package views;

import java.awt.BorderLayout;

import javax.swing.*;

import controller.PricelistController;
import controller.SearchController;
import view_tools.CostantValues;
import view_tools.JNumberField;
import view_tools.JSearchField;
import view_tools.JSearchList;
import view_tools.TableBoard;

public class PricelistEntries extends JPanel implements CostantValues{
	private static final JLabel name = new JLabel("Product Name");
	private static final JLabel size  = new JLabel("Product Size");
	private static final JLabel buyingprice = new JLabel("Buying Price");
	private static final JLabel sellingprice = new JLabel("Selling Price");
	
	private static JSearchList namesearch = new JSearchList();
	private static JSearchList sizesearch = new JSearchList();
	
	private static JSearchField namefield = new JSearchField(namesearch);
	private static JSearchField sizefield =  new JSearchField(sizesearch);
	private static JNumberField buyingPricefield = new JNumberField();
	private static JNumberField sellingPricefield = new JNumberField();
	
	private static TableBoard tableBoard = new TableBoard(pricelist_columns);
	
	private static JButton save = new JButton("SAVE");
	
	public PricelistEntries() {
		super();
		new PricelistController(save);		
		
		sizesearch.setSearchField(sizefield);
		namesearch.setListAdapter(SearchController.fetchProductAdapter());
		namesearch.setSearchField(namefield);
		namesearch.setRefSearchList(sizesearch);
		
		JScrollPane scrollNames = new JScrollPane(namesearch);
		JScrollPane scrollSizes = new JScrollPane(sizesearch);
		
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
							.addComponent(namefield)
							.addComponent(scrollNames))
					.addGroup(
							gl.createParallelGroup()
							.addComponent(size)
							.addComponent(sizefield)
							.addComponent(scrollSizes))
					.addGroup(
							gl.createParallelGroup()
							.addComponent(buyingprice)
							.addComponent(buyingPricefield))
					.addGroup(
							gl.createParallelGroup()
							.addComponent(sellingprice)
							.addComponent(sellingPricefield)
							.addComponent(save))
				);
		gl.setVerticalGroup(
				gl.createSequentialGroup()
				.addGroup(
						gl.createParallelGroup()
						.addComponent(name)
						.addComponent(size)
						.addComponent(buyingprice)
						.addComponent(sellingprice))
				.addGroup(
						gl.createParallelGroup()
						.addComponent(namefield)
						.addComponent(sizefield)
						.addComponent(buyingPricefield)
						.addComponent(sellingPricefield))
				.addGroup(
						gl.createParallelGroup()
						.addComponent(scrollNames)
						.addComponent(scrollSizes)
						.addComponent(save))
					
				);
		
		setLayout(new BorderLayout());
		add(entries,BorderLayout.NORTH);
		add(tableBoard,BorderLayout.CENTER);
	}

	public static JSearchField getNamefield() {
		return namefield;
	}

	public static void setNamefield(JSearchField namefield) {
		PricelistEntries.namefield = namefield;
	}

	public static JSearchField getSizefield() {
		return sizefield;
	}

	public static void setSizefield(JSearchField sizefield) {
		PricelistEntries.sizefield = sizefield;
	}

	public static JNumberField getBuyingPricefield() {
		return buyingPricefield;
	}

	public static void setBuyingPricefield(JNumberField buyingPricefield) {
		PricelistEntries.buyingPricefield = buyingPricefield;
	}

	public static JNumberField getSellingPricefield() {
		return sellingPricefield;
	}

	public static void setSellingPricefield(JNumberField sellingPricefield) {
		PricelistEntries.sellingPricefield = sellingPricefield;
	}

	public static JButton getSave() {
		return save;
	}

	public static TableBoard getTableBoard() {
		return tableBoard;
	}

	public static void setTableBoard(TableBoard tableBoard) {
		PricelistEntries.tableBoard = tableBoard;
	}

}
