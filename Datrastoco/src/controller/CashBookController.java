package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import data.CashTransaction;
import model.CashBookModel;
import view_tools.Functions;
import views.CashBookView;

public class CashBookController implements ActionListener {
	private static JButton cashflow;
	private static JButton submit;
	
	public CashBookController(JButton save_cashflow, JButton submit) {
		submit.addActionListener(this);
		save_cashflow.addActionListener(this);
		
		CashBookController.cashflow = save_cashflow;
		CashBookController.submit = submit;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread thread;
		CashTransaction cash = new CashTransaction();
		CashBookModel cashModel = new CashBookModel(cash);
		if(e.getSource() == cashflow) {
			try {
				thread = new Thread(cashModel.query());
				thread.start();
				thread.join();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			cash.clearFields();
		}
		if(e.getSource() == submit) {

			Functions.clearTable(CashBookView.getCashTableBoard().getBoardTable());
			CashBookView.getCashTableBoard().getBoardTable().fillTable(cashModel.fetch());
		}
	}
	
}
