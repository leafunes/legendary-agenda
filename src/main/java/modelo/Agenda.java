package modelo;

import java.util.List;
import dto.PersonaDTO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.mysql.PersonaDAOImpl;


public class Agenda 
{
	private PersonaDAO personaDao;	
	
	public Agenda()
	{
		personaDao = new PersonaDAOImpl();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		personaDao.insert(nuevaPersona);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		personaDao.delete(persona_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return personaDao.readAll();		
	}
	
}
