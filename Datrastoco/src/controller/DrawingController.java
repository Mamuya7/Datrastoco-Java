package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import data.Draw;
import model.DrawModel;

public class DrawingController implements ActionListener {

	public DrawingController(JButton button) {
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Draw draw = new Draw();
		DrawModel drawmodel = new DrawModel(draw);
		drawmodel.insert();
		
		if(drawmodel.isInserted()) {
			JOptionPane.showMessageDialog(null, "Uchukuzi wa hela "
					+ "kwa matumizi binafsi umehifadhiwa kikamilifu");
			draw.clearFields();
		}
	}
}
