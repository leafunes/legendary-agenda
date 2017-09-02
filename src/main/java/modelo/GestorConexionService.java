package modelo;

import org.hibernate.HibernateException;

import dto.DBCredentialsDTO;
import persistencia.conexion.Conexion;
import persistencia.conexion.DBCredentialsEditor;
import utils.MessageBox;

public class GestorConexionService {
	
	private static GestorConexionService instancia;
	private DBCredentialsEditor editor = DBCredentialsEditor.getEditor();
	
	private MessageBox messageBox = MessageBox.getMessageBox();
	
	public static GestorConexionService getService(){
		if(instancia == null)
			instancia = new GestorConexionService();
		return instancia;
	}
	
	private GestorConexionService(){
		
	}

	public void saveCredentials(DBCredentialsDTO credentials) throws Exception {
		
		editor.setIP(credentials.getIp());
		editor.setPass(credentials.getPass());
		editor.setPuerto(credentials.getPort());
		editor.setUsuario(credentials.getUser());
		
		try {
			Conexion.resetConexion();
		} catch (HibernateException e) {
			throw new Exception();
		}
		
		messageBox.publish("newConexion");
		
	}
	
	public DBCredentialsDTO getCredentials(){
		
		DBCredentialsDTO toRet = new DBCredentialsDTO();
		
		toRet.setIp(editor.getIP());
		toRet.setPass(editor.getPass());
		toRet.setPort(editor.getPuerto());
		toRet.setUser(editor.getUsuario());
		
		return toRet;
	}

}
