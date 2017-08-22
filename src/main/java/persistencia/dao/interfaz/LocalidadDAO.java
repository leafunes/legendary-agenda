package persistencia.dao.interfaz;

import dto.LocalidadDTO;
import dto.PersonaDTO;

public interface LocalidadDAO extends DAO<LocalidadDTO>{
	
	public LocalidadDTO getLocalidadOf(PersonaDTO p);

}
