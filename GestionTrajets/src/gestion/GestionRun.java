package gestion;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UIManager.*;

public class GestionRun {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// apply the theme Nimbus for the window view
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionController gc = new GestionController();
					gc.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
