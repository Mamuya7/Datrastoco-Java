package view_tools;

import java.awt.BorderLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.function.Function;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class TableBoard extends JPanel implements KeyListener,FocusListener{
	private Table BoardTable;
	private JTable footer;
	private JScrollPane scrollPane;
	private JTextField tableSearchField;
	
	private ArrayList<ArrayList<Object>> boardTableAdapter;
	private ArrayList<ArrayList<Object>> filteredData;
	private double total;
	
	private String searchText = "";
	
	public TableBoard(String[] columns) {
		super();
		BoardTable = new Table(columns);
		scrollPane = new JScrollPane(BoardTable);
		tableSearchField = new JTextField();
		boardTableAdapter = new ArrayList<ArrayList<Object>>();
		
		tableSearchField.addKeyListener(this);
		tableSearchField.addFocusListener(this);

		BoardTable.getModel().addTableModelListener(
				new TableModelListener() {
					@Override
					public void tableChanged(TableModelEvent tmEvt) {
						if(tmEvt.getType() == TableModelEvent.INSERT) {
							DefaultTableModel dtm = (DefaultTableModel) BoardTable.getModel();
							
							int col = dtm.getColumnCount() - 1;
							int row = dtm.getRowCount() - 1;

							Double columnTotal = 0.0;
							for(; row >= 0; --row) {
								columnTotal = columnTotal + new Double(dtm.getValueAt(row, col).toString());
							}
							setTotal(columnTotal);
							footer.getModel().setValueAt(columnTotal, 0, col);
						}
					}
				});
		footer = new JTable(1,BoardTable.getColumnCount());
		
		setLayout(new BorderLayout());
		add(tableSearchField,BorderLayout.NORTH);
		add(scrollPane,BorderLayout.CENTER);
		add(footer,BorderLayout.SOUTH);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		filteredData = new ArrayList<ArrayList<Object>>();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			this.searchText = searchText.substring(0, searchText.length()-1);
		}else {
			this.searchText += e.getKeyChar();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { 
		for(ArrayList<Object> row: boardTableAdapter) {
			for(Object coldata: row) {
				String data = String.valueOf(coldata);
				if(data.startsWith(searchText.toUpperCase())) {
					filteredData.add(row);
					break;
				}
			}
		}
		Functions.clearTable(this.BoardTable);
		BoardTable.fillTable(filteredData);
	}

	@Override
	public void focusGained(FocusEvent e) {
		filteredData = new ArrayList<ArrayList<Object>>();
	}

	@Override
	public void focusLost(FocusEvent e) {
		
	}

	public Table getBoardTable() {
		return BoardTable;
	}
	public void setBoardTable(Table BoardTable) {
		this.BoardTable = BoardTable;
	}
	public JTable getFooter() {
		return footer;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public JTextField getTableSearchField() {
		return tableSearchField;
	}

	public void setTableSearchField(JTextField tableSearchField) {
		this.tableSearchField = tableSearchField;
	}

	public ArrayList<ArrayList<Object>> getBoardTableAdapter() {
		return boardTableAdapter;
	}

	public void setBoardTableAdapter(ArrayList<ArrayList<Object>> boardTableAdapter) {
		this.boardTableAdapter = boardTableAdapter;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public ArrayList<ArrayList<Object>> getFilteredData() {
		return filteredData;
	}

	public void setFilteredData(ArrayList<ArrayList<Object>> filteredData) {
		this.filteredData = filteredData;
	}
}
