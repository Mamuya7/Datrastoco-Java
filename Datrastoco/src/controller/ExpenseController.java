package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import dashboard.Utility;
import data.ExpenseData;
import model.Expense;
import views.ExpenseView;

public class ExpenseController implements ActionListener {
	
	public ExpenseController(JButton button) {
		button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new ExpenseData(ExpenseView.getDateSelector().getFullDate(),
				ExpenseView.getTransaction().getText(),
				ExpenseView.getDetails().getText(),
				ExpenseView.getAmount().getTextInDouble()
				);
		
		Utility.fetch_database_thread = new Thread(new Runnable(){

			@Override
			public void run() {
				new Expense();
			}
			
		});
		
		Utility.fetch_database_thread.start();
		try {
			Utility.fetch_database_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int result = ExpenseData.getResult();
		
		if(result > 0) {
			JOptionPane.showMessageDialog(null, "Rekodi imehifadhiwa kikamilifu");
			int rowCount = ExpenseView.getTable().getBoardTable().getRowCount();
			ExpenseData.getNewDataRow()[0] = ++rowCount;
			ExpenseView.getTable().getBoardTable().getTablemodel().addRow(
					ExpenseData.getNewDataRow());
			
			clearFields();
		}
	}
	
	public void clearFields() {
		ExpenseView.getDateSelector().clearDate();
		ExpenseView.getTransaction().setText("");
		ExpenseView.getDetails().setText("");
		ExpenseView.getAmount().setText(0);
	}
	public static void loadExpenses() {
		Utility.fetch_database_thread = new Thread(
				new Runnable() {
					@Override
					public void run() {
						ExpenseView.getTable().getBoardTable().fillTable(
								Expense.getExpenses());
					}
					
				});
		Utility.fetch_database_thread.start();
		try {
			Utility.fetch_database_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
