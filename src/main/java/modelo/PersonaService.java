package modelo;

import java.util.List;
import dto.PersonaDTO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.jpa.PersonaDaoJPA;


public class PersonaService extends BaseService<PersonaDTO>{
	
	private static PersonaService instancia;
	
	private PersonaDAO personaDao;// = PersonaDAOMySQL.getDAO();	
	
	private PersonaService(){
		personaDao = new PersonaDaoJPA();
		super.dao = personaDao;
		
	}
	
	public static PersonaService getService(){
		if(instancia == null)
			instancia = new PersonaService();
		return instancia;
	}

	
	public void actualizePersona(PersonaDTO oldPersona, PersonaDTO newPersona){
		personaDao.actualizePersona(oldPersona, newPersona);
	}
	
}
