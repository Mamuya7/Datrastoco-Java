package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import controller.PurchasesController;
import controller.SalesController;
import controller.SearchController;
import view_tools.CostantValues;
import view_tools.Functions;
import view_tools.JNumberField;
import view_tools.JSearchField;
import view_tools.JSearchList;
import view_tools.TableBoard;
import view_tools.Title;

public class PurchasesEntries extends JPanel {
	private static final Title title = new Title("Manunuzi Ya Siku",Color.BLUE);
	
	private static final JLabel name = new JLabel("Product Name");
	private static final JLabel price = new JLabel("Product Price");
	private static final JLabel quantity = new JLabel("Product Quantity");
	private static final JLabel size  = new JLabel("Product Size");
	private static final JLabel defaultlabel = new JLabel("Default Price");
	private static final JLabel discountlabel = new JLabel("Discount Price");
	
	private static JComboBox<String> paymentType = new JComboBox<String>();
	private static JSearchList namesearch = new JSearchList();
	private static JSearchList sizesearch = new JSearchList();
	
	private static JSearchField namefield = new JSearchField(namesearch);
	private static JSearchField sizefield =  new JSearchField(sizesearch);
	private static JNumberField pricefield = new JNumberField();
	private static JNumberField quantityfield = new JNumberField();
	
	private static JButton save = new JButton("SAVE");
	
	private static JRadioButton defaultprice = new JRadioButton();
	private static JRadioButton discountprice = new JRadioButton();
	private static final ButtonGroup pricetype = new ButtonGroup();

	private static TableBoard purchaseTableBoard = new TableBoard(CostantValues.purchase_columns);
	public PurchasesEntries() {
		super();
		new PurchasesController(save,defaultprice,discountprice);
		discountprice.setSelected(true);
		
		pricetype.add(defaultprice);
		pricetype.add(discountprice);
		
		paymentType.addItem("Payment Type");
		paymentType.addItem("Cash");
		paymentType.addItem("Credit");
		
		sizesearch.setSearchField(sizefield);
		namesearch.setListAdapter(SearchController.fetchProductAdapter());
		namesearch.setSearchField(namefield);
		namesearch.setRefSearchList(sizesearch);
		
		JPanel entries = panelEntries();
		
		JPanel topPanel = Functions.alignTitleTopCenter(title, entries);
		
		setLayout(new BorderLayout());
		
		add(topPanel,BorderLayout.NORTH);
		add(purchaseTableBoard,BorderLayout.CENTER);
	}
	private JPanel panelEntries() {
		
		JScrollPane scrollNames = new JScrollPane(namesearch);
		JScrollPane scrollSizes = new JScrollPane(sizesearch);

		JPanel priceOptions = priceOptions();
		
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
							.addComponent(quantity)
							.addComponent(quantityfield))
					.addGroup(
							gl.createParallelGroup()
							.addComponent(price)
							.addComponent(pricefield)
							.addComponent(priceOptions))
					.addGroup(
							gl.createParallelGroup()
							.addComponent(paymentType)
							.addComponent(save))
				);
		gl.setVerticalGroup(
				gl.createSequentialGroup()
				.addGroup(
						gl.createParallelGroup()
						.addComponent(name)
						.addComponent(size)
						.addComponent(quantity)
						.addComponent(price)
						)
				.addGroup(
						gl.createParallelGroup()
						.addComponent(namefield)
						.addComponent(sizefield)
						.addComponent(quantityfield)
						.addComponent(pricefield)
						.addComponent(paymentType))
				.addGroup(
						gl.createParallelGroup()
						.addComponent(scrollNames)
						.addComponent(scrollSizes)
						.addComponent(priceOptions)
						.addComponent(save)
						)
					
				);
		return entries;
	}
	private JPanel priceOptions(){
		JPanel panel = new JPanel();
		GroupLayout gl2 = new GroupLayout(panel);
		panel.setLayout(gl2);
		
		gl2.setHorizontalGroup(
				gl2.createSequentialGroup()
				.addGroup(
						gl2.createParallelGroup()
						.addComponent(defaultprice)
						.addComponent(discountprice))
				.addGroup(
						gl2.createParallelGroup()
						.addComponent(defaultlabel)
						.addComponent(discountlabel))
				);
		gl2.setVerticalGroup(
				gl2.createSequentialGroup()
				.addGroup(
						gl2.createParallelGroup()
						.addComponent(defaultprice)
						.addComponent(defaultlabel))
				.addGroup(
						gl2.createParallelGroup()
						.addComponent(discountprice)
						.addComponent(discountlabel))
				);
		return panel;
	}

	public static JSearchField getNamefield() {
		return namefield;
	}


	public static void setNamefield(JSearchField namefield) {
		PurchasesEntries.namefield = namefield;
	}


	public static JSearchField getSizefield() {
		return sizefield;
	}


	public static void setSizefield(JSearchField sizefield) {
		PurchasesEntries.sizefield = sizefield;
	}


	public static JNumberField getPricefield() {
		return pricefield;
	}


	public static void setPricefield(JNumberField pricefield) {
		PurchasesEntries.pricefield = pricefield;
	}


	public static JNumberField getQuantityfield() {
		return quantityfield;
	}


	public static void setQuantityfield(JNumberField quantityfield) {
		PurchasesEntries.quantityfield = quantityfield;
	}


	public static JRadioButton getDefaultprice() {
		return defaultprice;
	}


	public static JRadioButton getDiscountprice() {
		return discountprice;
	}


	public static TableBoard getPurchaseTableBoard() {
		return purchaseTableBoard;
	}


	public static void setPurchaseTableBoard(TableBoard purchaseTableBoard) {
		PurchasesEntries.purchaseTableBoard = purchaseTableBoard;
	}


	public static JComboBox<String> getPaymentType() {
		return paymentType;
	}


	public static void setPaymentType(JComboBox<String> paymentType) {
		PurchasesEntries.paymentType = paymentType;
	}


}
