package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PriceList implements Models {
	private static Connection con = null;
	private static ArrayList<ArrayList<Object>> data = new ArrayList<>();
	
	public PriceList() {
		
	}
	
	public PriceList(int invoice_id, double buyprice, double sellprice) {
		try {
			con = DriverManager.getConnection(url,user,password);
			
			PreparedStatement ps = con.prepareStatement(update_invoice);
			ps.setDouble(1,buyprice);
			ps.setDouble(2,sellprice);
			ps.setInt(3,invoice_id);
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
			
		};
	}
}
