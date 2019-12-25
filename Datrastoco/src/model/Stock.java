package model;

import java.sql.*;
import java.util.ArrayList;

import data.Product;

public class Stock implements Models {
	private static Connection con = null;
	private static ArrayList<ArrayList<Object>> data = new ArrayList<>();
	
	public Stock() {
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
				list.add(rs.getString("prod_name"));
				list.add(rs.getString("prod_size"));
				list.add(String.valueOf(rs.getInt("prod_quantity")));
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
	public Stock(String name,String size,int quantity) {
		String query = "insert into stock (prod_name,prod_size,prod_quantity) values (?,?,?)";
		try {
			con = DriverManager.getConnection(url,user,password);
			con.setAutoCommit(false);
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, size);
			ps.setInt(3, quantity);
			ps.executeUpdate();
			ps = con.prepareStatement(new_invoice);
			int effect = ps.executeUpdate();
			
			if(effect == 0) {
				con.rollback();
			}else {
				con.commit();
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
	public void insert() {
		// TODO Auto-generated method stub
		
	}

}
