package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.*;

import controller.StockController;
import view_tools.CostantValues;
import view_tools.TableBoard;

public class LowStock extends JPanel implements CostantValues{
	private static TableBoard lowStockTableBoard = new TableBoard(lowStock_columns);;
	private static final JLabel levelLabel = new JLabel("Idadi chini ya ");
	private static JComboBox<Integer> levelCombo = new JComboBox<Integer>();
	
	public LowStock() {
		
		setLayout(new BorderLayout());
		add(fetchLevelEntry(),BorderLayout.NORTH);
		add(lowStockTableBoard,BorderLayout.CENTER);
	}
	
	private JPanel fetchLevelEntry() {
		for(int x = 0; x <= 20; x++) {
			levelCombo.addItem(x);
		}
		new StockController(levelCombo);
		
		JPanel panel = new JPanel(new GridLayout(1,4));
		panel.add(new JPanel());
		panel.add(new JPanel());
		panel.add(levelLabel);
		panel.add(levelCombo);
		return panel;
	}

	public static TableBoard getLowStockTableBoard() {
		return lowStockTableBoard;
	}

	public static void setLowStockTableBoard(TableBoard lowStockTableBoard) {
		LowStock.lowStockTableBoard = lowStockTableBoard;
	}
}
