package modelo;


import dto.LocalidadDTO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.mysql.LocalidadDAOMySQL;

public class LocalidadService extends BaseService<LocalidadDTO>{
	
	private static LocalidadService instancia;
	
	private LocalidadDAO localidadDao = LocalidadDAOMySQL.getDAO();
	
	private LocalidadService(){
		super.dao = localidadDao;
	}
	
	public static LocalidadService getService(){
		if(instancia == null)
			instancia = new LocalidadService();
		
		return instancia;
		
	}
	

}
