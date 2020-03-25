package model;

import java.sql.*;
import java.util.ArrayList;

import data.ProductData;
import database_contract.Database;

public class StockModel implements Models {
	private static Connection con = null;
	private static ArrayList<ArrayList<Object>> data = new ArrayList<>();
	private ProductData productdata;
	private boolean inserted;
	
	public StockModel() {
		
	}
	public StockModel(ProductData productdata) {
		this.productdata = productdata;
	}	
	public static void allStockDetails() {
		data = new ArrayList<ArrayList<Object>>();
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			Statement statmnt = con.createStatement();
			rs = statmnt.executeQuery(invoice_list);
			Integer count = 0;
			while(rs.next()) {
				ArrayList<Object> list = new ArrayList<>();
				list.add(++count);
				list.add(rs.getString("prod_name"));
				list.add(Integer.valueOf(rs.getInt("prod_quantity")));
				list.add(rs.getDouble("buying_price"));
				data.add(list);
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
	public static Runnable fetchLowStock(int level) {
		return ()->{
			ResultSet rs = null;
			data = new ArrayList<ArrayList<Object>>();
			try {
				con = DriverManager.getConnection(url,user,password);
				PreparedStatement statmnt = con.prepareStatement(fetch_lowstock_list);
				statmnt.setInt(1, level);
				rs = statmnt.executeQuery();
				int count = 0;
				while(rs.next()) {
					ArrayList<Object> list = new ArrayList<>();
					list.add(String.valueOf(++count));
					list.add(rs.getString("prod_name"));
					list.add(String.valueOf(rs.getInt("prod_quantity")));
					list.add(rs.getDouble("buying_price"));
					data.add(list);
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
		};
	}
	public static ArrayList<ArrayList<Object>> getData() {
		return data;
	}
	@Override
	public Runnable query() {
		return ()->{
			String query = "select * from stock";
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(url,user,password);
				Statement statmnt = con.createStatement();
				rs = statmnt.executeQuery(query);
				Integer count = 0;
				while(rs.next()) {
					ArrayList<Object> list = new ArrayList<>();
					list.add(++count);
					list.add(rs.getString(Database.Stock.PRODUCT_NAME));
					list.add(rs.getString(Database.Stock.PRODUCT_SIZE));
					list.add(rs.getString(Database.Stock.PRODUCT_CATEGORY));
					list.add(rs.getString(Database.Stock.PRODUCT_COMPANY));
					list.add(String.valueOf(rs.getDouble(Database.Stock.PRODUCT_QUANTITY)));
					list.add(String.valueOf(rs.getDouble(Database.Stock.BUYING_PRICE)));
					list.add(String.valueOf(rs.getDouble(Database.Stock.SELLING_PRICE)));
					list.add(String.valueOf(rs.getDouble(Database.Stock.AMOUNT)));
					data.add(list);
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
		};
		
	}
	public boolean isInserted() {
		return inserted;
	}
	public void setInserted(boolean inserted) {
		this.inserted = inserted;
	}
	@Override
	public Runnable insert() {
		return ()->{
			try {
				con = DriverManager.getConnection(url,user,password);
				con.setAutoCommit(false);
				
				PreparedStatement ps = con.prepareStatement(insert_new_stock);
				ps.setString(1, productdata.getProdName());
				ps.setString(2, productdata.getProdSize());
				ps.setDouble(3, productdata.getQuantity());
				ps.setString(4, productdata.getProdCategory());
				ps.setString(5, productdata.getProdCompany());
				
				int effect = ps.executeUpdate();
				
				if(effect == 0) {
					setInserted(false);
					con.rollback();
				}else {
					con.commit();
					setInserted(true);
				}
				
			} catch (SQLException e) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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
	@Override
	public Runnable update() {
		// TODO Auto-generated method stub
		return null;
	}

}
