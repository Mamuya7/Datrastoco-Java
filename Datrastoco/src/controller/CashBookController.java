package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import data.Cash;
import model.CashBookModel;
import view_tools.Functions;
import views.CashBookView;

public class CashBookController implements ActionListener {

	public CashBookController(JButton button) {
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Cash cash = new Cash();
		CashBookModel cashModel = new CashBookModel(cash);
		Functions.clearTable(CashBookView.getCashTableBoard().getBoardTable());
		CashBookView.getCashTableBoard().getBoardTable().fillTable(cashModel.fetch());
	}
	
}
