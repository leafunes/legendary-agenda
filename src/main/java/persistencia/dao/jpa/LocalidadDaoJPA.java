package persistencia.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.cfg.NotYetImplementedException;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import persistencia.dao.interfaz.LocalidadDAO;

public class LocalidadDaoJPA extends DaoJPA<LocalidadDTO> implements LocalidadDAO{

	@Override
	public LocalidadDTO getLocalidadOf(PersonaDTO p) {
		throw new NotYetImplementedException();
	}

	@Override
	public List<LocalidadDTO> readAll() {
		
		List<LocalidadDTO> toReturn = new ArrayList<>();
		
		initTransaction();
		
		CriteriaQuery<LocalidadDTO> query = builder.createQuery(LocalidadDTO.class);
		
		query.from(LocalidadDTO.class);
		
		List<LocalidadDTO> resultados = entityManager.createQuery(query).getResultList();
		
		toReturn.addAll(resultados);
		
		finishTransaction();
		
		return toReturn;
	}

}
