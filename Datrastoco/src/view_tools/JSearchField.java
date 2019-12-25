package view_tools;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.SearchController;

public class JSearchField extends JTextField implements KeyListener, FocusListener,ListSelectionListener {
	private Character typeChar = null;
	private JList<String> listField = null;
	private JSearchField referenceField = null;
	private boolean reference = false;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	
	public JSearchField() {
		setFocusable(true);
		addFocusListener(this);
		addKeyListener(this);
	}
	
	public JSearchField(JList<String> listField) {
		this();
		listField.setModel(getListModel());
		listField.setVisibleRowCount(3);
		listField.addListSelectionListener(this);
		setListField(listField);
	}
	
	public JSearchField(JSearchField namefield, JList<String> sizesearch) {
		this(sizesearch);
		setReference(true);
		setReferenceField(namefield);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		String ref = null;
		SearchController.retrieveAll();
		if(hasReference()) {
			ref = getReferenceField().getText();
		}
		SearchController.fetchListOf(ref);
		setListModel(SearchController.getCurrentList());
		getListField().setModel(getListModel());
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		SearchController.setList(null);

	}

	@Override
	public void keyPressed(KeyEvent kvt) {
		setTypeChar(kvt.getKeyChar());
		if(kvt.getKeyCode() == KeyEvent.VK_ENTER) {
			setText(getListModel().firstElement());
		}
	}

	@Override
	public void keyReleased(KeyEvent kvt) {
		if(kvt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			setListModel(SearchController.filterListWith(getText()));
			getListField().setModel(getListModel());
		}
	}

	@Override
	public void keyTyped(KeyEvent kvt) {
		String letters = getText();
		letters += getTypeChar();
		setListModel(SearchController.filterListWith(letters));
		getListField().setModel(getListModel());
	}

	@Override
	public void valueChanged(ListSelectionEvent lvt) {
		@SuppressWarnings("unchecked")
		JList<String> list = (JList<String>) lvt.getSource();
		String selection = list.getSelectedValue();
		setText(selection);
	}

	public Character getTypeChar() {
		return typeChar;
	}

	public void setTypeChar(Character typeChar) {
		this.typeChar = typeChar;
	}

	public JList<String> getListField() {
		return listField;
	}

	public void setListField(JList<String> listField) {
		listField.setModel(getListModel());
		listField.setVisibleRowCount(3);
		listField.addListSelectionListener(this);
		this.listField = listField;
	}

	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel<String> listModel) {
		this.listModel = listModel;
	}

	public JSearchField getReferenceField() {
		return referenceField;
	}

	public void setReferenceField(JSearchField referenceField) {
		this.referenceField = referenceField;
	}

	public boolean hasReference() {
		return reference;
	}

	public void setReference(boolean reference) {
		this.reference = reference;
	}

}
