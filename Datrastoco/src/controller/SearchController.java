package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import data.Product;
import model.Search;

public class SearchController {
	private static ArrayList<ArrayList<Object>> list = new ArrayList<ArrayList<Object>>();
	private static ArrayList<String>column = new ArrayList<>();
	
	public static DefaultListModel<String> filterListWith(String letters) {
		DefaultListModel<String> result = new DefaultListModel<String>();
		
		for(String data: column) {
			if(data.startsWith(letters.toUpperCase())) {
				result.addElement(data);
			}
		}
		return result;
	}
	public static DefaultListModel<String> getCurrentList(){
		DefaultListModel<String> currentList = new DefaultListModel<String>();
		for(String data: column) {
			currentList.addElement(data);
		}
		return currentList;
	}
	public static void fetchListOf(String listName) {
		if(listName == null) {
			setColumn(filterByColumn(1));
		}else {
			setColumn(filterByColumn(2,listName));
		}
	}
	public static void retrieveAll() {
		Search.fetchProduct_stock_list();
		setList(Search.getProduct_Stock_List());
	}
	private static ArrayList<String> filterByColumn(int index) {
		ArrayList<String> value = new ArrayList<String>();
		for (ArrayList<Object> row:getList()) {
			value.add((String) row.get(index));
		}
		return value;
	}
	private static ArrayList<String> filterByColumn(int index, String listName) {
		ArrayList<String> value = new ArrayList<String>();
		Product.products = new ArrayList<ArrayList<Object>>();
		for (ArrayList<Object> row:getList()) {
			if(((String) row.get(1)).equalsIgnoreCase(listName)) {
				value.add((String) row.get(index));
				Product.products.add(row);
			}
		}
		return value;
	}
	public static ArrayList<ArrayList<Object>> getList() {
		return list;
	}

	public static void setList(ArrayList<ArrayList<Object>> arrayList) {
		SearchController.list = arrayList;
	}
	public static ArrayList<String> getColumn() {
		return column;
	}
	public static void setColumn(ArrayList<String> column) {
		SearchController.column = column;
	}
	
	
}
