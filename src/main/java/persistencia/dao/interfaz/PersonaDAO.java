package persistencia.dao.interfaz;

import java.util.List;

import dto.PersonaDTO;

public interface PersonaDAO extends DAO<PersonaDTO>{
	
	public void actualizePersona(PersonaDTO oldPersona, PersonaDTO newPersona);

}
