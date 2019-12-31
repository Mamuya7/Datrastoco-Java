package model;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dashboard.Dashboard;
import data.Debtor;
import data.ProductData;
import data.SalesData;

public class SalesModel implements Models{
	private static Connection con = null;
	private static ArrayList<ArrayList<Object>> data = new ArrayList<>();
	private Debtor debtor;
	private ProductData product;
	private SalesData salesdata;

	public SalesModel(Debtor debtor2) {
		setDebtor(debtor2);
	}

	public SalesModel(SalesData salesdata) {
		this.setSalesdata(salesdata);
	}

	public static Runnable loadSales() {
		return ()->{
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(url,user,password);
				Statement statmnt = con.createStatement();
				rs = statmnt.executeQuery(all_sales + Dashboard.getTheDate() + "%'");
				Integer count = 0;
				while(rs.next()) {
					ArrayList<Object> list = new ArrayList<>();
					list.add(++count);
					list.add(rs.getString("prod_name"));
					list.add(rs.getString("prod_size"));
					list.add(String.valueOf(rs.getInt("quantity")));
					list.add(rs.getString("price"));
					list.add(rs.getString("date"));
					data.add(list);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		};
	}
	public static void post(double amount) {
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
				
				ps = con.prepareStatement(decrease_stock_quantity);
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
				
				if(effect == 0) {
					JOptionPane.showMessageDialog(null, "Idadi ya bidhaa unayojaribu "
							+ "kuuza ni nyingi kuliko zilizopo");
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
		};
	}

	public static ArrayList<ArrayList<Object>> getData() {
		return data;
	}
	
	public void setProduct(ProductData product) {
		this.product = product;
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
}
