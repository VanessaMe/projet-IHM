package projet_ihm;

import javax.swing.SwingUtilities;

public class Test {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Fenetre f = new Fenetre();
				f.setVisible(true);
			}
		});
	}

}
