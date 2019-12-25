package model;

import java.sql.*;

import data.Draw;

public class DrawModel implements Models{

	private Draw draw;
	private Connection con;
	int result = 0;

	public DrawModel(Draw draw) {
		setDraw(draw);
	}

	public void insert() {
		try {
			con = DriverManager.getConnection(url,user,password);
			
			PreparedStatement ps = con.prepareStatement(insert_drawings);
			ps.setString(1,draw.getDrawer());
			ps.setString(2,draw.getDetails());
			ps.setDouble(3,draw.getAmount());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isInserted() {
		if(result == 0)
			return false;
		return true;
	}
	public Draw getDraw() {
		return draw;
	}

	public void setDraw(Draw draw) {
		this.draw = draw;
	}

}
