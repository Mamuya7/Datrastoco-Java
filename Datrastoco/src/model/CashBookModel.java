package model;

import java.sql.*;
import java.util.ArrayList;

import data.Cash;

public class CashBookModel implements Models{

	private Connection con;
	private Cash cash;
	
	public CashBookModel(Cash cash2) {
		this.cash = cash2;
	}

	@Override
	public void insert() {
		
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
