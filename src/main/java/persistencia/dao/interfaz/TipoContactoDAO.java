package persistencia.dao.interfaz;

import dto.PersonaDTO;
import dto.TipoContactoDTO;

public interface TipoContactoDAO extends DAO<TipoContactoDTO> {

    public TipoContactoDTO getTipoOf(PersonaDTO p);
}
