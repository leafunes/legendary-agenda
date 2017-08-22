package modelo;

import dto.TipoContactoDTO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;
import persistencia.dao.mysql.PersonaDAOMySQL;
import persistencia.dao.mysql.TipoContactoDAOMySQL;

public class TipoContactoService extends BaseService<TipoContactoDTO>{

    private static TipoContactoService instancia;

    private TipoContactoDAO tipoContactoDao = TipoContactoDAOMySQL.getDAO();
    private PersonaDAO personaDao = PersonaDAOMySQL.getDAO();

    private TipoContactoService(){
        super.dao = tipoContactoDao;
    }

    public static TipoContactoService getService(){
        if(instancia == null)
            instancia = new TipoContactoService();

        return instancia;

    }

	public boolean existsPersonaWith(TipoContactoDTO contacto) {
		
		return !personaDao.getAllWith(contacto).isEmpty();
		
	}
}
