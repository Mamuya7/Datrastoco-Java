package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

import controller.AccountController;
import view_tools.*;

public class StockListView extends JPanel{
	private static final Title stocklisttitle = new Title("List Of Products", Color.ORANGE);
	private static TableBoard stockTableBoard = new TableBoard(CostantValues.stocklist_columns);
	
	public StockListView() {
		setLayout(new BorderLayout());
		add(Functions.alignTitleTopCenter(stocklisttitle, stockTableBoard),BorderLayout.CENTER);
	}

	public static TableBoard getStockTableBoard() {
		return stockTableBoard;
	}

	public static void setStockTableBoard(TableBoard stockTableBoard) {
		StockListView.stockTableBoard = stockTableBoard;
	}
}
