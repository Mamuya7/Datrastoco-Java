package model;

import java.sql.*;

import data.Product;

public class PurchasesModel implements Models{
	static Connection con;
	private static int affected = 0;
	public PurchasesModel(Product product) {
		try {
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			
			PreparedStatement prep =  con.prepareStatement(insert_purchase);
			prep.setInt(1, Product.getInvoice_id());
			prep.setInt(2, product.getQuantity());
			prep.setDouble(3, product.getAmount());
			affected += prep.executeUpdate();
			
			prep = con.prepareStatement(increase_stock_quantity);
			prep.setInt(1, product.getQuantity());
			prep.setInt(2, Product.getStock_id());
			affected *= prep.executeUpdate();
			
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
				affected = 0;
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

	public static int getAffected() {
		return affected;
	}
	public static void setAffected(int affected) {
		PurchasesModel.affected = affected;
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}
}
