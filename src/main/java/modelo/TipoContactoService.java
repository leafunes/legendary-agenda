package modelo;

import dto.TipoContactoDTO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;
import persistencia.dao.jpa.PersonaDaoHibernate;
import persistencia.dao.jpa.TipoContactoDaoHibernate;

public class TipoContactoService extends BaseService<TipoContactoDTO>{

    private static TipoContactoService instancia;

    private TipoContactoDAO tipoContactoDao = TipoContactoDaoHibernate.getDao();
    private PersonaDAO personaDao= PersonaDaoHibernate.getDao();

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
