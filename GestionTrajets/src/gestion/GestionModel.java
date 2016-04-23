package gestion;

import javax.swing.table.DefaultTableModel;

public class GestionModel {

	public void remplirComboBox(DefaultTableModel table){
		int nbRow = table.getRowCount();
		String[] tabDispo = new String[nbRow];
		int i = 0;
		
		for(i=0; i<nbRow; i++)
		{
			tabDispo[i] = (String)table.getValueAt(i, 0);
		}
		
	}
	
}
