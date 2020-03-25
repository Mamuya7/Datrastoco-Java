package model;

import java.sql.*;

import data.Draw;

public class DrawModel implements Models{

	private Draw draw;
	private Connection con;
	int result = 1;

	public DrawModel(Draw draw) {
		setDraw(draw);
	}

	public Runnable query() {
		return ()->{
			try {
				con = DriverManager.getConnection(url,user,password);
				con.setAutoCommit(false);
				
				PreparedStatement ps = con.prepareStatement(insert_drawings);
				ps.setString(1,draw.getDrawer());
				ps.setString(2,draw.getDetails());
				ps.setDouble(3,draw.getAmount());
				result *= ps.executeUpdate();
				
				ps = con.prepareStatement(insert_cash);
				ps.setString(1,"Drawings");
				ps.setDouble(2,0);
				ps.setDouble(3,draw.getAmount());
				result *= ps.executeUpdate();
				
				if(isInserted()) {
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
