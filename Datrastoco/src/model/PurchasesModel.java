package model;

import java.sql.*;

import dashboard.Dashboard;
import data.ProductData;
import data.PurchaseData;

public class PurchasesModel implements Models{
	static Connection con;
	private int affected = 0;
	private PurchaseData purchasedata;
	
	public PurchasesModel(PurchaseData purchasedata) {
		this.purchasedata = purchasedata;
	}

	public PurchasesModel() {
		// TODO Auto-generated constructor stub
	}

	public int getAffected() {
		return affected;
	}
	public void setAffected(int affected) {
		this.affected = affected;
	}

	@Override
	public Runnable query() {
		return ()->{
			try {
				con = DriverManager.getConnection(url, user, password);
				con.setAutoCommit(false);
				
				PreparedStatement prep =  con.prepareStatement(insert_purchase);
				prep.setInt(1, purchasedata.getProdId());
				prep.setDouble(2, purchasedata.getQuantity());
				prep.setDouble(3, purchasedata.getAmount());
				affected += prep.executeUpdate();
				
				prep = con.prepareStatement(update_stock_on_purchase);
				prep.setDouble(1, purchasedata.getQuantity());
				prep.setDouble(2, purchasedata.getAmount());
				prep.setDouble(3, purchasedata.getQuantity());
				prep.setDouble(4, purchasedata.getAmount());
				prep.setInt(5, purchasedata.getProdId());
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
		};
	}
	
	public Runnable post() {
		return ()->{
			try {
				con = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = con.prepareStatement(fetch_purchases_account);
				ResultSet rs = ps.executeQuery();
				if(!(rs.next())) {
					ps = con.prepareStatement(insert_new_purchases_account_date);
					ps.setDouble(1, 0);
					ps.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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
