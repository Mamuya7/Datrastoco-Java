package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class TradingView extends JPanel{
	private static final JLabel o_stock_label = new JLabel("Opening Stock");
	private static final JLabel c_stock_label = new JLabel("Less Closing Stock");
	private static final JLabel purchase_label = new JLabel("Add Purchases");
	private static final JLabel directExp_label = new JLabel("Add Direct Expenses");
	private static final JLabel returnOut_label = new JLabel("Less Return Outwards");
	private static final JLabel netPurchases_label = new JLabel("Net Purchases");
	private static final JLabel gafs_label = new JLabel("C.G.A.F.S");
	private static final JLabel cos_label = new JLabel("C.O.S");
	private static final JLabel grossProfit_label = new JLabel("Gross Profit");
	private static final JLabel grossLoss_label = new JLabel("Gross Loss");
	private static final JLabel sales_label = new JLabel("Sales");
	private static final JLabel returnIn_label = new JLabel("Less Return Inwards");
	private static final JLabel netSales_label = new JLabel("Net Sales");
	
	private static JTextField o_stock = new JTextField(15);
	private static JTextField c_stock = new JTextField(15);
	private static JTextField purchases = new JTextField(15);
	private static JTextField directExp = new JTextField(15);
	private static JTextField returnOut = new JTextField(15);
	private static JTextField returnIn = new JTextField(15);
	private static JTextField sales = new JTextField(15);
	private static JTextField netsales = new JTextField(15);
	private static JTextField gafs = new JTextField(15);
	private static JTextField cos = new JTextField(15);
	private static JTextField grossprofit = new JTextField(15);
	private static JTextField grossloss = new JTextField(15);
	private static JTextField netPurchases = new JTextField(15);
	private static JTextField grossPurchases = new JTextField(15);
	private static JTextField rightTotal = new JTextField(15);
	private static JTextField leftTotal = new JTextField(15);
	
	private static final JPanel leftPanel = new JPanel();
	private static final JPanel rightPanel = new JPanel();
	
	public TradingView() {
		GroupLayout grp = new GroupLayout(this);
		setLayout(grp);
		
		grp.setAutoCreateContainerGaps(true);
		grp.setAutoCreateGaps(true);
		
		setLeftPanel();
		setRightPanel();
		
		grp.setHorizontalGroup(
				grp.createSequentialGroup()
				.addGroup(
						grp.createParallelGroup()
						.addComponent(leftPanel)
						)
				.addGroup(
						grp.createParallelGroup()
						.addComponent(rightPanel)
						)
				);
		
		grp.setVerticalGroup(
				grp.createSequentialGroup()
				.addGroup(
						grp.createParallelGroup()
						.addComponent(leftPanel)
						.addComponent(rightPanel)
						)
				);
	}
	
	private void setLeftPanel() {
		leftPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints cons = new GridBagConstraints();
		
		setConstraints(cons,0,0);
		leftPanel.add(o_stock_label,cons);
		setConstraints(cons,3,0);
		leftPanel.add(o_stock,cons);
		setConstraints(cons,0,1);
		leftPanel.add(purchase_label,cons);
		setConstraints(cons,1,1);
		leftPanel.add(purchases,cons);
		setConstraints(cons,0,2);
		leftPanel.add(directExp_label,cons);
		setConstraints(cons,1,2);
		leftPanel.add(directExp,cons);
		setConstraints(cons,2,2);
		leftPanel.add(grossPurchases,cons);
		setConstraints(cons,0,3);
		leftPanel.add(returnOut_label,cons);
		setConstraints(cons,2,3);
		leftPanel.add(returnOut,cons);
		setConstraints(cons,0,4);
		leftPanel.add(netPurchases_label,cons);
		setConstraints(cons,3,4);
		leftPanel.add(netPurchases,cons);
		setConstraints(cons,0,5);
		leftPanel.add(gafs_label,cons);
		setConstraints(cons,3,5);
		leftPanel.add(gafs,cons);
		setConstraints(cons,0,6);
		leftPanel.add(c_stock_label,cons);
		setConstraints(cons,3,6);
		leftPanel.add(c_stock,cons);
		setConstraints(cons,0,7);
		leftPanel.add(cos_label,cons);
		setConstraints(cons,3,7);
		leftPanel.add(cos,cons);
		setConstraints(cons,0,8);
		leftPanel.add(grossProfit_label,cons);
		setConstraints(cons,3,8);
		leftPanel.add(grossprofit,cons);
		setConstraints(cons,3,9);
		leftPanel.add(leftTotal,cons);
	}
	
	private void setRightPanel() {
		rightPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints cons = new GridBagConstraints();
		
		setConstraints(cons,0,0);
		rightPanel.add(sales_label,cons);
		setConstraints(cons,2,0);
		rightPanel.add(sales,cons);
		setConstraints(cons,0,1);
		rightPanel.add(returnIn_label,cons);
		setConstraints(cons,1,1);
		rightPanel.add(returnIn,cons);
		setConstraints(cons,0,2);
		rightPanel.add(netSales_label,cons);
		setConstraints(cons,2,2);
		rightPanel.add(netsales,cons);
		setConstraints(cons,0,8,150);
		rightPanel.add(grossLoss_label,cons);
		setConstraints(cons,2,8,150);
		rightPanel.add(grossloss,cons);
		setConstraints(cons,2,9);
		rightPanel.add(rightTotal,cons);
	}
	private void setConstraints(GridBagConstraints cons, int i, int j, int k) {
		cons.gridx = i;
		cons.gridy = j;
		cons.anchor = GridBagConstraints.NORTHWEST;
		cons.insets = new Insets(k,5,5,5);
	}

	private void setConstraints(GridBagConstraints cons, int i, int j) {
		cons.gridx = i;
		cons.gridy = j;
		cons.anchor = GridBagConstraints.NORTHWEST;
		cons.insets = new Insets(5,5,5,5);
	}

	public static JTextField getO_stock() {
		return o_stock;
	}
	public static void setO_stock(JTextField o_stock) {
		TradingView.o_stock = o_stock;
	}
	public static JTextField getC_stock() {
		return c_stock;
	}
	public static void setC_stock(JTextField c_stock) {
		TradingView.c_stock = c_stock;
	}
	public static JTextField getPurchases() {
		return purchases;
	}
	public static void setPurchases(JTextField purchases) {
		TradingView.purchases = purchases;
	}
	public static JTextField getDirectExp() {
		return directExp;
	}
	public static void setDirectExp(JTextField directExp) {
		TradingView.directExp = directExp;
	}
	public static JTextField getReturnOut() {
		return returnOut;
	}
	public static void setReturnOut(JTextField returnOut) {
		TradingView.returnOut = returnOut;
	}
	public static JTextField getReturnIn() {
		return returnIn;
	}
	public static void setReturnIn(JTextField returnIn) {
		TradingView.returnIn = returnIn;
	}
	public static JTextField getSales() {
		return sales;
	}
	public static void setSales(JTextField sales) {
		TradingView.sales = sales;
	}
	public static JTextField getNetsales() {
		return netsales;
	}
	public static void setNetsales(JTextField netsales) {
		TradingView.netsales = netsales;
	}
	public static JTextField getGafs() {
		return gafs;
	}
	public static void setGafs(JTextField gafs) {
		TradingView.gafs = gafs;
	}
	public static JTextField getCos() {
		return cos;
	}
	public static void setCos(JTextField cos) {
		TradingView.cos = cos;
	}
	public static JTextField getGrossprofit() {
		return grossprofit;
	}
	public static void setGrossprofit(JTextField grossprofit) {
		TradingView.grossprofit = grossprofit;
	}
	public static JTextField getGrossloss() {
		return grossloss;
	}
	public static void setGrossloss(JTextField grossloss) {
		TradingView.grossloss = grossloss;
	}
	public static JTextField getNetPurchases() {
		return netPurchases;
	}
	public static void setNetPurchases(JTextField netPurchases) {
		TradingView.netPurchases = netPurchases;
	}
	public static JTextField getGrossPurchases() {
		return grossPurchases;
	}
	public static void setGrossPurchases(JTextField grossPurchases) {
		TradingView.grossPurchases = grossPurchases;
	}

	public static JTextField getRightTotal() {
		return rightTotal;
	}

	public static void setRightTotal(JTextField rightTotal) {
		TradingView.rightTotal = rightTotal;
	}

	public static JTextField getLeftTotal() {
		return leftTotal;
	}

	public static void setLeftTotal(JTextField leftTotal) {
		TradingView.leftTotal = leftTotal;
	}
}

