package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.ProductData;

public class PriceList implements Models {
	private static Connection con = null;
	private static ArrayList<ArrayList<Object>> data = new ArrayList<>();
	private ProductData productdata;
	
	public PriceList(ProductData productdata) {
		this.productdata = productdata;
	}
	
	public PriceList(int invoice_id, double buyprice, double sellprice) {
	}

	public static void InvoiceList() {
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			Statement statmnt = con.createStatement();
			rs = statmnt.executeQuery(all_stock);
			while(rs.next()) {
				ArrayList<Object> list = new ArrayList<>();
				list.add(rs.getInt("id"));
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

	public static ArrayList<ArrayList<Object>> getData() {
		return data;
	}

	public static void setData(ArrayList<ArrayList<Object>> data) {
		PriceList.data = data;
	}

	@Override
	public Runnable query() {
		return ()->{
			try {
				con = DriverManager.getConnection(url,user,password);
				
				PreparedStatement ps = con.prepareStatement(update_stock_prices);
//				ps.setDouble(1,productdata.getBuyingPrice());
//				ps.setDouble(2,productdata.getSellingPrice());
				ps.setInt(3,productdata.getProdId());
				ps.executeUpdate();
				
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

	@Override
	public Runnable insert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Runnable update() {
		// TODO Auto-generated method stub
		return null;
	}
}
