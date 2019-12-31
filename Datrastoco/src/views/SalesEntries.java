package views;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.SalesController;
import controller.SearchController;
import view_tools.*;

public class SalesEntries extends JPanel {
	private static final Title title = new Title("Mauzo Ya Siku");
	
	private static final JLabel name = new JLabel("Product Name");
	private static final JLabel price = new JLabel("Product Price");
	private static final JLabel quantity = new JLabel("Product Quantity");
	private static final JLabel size  = new JLabel("Product Size");
	private static final JLabel defaultlabel = new JLabel("Default Price");
	private static final JLabel discountlabel = new JLabel("Discount Price");

	private static JSearchList sizesearch = new JSearchList();
	private static JSearchList namesearch = new JSearchList(sizesearch);
	
	private static JSearchField namefield = new JSearchField(namesearch);
	private static JSearchField sizefield =  new JSearchField(sizesearch);
	private static JNumberField pricefield = new JNumberField();
	private static JNumberField quantityfield = new JNumberField();
	
	private static JButton save = new JButton("SAVE");
	private static JButton post = new JButton("POST");
	
	private static JRadioButton defaultprice = new JRadioButton();
	private static JRadioButton discountprice = new JRadioButton();
	private static final ButtonGroup pricetype = new ButtonGroup();
	
	private static JComboBox<String> paymentType = new JComboBox<String>();
	
	private static TableBoard salesTableBoard = new TableBoard(CostantValues.sales_columns);
	
	public SalesEntries() {
		super();

		new SalesController(save,post,defaultprice,discountprice);
		
		pricetype.add(defaultprice);
		pricetype.add(discountprice);
		paymentCombo();
		
		sizesearch.setSearchField(sizefield);
		namesearch.setListAdapter(SearchController.fetchProductAdapter());
		namesearch.setSearchField(namefield);
		
		JPanel entries = new JPanel();
		entries = entriesPanel();
		
		JPanel topPanel = Functions.alignTitleTopCenter(title, entries);
		
		JPanel footPanel = new JPanel(new BorderLayout());
		footPanel.add(post,BorderLayout.EAST);
		
		setLayout(new BorderLayout());
		add(topPanel,BorderLayout.NORTH);
		add(salesTableBoard,BorderLayout.CENTER);
		add(footPanel,BorderLayout.SOUTH);
	}
	
	private JPanel entriesPanel() {
	
	JPanel entries = new JPanel();
	GroupLayout gl = new GroupLayout(entries);
	entries.setLayout(gl);

	JScrollPane scrollNames = new JScrollPane(namesearch);
	JScrollPane scrollSizes = new JScrollPane(sizesearch);
	
	JPanel priceOptions = new JPanel();
	priceOptions = priceOptionPanel();
	
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
	private JPanel priceOptionPanel() {
		JPanel priceOptions = new JPanel();
		
		GroupLayout gl2 = new GroupLayout(priceOptions);
		priceOptions.setLayout(gl2);
		
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
		return priceOptions;
	}

	private void paymentCombo() {
		paymentType.addItem("Payment Type");
		paymentType.addItem("Cash");
		paymentType.addItem("Credit");
	}
	public static JTextField getNamefield() {
		return namefield;
	}


	public static void setNamefield(JSearchField namefield) {
		SalesEntries.namefield = namefield;
	}


	public static JNumberField getPricefield() {
		return pricefield;
	}


	public static void setPricefield(JNumberField pricefield) {
		SalesEntries.pricefield = pricefield;
	}


	public static JNumberField getQuantityfield() {
		return quantityfield;
	}


	public static void setQuantityfield(JNumberField quantityfield) {
		SalesEntries.quantityfield = quantityfield;
	}


	public static JSearchField getSizefield() {
		return sizefield;
	}


	public static void setSizefield(JSearchField sizefield) {
		SalesEntries.sizefield = sizefield;
	}


	public static TableBoard getSalesTableBoard() {
		return salesTableBoard;
	}


	public static void setSalesTableBoard(TableBoard salesTableBoard) {
		SalesEntries.salesTableBoard = salesTableBoard;
	}


	public static JComboBox<String> getPaymentType() {
		return paymentType;
	}


	public static void setPaymentType(JComboBox<String> paymentType) {
		SalesEntries.paymentType = paymentType;
	}

	public static JButton getPost() {
		return post;
	}

	public static void setPost(JButton post) {
		SalesEntries.post = post;
	}

	public static JButton getSave() {
		return save;
	}

	public static void setSave(JButton save) {
		SalesEntries.save = save;
	}
}
