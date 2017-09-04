package persistencia.dao.jpa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.cfg.NotYetImplementedException;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import persistencia.dao.interfaz.LocalidadDAO;

public class LocalidadDaoHibernate extends DaoHibernate<LocalidadDTO> implements LocalidadDAO{
	
	private static LocalidadDAO instancia;
	
	public static LocalidadDAO getDao(){
		if(instancia == null)
			instancia = new LocalidadDaoHibernate();
		return instancia;
	}
	
	private LocalidadDaoHibernate(){
		super();
	}
	
	@Override
	public LocalidadDTO getLocalidadOf(PersonaDTO p) {
		throw new NotYetImplementedException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LocalidadDTO> readAll() {
		initTransaction();
		
		Criteria query = sesion.createCriteria(LocalidadDTO.class);
				
		finishTransaction();
		
		return query.list();
	}

}
