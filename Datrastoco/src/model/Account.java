package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Account implements Models {
	private static Connection con = null;
	
	public static void postInto(String table, double amount) {
		String dt = JOptionPane.showInputDialog("Enter Date in form of YYYY-MM-DD");
		try {
			con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement(insert_into_+table+account);
			ps.setDate(1, Date.valueOf(dt));
			ps.setDouble(2, amount);
			ps.executeUpdate();
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
	}

	@Override
	public Runnable query() {
		return ()->{
			
		};
	}
}
