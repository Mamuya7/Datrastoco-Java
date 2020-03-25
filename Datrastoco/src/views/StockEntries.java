package views;

import java.awt.*;

import javax.swing.*;

import controller.StockController;
import view_tools.*;

public class StockEntries extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final JLabel name = new JLabel("Product Name");
	private static final JLabel quantity = new JLabel("Product Quantity");
	private static final JLabel category = new JLabel("Product Category");
	private static final JLabel size  = new JLabel("Product Size");
	private static final JLabel company = new JLabel("product company");
	
	private static JTextField namefield = new JTextField(20);
	private static JTextField categoryfield = new JTextField(20);
	private static JNumberField quantityfield = new JNumberField(20);
	private static JTextField sizefield =  new JTextField(20);
	private static JComboBox<String> sizetype = new JComboBox<String>();
	private static JTextField companyfield = new JTextField(20);
	
	private static JButton save = new JButton("SAVE");
	
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
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		setConstraints(gbc,0,0,6,6,6,6);
		add(name,gbc);
		setConstraints(gbc,0,1);
		add(size,gbc);
		setConstraints(gbc,0,2);
		add(category,gbc);
		setConstraints(gbc,0,3);
		add(quantity,gbc);
		setConstraints(gbc,0,4);
		add(company,gbc);
		
		setConstraints(gbc,1,0);
		add(namefield,gbc);
		setConstraints(gbc,1,1);
		add(sizefield,gbc);
		setConstraints(gbc,1,2);
		add(categoryfield,gbc);
		setConstraints(gbc,1,3);
		add(quantityfield,gbc);
		setConstraints(gbc,1,4);
		add(companyfield,gbc);
		
		setConstraints(gbc,2,1);
		add(sizetype,gbc);
		setConstraints(gbc,2,5);
		add(save,gbc);
	}

	private void setConstraints(GridBagConstraints gbc, int i, int j) {
		gbc.gridx = i;
		gbc.gridy = j;
		
	}
	
	private void setConstraints(GridBagConstraints gbc, int i, int j, int w, int x, int y, int z) {
		setConstraints(gbc,i,j);
		gbc.insets = new Insets(w,x,y,z);
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

	public static JTextField getCategoryfield() {
		return categoryfield;
	}

	public static void setCategoryfield(JTextField categoryfield) {
		StockEntries.categoryfield = categoryfield;
	}

	public static JTextField getCompanyfield() {
		return companyfield;
	}

	public static void setCompanyfield(JTextField companyfield) {
		StockEntries.companyfield = companyfield;
	}
}
