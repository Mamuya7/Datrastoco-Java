package model;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dashboard.Dashboard;
import data.Debtor;
import data.SalesData;
import database_contract.Database;

public class SalesModel implements Models{
	private static Connection con = null;
	private static ArrayList<ArrayList<Object>> data = new ArrayList<>();
	private Debtor debtor;
	private SalesData salesdata;
	private int effect = 0;

	public SalesModel(Debtor debtor2) {
		setDebtor(debtor2);
		setSalesdata(debtor2.getSalesdata());
	}

	public SalesModel(SalesData salesdata) {
		this.setSalesdata(salesdata);
	}

	public SalesModel() {
		// TODO Auto-generated constructor stub
	}

	public static Runnable loadSales() {
		return ()->{
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(url,user,password);
				Statement statmnt = con.createStatement();
				rs = statmnt.executeQuery(fetch_sales);
				Integer count = 0;System.out.println(fetch_sales);
				while(rs.next()) {
					ArrayList<Object> list = new ArrayList<>();
					list.add(++count);
					list.add(rs.getString(Database.Stock.PRODUCT_NAME));
					list.add(rs.getString(Database.Stock.PRODUCT_SIZE));
					list.add(String.valueOf(rs.getDouble(Database.SalesLedger.QUANTITY)));
					list.add(String.valueOf(rs.getDouble(Database.SalesLedger.AMOUNT)));
					list.add(rs.getString(Database.SalesLedger.DATE));
					data.add(list);System.out.println(list + "here2");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		};
	}
	public static void poster(double amount) {
		try {
			con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement(insert_cash);
			ps.setString(1, "Sales");
			ps.setDouble(2, amount);
			ps.setDouble(3, 0);
			int x = ps.executeUpdate();
			if(x > 0) {
				JOptionPane.showMessageDialog(null, "Record " + x + " za hela kamili zimerekodiwa");
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

	@Override
	public Runnable query() {
		return ()->{
			try {
				con = DriverManager.getConnection(url,user,password);
				con.setAutoCommit(false);
				
				PreparedStatement ps = con.prepareStatement(insert_sales);
				ps.setInt(1,salesdata.getProdId());
				ps.setDouble(2,salesdata.getQuantity());
				ps.setDouble(3, salesdata.getAmount());
				ps.setInt(4,salesdata.getPayment());
				int effect = ps.executeUpdate();
				
				ps = con.prepareStatement(update_stock_on_sale);
				ps.setDouble(1,salesdata.getQuantity());
				ps.setInt(2, salesdata.getProdId());
				ps.setDouble(3, salesdata.getQuantity());
				effect *= ps.executeUpdate();
				
				if(salesdata.getPayment() == 2) {
					ps = con.prepareStatement(insert_debtor);
					
					ps.setString(1, debtor.getName());
					ps.setString(2, debtor.getTransaction());
					ps.setDouble(3, debtor.getSalesdata().getAmount());
					ps.setDouble(4,0);
					
					effect *= ps.executeUpdate();
				}
				setEffect(effect);
				if(effect == 0) {
					con.rollback();
				}else {
					con.commit();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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
				PreparedStatement ps = con.prepareStatement(fetch_sales_account);
				ResultSet rs = ps.executeQuery();
				if(!(rs.next())) {
					ps = con.prepareStatement(insert_new_sales_account_date);
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
	public static ArrayList<ArrayList<Object>> getData() {
		return data;
	}
	
	public void setDebtor(Debtor debtor) {
		this.debtor = debtor;
	}

	public SalesData getSalesdata() {
		return salesdata;
	}

	public void setSalesdata(SalesData salesdata) {
		this.salesdata = salesdata;
	}

	public int getEffect() {
		return effect;
	}

	public void setEffect(int effect) {
		this.effect = effect;
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
