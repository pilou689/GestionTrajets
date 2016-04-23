package gestion;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import com.toedter.components.JSpinField;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class GestionTrajetsView extends JFrame{

	private JFrame frame;
	private JTable tabVehicules;
	private JTable tabTrajets;
	private JTable tableSaisie;

	/**
	 * Create the application.
	 */
	//public RobotView(RobotController robotController) {
	public GestionTrajetsView(GestionController gestioncontroller) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panelSaisie = new JPanel();
		tabbedPane.addTab("Saisie des trajets", null, panelSaisie, null);
		panelSaisie.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(6, 35, 150, 28);
		panelSaisie.add(dateChooser);
		
		JLabel lbDate = new JLabel("Date :");
		lbDate.setBounds(8, 15, 55, 16);
		panelSaisie.add(lbDate);
		
		JLabel lbHeure = new JLabel("Heure :");
		lbHeure.setBounds(8, 65, 55, 16);
		panelSaisie.add(lbHeure);
		
		JLabel lbMinutes = new JLabel("Minutes :");
		lbMinutes.setBounds(88, 65, 55, 16);
		panelSaisie.add(lbMinutes);
		
		JSpinField spinField_Heure = new JSpinField();
		spinField_Heure.setMinimum(0);
		spinField_Heure.setMaximum(23);
		spinField_Heure.setValue(8);
		spinField_Heure.setBounds(6, 85, 70, 24);
		panelSaisie.add(spinField_Heure);
		
		JSpinField spinField_Minute = new JSpinField();
		spinField_Minute.setMinimum(0);
		spinField_Minute.setMaximum(59);
		spinField_Minute.setBounds(86, 85, 70, 24);
		panelSaisie.add(spinField_Minute);
		
		JLabel lbTrajet = new JLabel("Trajet :");
		lbTrajet.setBounds(8, 115, 55, 16);
		panelSaisie.add(lbTrajet);
		
		JComboBox cbTrajet = new JComboBox();
		cbTrajet.setBounds(6, 135, 150, 28);
		panelSaisie.add(cbTrajet);
		
		JLabel lbVehicule = new JLabel("Vehicule :");
		lbVehicule.setBounds(8, 170, 55, 16);
		panelSaisie.add(lbVehicule);
		
		JComboBox cbVehicule = new JComboBox();
		cbVehicule.setBounds(6, 190, 150, 28);
		panelSaisie.add(cbVehicule);
		
		JPanel panelDerTrajets = new JPanel();
		panelDerTrajets.setBorder(new TitledBorder(null, "Derniers Trajets", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDerTrajets.setBounds(190, 20, 288, 206);
		panelSaisie.add(panelDerTrajets);
		panelDerTrajets.setLayout(null);
		
		JScrollPane scrollPaneDT = new JScrollPane();
		scrollPaneDT.setBounds(6, 26, 276, 161);
		panelDerTrajets.add(scrollPaneDT);
		
		tableSaisie = new JTable();
		tableSaisie.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Dates", "Vehicules", "Trajets", "Distances"
			}
		));
		scrollPaneDT.setViewportView(tableSaisie);
		
		JButton btnAjouter_Saisie = new JButton("Ajouter");
		btnAjouter_Saisie.setBounds(35, 230, 90, 28);
		panelSaisie.add(btnAjouter_Saisie);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBounds(388, 230, 90, 28);
		panelSaisie.add(btnEnregistrer);
		
		JButton btnExporter = new JButton("Exporter");
		btnExporter.setBounds(258, 230, 90, 28);
		panelSaisie.add(btnExporter);
		
		JPanel panelConf = new JPanel();
		tabbedPane.addTab("Configuration", null, panelConf, null);
		panelConf.setLayout(null);
		
		JPanel panelVehicules = new JPanel();
		panelVehicules.setBorder(new TitledBorder(null, "Vehicules", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelVehicules.setBounds(10, 10, 235, 220);
		panelConf.add(panelVehicules);
		panelVehicules.setLayout(null);
		
		JScrollPane scrollPaneV = new JScrollPane();
		scrollPaneV.setBounds(6, 24, 220, 170);
		panelVehicules.add(scrollPaneV);
		
		tabVehicules = new JTable();
		tabVehicules.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nissan", "Micra"},
				{"Jeep", "Renegade"},
				{"Peugeot", "207"},
				{"MotoGuzzi", "Breva850"},
			},
			new String[] {
				"Marque", "Model"
			}
		));
		scrollPaneV.setViewportView(tabVehicules);
		
		JPanel panelTrajets = new JPanel();
		panelTrajets.setBorder(new TitledBorder(null, "Trajets", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTrajets.setBounds(245, 10, 235, 220);
		panelConf.add(panelTrajets);
		panelTrajets.setLayout(null);
		
		JScrollPane scrollPaneT = new JScrollPane();
		scrollPaneT.setBounds(6, 24, 220, 170);
		panelTrajets.add(scrollPaneT);
		
		tabTrajets = new JTable();
		tabTrajets.setModel(new DefaultTableModel(
			new Object[][] {
				{"Cauderan", 76},
				{"Cezac", 108},
				{"Poste Libourne", 18},
				{"Biscarosse", 214},
				{"Laubie Libourne", 14},
			},
			new String[] {
				"Destination", "Distance"
			}
		)); 
		scrollPaneT.setViewportView(tabTrajets);
		
		JButton btnAjouterConf = new JButton("Ajouter");
		btnAjouterConf.setBounds(40, 230, 90, 28);
		panelConf.add(btnAjouterConf);
		
		JButton btnModifierConf = new JButton("Modifier");
		btnModifierConf.setBounds(200, 230, 90, 28);
		panelConf.add(btnModifierConf);
		
		JButton btnSupprimerConf = new JButton("Supprimer");
		btnSupprimerConf.setBounds(360, 230, 90, 28);
		panelConf.add(btnSupprimerConf);
		
	}
	
	public void afficher(boolean visible)
    {
        this.frame.setVisible(visible);
    }
	
	public JTable getTabVehicules()
	{
		return tabVehicules;
	}
	
	public JTable getTabTrajets()
	{
		return tabTrajets;
	}
}
