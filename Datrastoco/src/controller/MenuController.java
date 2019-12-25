package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import dashboard.Dashboard;
import dashboard.SellerNavigator;
import view_tools.CostantValues;

public class MenuController implements ActionListener,CostantValues {
	
	public MenuController(JMenuItem item){
		item.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		CardLayout card = (CardLayout) Dashboard.getCard().getLayout();
		
		if(evt.getSource() == SellerNavigator.getSales()) {
			card.show(Dashboard.getCard(),SALESMODULE);
		}else if(evt.getSource() == SellerNavigator.getPurchases()) {
			card.show(Dashboard.getCard(),PURCHASESMODULE);
		}else if(evt.getSource() == SellerNavigator.getDrawings()) {
			card.show(Dashboard.getCard(),DRAWINGVIEW);
		}else if(evt.getSource() == SellerNavigator.getNewStock()) {
			card.show(Dashboard.getCard(),STOCKMODULE);
		}else if(evt.getSource() == SellerNavigator.getPricelist()) {
			card.show(Dashboard.getCard(), PRICELISTMODULE);
		}else if(evt.getSource() == SellerNavigator.getLowStock()) {
			card.show(Dashboard.getCard(), LOWSTOCKMODULE);
		}else if(evt.getSource() == SellerNavigator.getIndirectExpenses()) {
			ExpenseController.loadExpenses();
			card.show(Dashboard.getCard(), INDIRECTEXPENSES);
		}else if(evt.getSource() == SellerNavigator.getPost()) {
			card.show(Dashboard.getCard(), POST_VIEW);
		}else if(evt.getSource() == SellerNavigator.getCashbook()) {
			card.show(Dashboard.getCard(), CASHBOOKVIEW);
		}
	}

}
