package views;

import javax.swing.JPanel;

import view_tools.*;

public class DebtorsView extends JPanel implements CostantValues{
	private static final Title title = new Title("Wadaiwa");
	private static TableBoard debtorTableBoard = new TableBoard(debtor_columns);
	
	public DebtorsView() {
		
	}

	public static TableBoard getDebtorTableBoard() {
		return debtorTableBoard;
	}

	public static void setDebtorTableBoard(TableBoard debtorTableBoard) {
		DebtorsView.debtorTableBoard = debtorTableBoard;
	}
}
