package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import dashboard.Utility;
import data.ProductData;
import model.Models;
import model.Search;

public class SearchController {
	private static ArrayList<ArrayList<Object>> list = new ArrayList<ArrayList<Object>>();
	private static ArrayList<Object> column = new ArrayList<>();
	
	public static DefaultListModel<String> filterListWith(String letters) {
		DefaultListModel<String> result = new DefaultListModel<String>();
		
		for(Object data: column) {
			if(data.toString().startsWith(letters.toUpperCase())) {
				result.addElement((String) data);
			}
		}
		return result;
	}
	public static DefaultListModel<String> getCurrentList(){
		DefaultListModel<String> currentList = new DefaultListModel<String>();
		for(Object data: column) {
			currentList.addElement((String) data);
		}
		return currentList;
	}
	public static ArrayList<ArrayList<Object>> fetchProductAdapter() {
		Search search = new Search();
		try {
			Thread thread = new Thread(search.fetch(Models.product_names));
			thread.start();
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return search.getTable_data();
	}
	public static ArrayList<ArrayList<Object>> fetchUsersAdapter() {
		Search search = new Search();
		try {
			Thread thread = new Thread(search.fetch(Models.user_names));
			thread.start();
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return search.getTable_data();
	}
	public static void loadProductsData() {
		Utility.queryDatabase(Search.fetchStock());
	}
	public static ArrayList<ArrayList<Object>> getList() {
		return list;
	}

	public static void setList(ArrayList<ArrayList<Object>> arrayList) {
		SearchController.list = arrayList;
	}
	public static ArrayList<Object> getColumn() {
		return column;
	}
	public static void setColumn(ArrayList<Object> arrayList) {
		SearchController.column = arrayList;
	}
	
	
}
