package persistencia.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.cfg.NotYetImplementedException;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.LocalidadDAO;

public class LocalidadDaoHibernate extends DaoHibernate<LocalidadDTO> implements LocalidadDAO{
	
	private static LocalidadDAO instancia;
	
	public static LocalidadDAO getDao(){
		if(instancia == null)
			instancia = new LocalidadDaoHibernate();
		return instancia;
	}
	
	private LocalidadDaoHibernate(){
		
	}
	
	@Override
	public LocalidadDTO getLocalidadOf(PersonaDTO p) {
		throw new NotYetImplementedException();
	}

	@Override
	public List<LocalidadDTO> readAll() {
		initTransaction();
		
		Criteria query = sesion.createCriteria(LocalidadDTO.class);
				
		finishTransaction();
		
		return query.list();
	}

}
