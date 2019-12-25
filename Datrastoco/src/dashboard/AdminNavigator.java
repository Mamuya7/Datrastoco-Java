package dashboard;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class AdminNavigator extends JMenuBar {
	private JMenu home = new JMenu("Home");
	
	public AdminNavigator() {
		super();
		add(home);
	}
}
