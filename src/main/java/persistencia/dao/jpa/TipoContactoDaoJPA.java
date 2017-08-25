package persistencia.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.cfg.NotYetImplementedException;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.TipoContactoDAO;

public class TipoContactoDaoJPA extends DaoJPA<TipoContactoDTO> implements TipoContactoDAO{

	@Override
	public TipoContactoDTO getTipoOf(PersonaDTO p) {
		throw new NotYetImplementedException();
	}

	@Override
	public List<TipoContactoDTO> readAll() {
		
		List<TipoContactoDTO> toReturn = new ArrayList<>();
		
		initTransaction();
		
		CriteriaQuery<TipoContactoDTO> query = builder.createQuery(TipoContactoDTO.class);
		
		query.from(TipoContactoDTO.class);
		
		List<TipoContactoDTO> resultados = entityManager.createQuery(query).getResultList();
		
		toReturn.addAll(resultados);
		
		finishTransaction();
		
		return toReturn;
	}

}
