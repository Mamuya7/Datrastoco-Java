package view_tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DateSelector extends JPanel implements ActionListener{
	private JComboBox<Integer> date;
	private JComboBox<Integer> month;
	private JComboBox<Integer> year;
	
	private String dt;
	private String mnth;
	private String yr;
	private String fullDate;
	
	public DateSelector() {
		setDate(new JComboBox<>());
		setMonth(new JComboBox<>());
		setYear(new JComboBox<>());
		
		date.addActionListener(this);
		month.addActionListener(this);
		year.addActionListener(this);
		
		for(int x = 0; x <= 31; x++) {
			date.addItem(x);
			if(x <= 12) {
				month.addItem(x);
			}
			if(x == 0) {
				year.addItem(x);
			}else if(x >= 19) {
				year.addItem(x + 2000);
			}
		}
		
		GroupLayout grp = new GroupLayout(this);
		setLayout(grp);
		
		grp.setVerticalGroup(
				grp.createSequentialGroup()
				.addGroup(
						grp.createParallelGroup()
						.addComponent(date)
						.addComponent(month)
						.addComponent(year))
				);
		grp.setHorizontalGroup(
				grp.createSequentialGroup()
				.addGroup(
						grp.createParallelGroup()
						.addComponent(date)
						)
				.addGroup(
						grp.createParallelGroup()
						.addComponent(month)
						)
				.addGroup(
						grp.createParallelGroup()
						.addComponent(year)
						)
				);
	}

	@Override
	public void actionPerformed(ActionEvent avt) {
		if(avt.getSource() == getDate()) {
			this.dt = getDate().getSelectedItem().toString();
		}else if(avt.getSource() == getMonth()) {
			this.mnth = getMonth().getSelectedItem().toString();
		}else {
			this.yr = getYear().getSelectedItem().toString();
		}

		setFullDate(yr + "-" + mnth + "-" + dt);
	}

	public JComboBox<Integer> getDate() {
		return date;
	}

	public void setDate(JComboBox<Integer> date) {
		this.date = date;
	}

	public JComboBox<Integer> getMonth() {
		return month;
	}

	public void setMonth(JComboBox<Integer> month) {
		this.month = month;
	}

	public JComboBox<Integer> getYear() {
		return year;
	}

	public void setYear(JComboBox<Integer> year) {
		this.year = year;
	}

	public String getFullDate() {
		if((dt.equals("0")) || (mnth.equals("0")) || (yr.equals("0")))
			setFullDate(null);
		return fullDate;
	}

	public void setFullDate(String fullDate) {
		this.fullDate = fullDate;
	}

	public void clearDate() {
		getDate().setSelectedIndex(0);
		getMonth().setSelectedIndex(0);
		getYear().setSelectedIndex(0);
	}
}
