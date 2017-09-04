package persistencia.dao.jpa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.cfg.NotYetImplementedException;

import dto.PersonaDTO;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.TipoContactoDAO;

public class TipoContactoDaoHibernate extends DaoHibernate<TipoContactoDTO> implements TipoContactoDAO{
	
	private static TipoContactoDAO instancia;
	
	public static TipoContactoDAO getDao(){
		if(instancia == null)
			instancia = new TipoContactoDaoHibernate();
		return instancia;
	}
	
	private TipoContactoDaoHibernate(){
		super();
	}

	@Override
	public TipoContactoDTO getTipoOf(PersonaDTO p) {
		throw new NotYetImplementedException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoContactoDTO> readAll() {
		
		initTransaction();
		
		Criteria query = sesion.createCriteria(TipoContactoDTO.class);
				
		finishTransaction();
		
		return query.list();
	}

}
