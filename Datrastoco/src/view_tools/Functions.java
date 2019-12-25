package view_tools;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Functions {
	public ArrayList<ArrayList<Object>> getTableData(JTable table){
		ArrayList<ArrayList<Object>> table_data = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> row_data;
		int cols = table.getColumnCount();
		int rows = table.getRowCount();
		
		for(int i = 0; i < rows; i++) {
			row_data = new ArrayList<Object>();
			for(int j = 0; j < cols; j++) {
				row_data.add(table.getModel().getValueAt(i, j));
			}
			table_data.add(row_data);
		}
		return table_data ;
	}
	
	public static DefaultTableModel clearTable(JTable table) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		return dtm;
	}
}
