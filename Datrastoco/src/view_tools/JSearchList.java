package view_tools;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JSearchList extends JList<String> implements ListSelectionListener {

	public JSearchList() {
		setVisibleRowCount(3);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {

	}

}
