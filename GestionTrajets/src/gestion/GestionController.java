package gestion;

public class GestionController {

	private GestionTrajetsView _gestionView;
	private GestionModel _gestionModel;
	
	public GestionController() {

		_gestionModel = new GestionModel();
		_gestionView = new GestionTrajetsView(this);
	}
	
	public void start() {
		_gestionView.afficher(true);
	}
	
	public GestionTrajetsView get_robotView() {
		return _gestionView;
	}
	
	public GestionModel get_robotModel() {
		return _gestionModel;
	}
	
}
