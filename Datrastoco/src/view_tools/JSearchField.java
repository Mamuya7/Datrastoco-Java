package view_tools;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;

public class JSearchField extends JTextField implements KeyListener,FocusListener {
	private JSearchList searchList;
	public JSearchField() {
		super(20);
		addKeyListener(this);
		addFocusListener(this);
	}
	public JSearchField(JSearchList searchList) {
		this();
		setSearchList(searchList);
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent kvt) {
		if(kvt.getKeyCode() == KeyEvent.VK_ENTER) {
			DefaultListModel<String> dlm = (DefaultListModel<String>) searchList.getModel();
			setText(dlm.firstElement());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		searchList.filterList(getText().toUpperCase());
	}
	@Override
	public void focusGained(FocusEvent e) {
		searchList.refreshListFromTargetList();
	}
	@Override
	public void focusLost(FocusEvent e) {
		
	}
	public JSearchList getSearchList() {
		return searchList;
	}
	public void setSearchList(JSearchList searchList) {
		this.searchList = searchList;
	}

}