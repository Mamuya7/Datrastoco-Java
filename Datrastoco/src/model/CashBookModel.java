package model;

import java.sql.*;
import java.util.ArrayList;

import data.CashTransaction;

public class CashBookModel implements Models{

	private Connection con;
	private CashTransaction cash;
	
	public CashBookModel(CashTransaction cash) {
		this.cash = cash;
	}

	@Override
	public Runnable query() {
		return ()->{
			try {
				con = DriverManager.getConnection(url,user,password);
				PreparedStatement ps = con.prepareStatement(insert_cash);
				ps.setString(1, cash.getTransaction() + " ("+ cash.getAssociate() +")");
				ps.setDouble(2, cash.getDebit());
				ps.setDouble(3,cash.getCredit());
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

	public ArrayList<ArrayList<Object>> fetch() {
		ArrayList<ArrayList<Object>> adapter = new ArrayList<ArrayList<Object>>();
		try {
			con = DriverManager.getConnection(url,user,password);
			PreparedStatement ps = con.prepareStatement(fetch_cashbook_records);
			ps.setString(1,cash.getDate());
			
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				ArrayList<Object> row = new ArrayList<Object>();
						row.add(result.getString("transaction"));
						row.add(result.getDouble("credit"));
						row.add(result.getDouble("debit"));
						System.out.println(row);
				adapter.add(row);
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
		
		return adapter;
	}

}
