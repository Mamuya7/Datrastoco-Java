package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dashboard.Utility;
import model.Account;
import model.Models;
import model.Search;
import views.AccountsView;

public class AccountController implements ActionListener{
	private AccountsView account;
	private JButton[] menus;
	private static double total;
	private static String tablename;
	
	public AccountController(AccountsView account,JButton button, JButton[] menus) {
		button.addActionListener(this);
		for(JButton menu: menus) {
			menu.addActionListener(this);
		}
		this.account = account;
		this.menus = menus;
	}

	@Override
	public void actionPerformed(ActionEvent avt) {
		if(avt.getSource() == AccountsView.getButton()) {
			Account.postInto(tablename,getTotal());
		}else {
			String date = AccountsView.getDateSelector().getFullDate();
			
			if(date == null) {
				JOptionPane.showMessageDialog(account, "Tarehe haijawekwa, weka tarehe kwanza");
			}else {
				String query = null;
				
				if(avt.getSource() == menus[0]) {
//						query = Models.purchases_data;
					query = Models.purchase_total + date + "%'";
					setTablename("purchases_ac");
				}else if(avt.getSource() == menus[1]) {
//					query = Models.sales_data;
					query = Models.sales_total + date + "%'";
					setTablename("sales_ac");
				}else if(avt.getSource() == menus[2]) {
					query = Models.stock_total;
					setTablename("stock_ac");
				}
				Search.fetchTotal(query);
				setTotal(Search.getTotal());
//				DefaultTableModel dtm = (DefaultTableModel) Accounts.getTableBoard().getBoardTable().getModel();
//				DefaultTableModel footer_dtm = (DefaultTableModel) Accounts.getTableBoard().getFooter().getModel();
//				
//				dtm.setColumnCount(0);
//				dtm.setRowCount(0);
//				dtm.setColumnIdentifiers(column_names);
//				
//				footer_dtm.setColumnCount(dtm.getColumnCount());
//				Accounts.getTableBoard().getBoardTable().fillTable(Search.getTable_data());
			}
			
		}
	}

	public static double getTotal() {
		return total;
	}

	public static void setTotal(double total) {
		AccountController.total = total;
	}

	public static String getTablename() {
		return tablename;
	}

	public static void setTablename(String tablename) {
		AccountController.tablename = tablename;
	}

}
