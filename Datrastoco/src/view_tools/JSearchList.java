package view_tools;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JSearchList extends JList<String> implements ListSelectionListener{
	private JSearchField searchField = null;
	private  ArrayList<ArrayList<Object>> listAdapter = null;
	private ArrayList<Object> targetList = null;
	private DefaultListModel<String> dlm = null;
	private JSearchList refSearchList = null;
	private int refIndex = 1;
	
	public JSearchList() {
		dlm = new DefaultListModel<String>();
		
		targetList = new ArrayList<Object>();
		addListSelectionListener(this);
		
		setModel(dlm);
		setVisibleRowCount(3);
	}
	public JSearchList(JSearchField searchField) {
		this();
		setSearchField(searchField);
	}
	public JSearchList(JSearchField searchField,ArrayList<ArrayList<Object>> adapter) {
		this(searchField);
		setListAdapter(adapter);
	}
	public JSearchList(JSearchList refSearchList) {
		this();
		setRefSearchList(refSearchList);
	}
	private void updateRefSearchList(String word) {
		if(refSearchList == null) {
			return;
		}
		createReferenceTargetListAt(2, word);
		refSearchList.refreshListFromTargetList();
	}
	public void filterList(String text) {
		dlm = new DefaultListModel<String>();
		for(Object data: targetList) {
			if(data.toString().startsWith(text)) {
				dlm.addElement(data.toString());
			}
		}
		setModel(dlm);
	}
	public void refreshListFromTargetList() {
		dlm.removeAllElements();
		for(Object data:targetList) {
			dlm.addElement(data.toString());
		}
	}
	public void createReferenceTargetListAt(int index, String text) {
		ArrayList<Object> target = new ArrayList<Object>();
		if(listAdapter == null) {
			return;
		}
		for (ArrayList<Object> row:listAdapter) {
			if(((String) row.get(1)).equalsIgnoreCase(text)) {
				target.add(row.get(index));
			}
		}
		refSearchList.setTargetList(target);
	}
	public void getAdapterColumnAt(int index) {
		ArrayList<Object> value = new ArrayList<Object>();
		if(listAdapter == null) {
			return;
		}
		for (ArrayList<Object> row:listAdapter) {
			value.add(row.get(index));
		}
		setTargetList(value);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		searchField.setText(getSelectedValue());
		updateRefSearchList(searchField.getText());
	}
	
	public JSearchField getSearchField() {
		return searchField;
	}
	public void setSearchField(JSearchField searchField) {
		this.searchField = searchField;
	}
	public ArrayList<ArrayList<Object>> getListAdapter() {
		return listAdapter;
	}
	public void setListAdapter(ArrayList<ArrayList<Object>> listAdapter) {
		this.listAdapter = listAdapter;
		getAdapterColumnAt(1);
	}
	public ArrayList<Object> getTargetList() {
		return targetList;
	}
	public void setTargetList(ArrayList<Object> targetList) {
		this.targetList = targetList;
	}
	public JSearchList getRefSearchList() {
		return refSearchList;
	}
	public void setRefSearchList(JSearchList refSearchList) {
		this.refSearchList = refSearchList;
	}
	public int getRefIndex() {
		return refIndex;
	}
	public void setRefIndex(int refIndex) {
		this.refIndex = refIndex;
	}


}