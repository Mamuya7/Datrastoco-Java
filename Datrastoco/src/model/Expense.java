package model;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.ExpenseData;

public class Expense implements Models {
	Connection con;
	
	public Expense() {
		String date = ExpenseData.getDate();
		String transaction = ExpenseData.getTransaction(); 
		String details = ExpenseData.getDetails();
		double amount = ExpenseData.getAmount();
		try {
			con = DriverManager.getConnection(url,user,password);
			PreparedStatement prep = con.prepareStatement(insert_expense);
			prep.setString(1,date);
			prep.setString(2, transaction);
			prep.setString(3, details);
			prep.setDouble(4, amount);
			int result = prep.executeUpdate();
			
			ExpenseData.setResult(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<ArrayList<Object>> getExpenses(){
		ArrayList<ArrayList<Object>> expenses = Search.fetchTableData(expense_data);
		return expenses;
	}

	@Override
	public Runnable query() {
		return ()->{
			
		};
	}

}
