package model;

import java.sql.*;
import java.util.ArrayList;

public class Search implements Models{
	private static ArrayList<ArrayList<Object>> product_stock_list;
	private static ArrayList<ArrayList<Object>> table_data;
	private static Double total;
	private static Connection con = null;
	
	public static void fetchProduct_stock_list(){
		product_stock_list = new ArrayList<ArrayList<Object>>();
		
		try {
			con = DriverManager.getConnection(url,user,password);
			Statement stmnt = con.createStatement();
			ResultSet rs = stmnt.executeQuery(product_details);
			while(rs.next()) {
				ResultSetMetaData rsm = rs.getMetaData();
				int col = rsm.getColumnCount();
				ArrayList<Object> row = new ArrayList<Object>();
				for(int i = 1; i <= col; i++) {
					row.add(String.valueOf(rs.getObject(i)));
				}
				product_stock_list.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//setProduct_Stock_List(product_stock_list);
	}
	
	public static Runnable fetch(String query) {
		return ()->{
			try {
				con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				ResultSetMetaData metadata = rs.getMetaData();
				
				ArrayList<Object> row;
				table_data = new ArrayList<ArrayList<Object>>();
				int col = metadata.getColumnCount();
				int count = 0;
				while(rs.next()) {
					row = new ArrayList<Object>();
					row.add(++count);
					for(int i = 1; i <= col; i++) {
						row.add(rs.getObject(i));
					}
					table_data.add(row);
				}
				setTable_data(table_data);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		};
	}
	public static void fetchTotal(String query) {
			try {
				con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				total = 0.0;
				while(rs.next()) {
					total = total + rs.getDouble(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
	public static ArrayList<ArrayList<Object>> fetchTableData(String query) {
		ArrayList<ArrayList<Object>> data = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData metadata = rs.getMetaData();
			
			ArrayList<Object> row;
			data = new ArrayList<ArrayList<Object>>();
			int col = metadata.getColumnCount();
			int count = 0;
			while(rs.next()) {
				row = new ArrayList<Object>();
				row.add(++count);
				for(int i = 1; i <= col; i++) {
					row.add(rs.getObject(i));
				}
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}
	public static ArrayList<ArrayList<Object>> getProduct_Stock_List() {
		return product_stock_list;
	}

	public static void setProduct_Stock_List(ArrayList<ArrayList<Object>> list) {
		Search.product_stock_list = list;
	}

	public static ArrayList<ArrayList<Object>> getTable_data() {
		return table_data;
	}

	public static void setTable_data(ArrayList<ArrayList<Object>> table_data) {
		Search.table_data = table_data;
	}

	public static Double getTotal() {
		return total;
	}

	public static void setTotal(Double total) {
		Search.total = total;
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}
}
