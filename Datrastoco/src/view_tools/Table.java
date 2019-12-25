package view_tools;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Table extends JTable{

	private DefaultTableModel tablemodel = 
			new DefaultTableModel();
	public Table()
	{
		String[] values = {"Product Name","Size","Quantity","Amount"};
		createTableHeaders(values);
		setModel(tablemodel);
	}
	public Table(String[] heading) {
		createTableHeaders(heading);
		setModel(tablemodel);
	}
	
	public void createTableHeaders(String[] headers)
	{
		tablemodel.setColumnIdentifiers(headers);
	}
	public void addData(Object[] objects) {
		Integer row = this.getModel().getRowCount();
		int col = this.getModel().getColumnCount();
		if(col > objects.length) {
			Object[] newrowData = new String[col];
			for (int i = 0; i < col; i++) {
				if(i == 0) {
					newrowData[i] = String.valueOf(++row);
				}else {
					newrowData[i] = objects[i-1];
				}
			}
			((DefaultTableModel) this.getModel()).addRow(newrowData);
		}
	}
	public void fillTable(ArrayList<ArrayList<Object>> tabledata) {
		DefaultTableModel dtm = (DefaultTableModel)getModel();
		
		for(ArrayList<Object> row: tabledata) {
			dtm.addRow(row.toArray());
		}
		
		setTablemodel(dtm);
	}
	public DefaultTableModel getTablemodel() {
		return tablemodel;
	}

	public void setTablemodel(DefaultTableModel tablemodel) {
		this.tablemodel = tablemodel;
	}
}
