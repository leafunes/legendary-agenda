package persistencia.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.cfg.NotYetImplementedException;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;

public class TipoContactoDaoHibernate extends DaoHibernate<TipoContactoDTO> implements TipoContactoDAO{
	
	private static TipoContactoDAO instancia;
	
	public static TipoContactoDAO getDao(){
		if(instancia == null)
			instancia = new TipoContactoDaoHibernate();
		return instancia;
	}
	
	private TipoContactoDaoHibernate(){
		
	}

	@Override
	public TipoContactoDTO getTipoOf(PersonaDTO p) {
		throw new NotYetImplementedException();
	}

	@Override
	public List<TipoContactoDTO> readAll() {
		
		initTransaction();
		
		Criteria query = sesion.createCriteria(TipoContactoDTO.class);
				
		finishTransaction();
		
		return query.list();
	}

}
