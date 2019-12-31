package model;

import java.sql.*;
import java.util.ArrayList;
import data.ProductData;
import database_contract.Database.Stock;

public class Search implements Models{
	private ArrayList<ArrayList<Object>> table_data;
	private static Double total;
	private static Connection con = null;
	
	public static Runnable fetchStock(){
		return () ->{
			
			try {
				con = DriverManager.getConnection(url,user,password);
				Statement stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(fetch_stock);
				
				ArrayList<ProductData> product = new ArrayList<ProductData>();
				while(rs.next()) {
					ProductData productData = new ProductData(
							rs.getInt(Stock.PRODUCT_ID),
							rs.getString(Stock.PRODUCT_NAME),
							rs.getString(Stock.PRODUCT_SIZE),
							rs.getDouble(Stock.PRODUCT_QUANTITY),
							rs.getDouble(Stock.BUYING_PRICE),
							rs.getDouble(Stock.SELLING_PRICE),
							rs.getDouble(Stock.AMOUNT)
							);
					product.add(productData);
				}
				ProductData.setProduct(product);
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
	
	public Runnable fetch(String query) {
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

	public ArrayList<ArrayList<Object>> getTable_data() {
		return table_data;
	}

	public void setTable_data(ArrayList<ArrayList<Object>> table_data) {
		this.table_data = table_data;
	}

	public static Double getTotal() {
		return total;
	}

	public static void setTotal(Double total) {
		Search.total = total;
	}

	@Override
	public Runnable query() {
		return ()->{
			
		};
	}
}
