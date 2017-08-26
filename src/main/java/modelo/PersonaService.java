package modelo;

import java.util.List;
import dto.PersonaDTO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.jpa.PersonaDaoHibernate;


public class PersonaService extends BaseService<PersonaDTO>{
	
	private static PersonaService instancia;
	
	private PersonaDAO personaDao = PersonaDaoHibernate.getDao();	
	
	private PersonaService(){
		super.dao = personaDao;
		
	}
	
	public static PersonaService getService(){
		if(instancia == null)
			instancia = new PersonaService();
		return instancia;
	}

	
	public void actualizePersona(PersonaDTO oldPersona){
		
		personaDao.actualizePersona(oldPersona);
	}
	
	
}
