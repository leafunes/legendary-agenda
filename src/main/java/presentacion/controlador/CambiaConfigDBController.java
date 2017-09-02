package presentacion.controlador;

import javax.swing.JOptionPane;

import dto.DBCredentialsDTO;
import modelo.GestorConexionService;
import presentacion.vista.CambiaConfigDBView;

public class CambiaConfigDBController {
	
	private static CambiaConfigDBController insntancia;
	
	private CambiaConfigDBView view;
	private GestorConexionService gestorConexionService = GestorConexionService.getService();
	
	private Binder<DBCredentialsDTO> binder;
	private DBCredentialsDTO credentials;
	
	public static CambiaConfigDBController getController(){
		if(insntancia == null)
			insntancia = new CambiaConfigDBController();
		return insntancia;
	}
	
	private CambiaConfigDBController() {
		
		view = new CambiaConfigDBView();
		binder = new Binder<>();
		
		binder.bind("user", view.getUsuarioTxt()::getText,
				s -> view.getUsuarioTxt().setText(s.toString()));
		binder.bind("ip", view.getIpTxt()::getText,
				s -> view.getIpTxt().setText(s.toString()));
		binder.bind("pass", () -> String.copyValueOf(view.getContraTxt().getPassword()),
				s -> view.getContraTxt().setText(s.toString()));
		binder.bind("port", view.getPuertoTxt()::getText,
				s -> view.getPuertoTxt().setText(s.toString()));
		
		view.getOkBtt().addActionListener(e -> saveCredentials());
		
	}
	
	public void setCredentials(){

		credentials = gestorConexionService.getCredentials();
		
		binder.setObjective(credentials);
		binder.fillFields();
		
	}
	
	private void saveCredentials(){
		
		binder.setObjective(credentials);
		binder.fillBean();
		
		try {
			gestorConexionService.saveCredentials(credentials);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view, "Error en las credenciales", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void showView(){
		view.setVisible(true);
	}
	
	public void closeView(){
		view.setVisible(false);
	}
	
	

}
