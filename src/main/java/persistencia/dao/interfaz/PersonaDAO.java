package persistencia.dao.interfaz;

import java.util.List;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;

public interface PersonaDAO extends DAO<PersonaDTO>{
	
	public void actualizePersona(PersonaDTO oldPersona, PersonaDTO newPersona);

	public List<PersonaDTO> getAllWith(TipoContactoDTO contacto);

	List<PersonaDTO> getAllWith(LocalidadDTO localidad);

}
