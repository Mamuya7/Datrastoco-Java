package model;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dashboard.Dashboard;
import data.Debtor;
import data.Product;

public class SalesModel implements Models{
	private static Connection con = null;
	private static ArrayList<ArrayList<Object>> data = new ArrayList<>();
	private Debtor debtor;
	private Product product;

	public SalesModel(Product product) {
		setProduct(product);
	}

	public SalesModel(Product product, Debtor debtor) {
		setDebtor(debtor);
		setProduct(product);
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

	public static ArrayList<ArrayList<Object>> getData() {
		return data;
	}

	@Override
	public void insert() {
		int id = Product.getInvoice_id();
		int quantity = product.getQuantity();
		Double price = product.getAmount();
		int stk_id = Product.getStock_id();
		int payment = product.getPaymentType();
		
		
		try {
			con = DriverManager.getConnection(url,user,password);
			con.setAutoCommit(false);
			
			PreparedStatement ps = con.prepareStatement(insert_sales);
			ps.setInt(1,id);
			ps.setInt(2,quantity);
			ps.setDouble(3, price);
			ps.setInt(4,payment);
			int effect = ps.executeUpdate();
			
			ps = con.prepareStatement(decrease_stock_quantity);
			ps.setInt(1,quantity);
			ps.setInt(2, stk_id);
			ps.setInt(3, quantity);
			effect *= ps.executeUpdate();
			
			if(product.getPaymentType() == 1) {
				ps = con.prepareStatement(insert_cash);
				
				ps.setString(1, "Sales");
				ps.setDouble(2, 0);
				ps.setDouble(3, price);
				
				effect *= ps.executeUpdate();
				
			}else if(product.getPaymentType() == 2) {
				ps = con.prepareStatement(insert_debtor);
				
				ps.setString(1, debtor.getName());
				ps.setString(2, debtor.getTransaction());
				ps.setDouble(3, price);
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
	}

	
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setDebtor(Debtor debtor) {
		this.debtor = debtor;
	}
}
