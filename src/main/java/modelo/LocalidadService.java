package modelo;


import dto.LocalidadDTO;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.jpa.LocalidadDaoJPA;
import persistencia.dao.jpa.PersonaDaoJPA;

public class LocalidadService extends BaseService<LocalidadDTO>{
	
	private static LocalidadService instancia;
	
	private LocalidadDAO localidadDao;// = LocalidadDAOMySQL.getDAO();
	private PersonaDAO personaDao;// = PersonaDAOMySQL.getDAO();
	
	private LocalidadService(){
		localidadDao = new LocalidadDaoJPA();
		personaDao = new PersonaDaoJPA();
		super.dao = localidadDao;
	}
	
	public static LocalidadService getService(){
		if(instancia == null)
			instancia = new LocalidadService();
		
		return instancia;
		
	}
	
	public boolean existsPersonaWith(LocalidadDTO localidad) {
		
		return !personaDao.getAllWith(localidad).isEmpty();
		
	}

}
