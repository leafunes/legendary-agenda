package presentacion.controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
	
	private boolean wasClosed = false;
	
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
		
		view.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				wasClosed = true;
				super.windowClosing(e);
			}
		});
		
	}
	
	public void setCredentials(){

		credentials = gestorConexionService.getCredentials();
		
		binder.setObjective(credentials);
		binder.fillFields();
		
	}
	
	private void saveCredentials(){
		if(isFieldsOk()){
			binder.setObjective(credentials);
			binder.fillBean();
			
			try {
				gestorConexionService.saveCredentials(credentials);
				closeView();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(view, "Error en las credenciales", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	private boolean isFieldsOk(){
		
		boolean emptys = view.getIpTxt().getText().isEmpty();
		emptys |= view.getUsuarioTxt().getText().isEmpty();
		emptys |= view.getPuertoTxt().getText().isEmpty();
		
		if(emptys){
			
			JOptionPane.showMessageDialog(view, "Faltan rellenar campos", "Error", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		if(!view.getIpTxt().getText().matches("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})")){
			//verifica si es un ip valido
			JOptionPane.showMessageDialog(view, "IP invalido", "Error", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		if(!view.getPuertoTxt().getText().matches("(\\d)*")){
			//verifica si es un ip valido
			JOptionPane.showMessageDialog(view, "Puerto invalido", "Error", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		return true;
	}
	
	public boolean wasClosed(){
		return wasClosed;
	}
	
	public void showView(){
		view.setVisible(true);
	}
	
	public void closeView(){
		view.setVisible(false);
	}
	
	

}
