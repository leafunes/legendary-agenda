package main;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;

import modelo.PersonaService;
import presentacion.controlador.CambiaConfigDBController;
import presentacion.controlador.MainController;
import presentacion.vista.CambiaConfigDBView;
import presentacion.vista.MainView;
import utils.Utils;


public class Main 
{

	private static boolean credentialsWasClosed = false;
	
	public static void main(String[] args){
		
		try {
			if(Utils.getUtils().isFirstBoot()){
				JOptionPane.showMessageDialog(null, "Bienvenido al sistema de Agenda \n"
						+ "Al ser este su primer inicio, se le pedira que configure la base de datos"
						+ " y luego la aplicacion iniciará. \n"
						+ "Esto ultimo podria llevar unos minutos", "Primer inicio", JOptionPane.INFORMATION_MESSAGE);
			
				showChangeCredentialsView();
				
			}
			
			if(!credentialsWasClosed)
				showMainView();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error en las configuraciones"
					+ ". Contacte al administrador del sistema", "Error critico", JOptionPane.ERROR_MESSAGE);
		}catch(HibernateException e){
			showChangeCredentialsView();
			if(!credentialsWasClosed)
				showMainView();
		}
	}
	
	private static void showMainView(){
		MainView vista = MainView.getView();
		PersonaService modelo = PersonaService.getService();//TODO: cambiar (casi) todo a singleton o con spring
		MainController controlador = new MainController(vista, modelo);
		controlador.showView();
		
	}
	
	private static void showChangeCredentialsView(){
		CambiaConfigDBController controller = CambiaConfigDBController.getController();
		controller.setCredentials();
		controller.showView();
		
		credentialsWasClosed = controller.wasClosed();
		
		if(!credentialsWasClosed)
			Utils.getUtils().setFirstTimeFalse();
	}
}
