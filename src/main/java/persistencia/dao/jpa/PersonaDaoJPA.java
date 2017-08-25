package persistencia.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.cfg.NotYetImplementedException;

import dto.DomicilioDTO;
import dto.DomicilioDTO_;
import dto.LocalidadDTO;
import dto.LocalidadDTO_;
import dto.PersonaDTO;
import dto.PersonaDTO_;
import dto.TipoContactoDTO;
import dto.TipoContactoDTO_;
import persistencia.dao.interfaz.PersonaDAO;

public class PersonaDaoJPA extends DaoJPA<PersonaDTO> implements PersonaDAO{

	@Override
	public void actualizePersona(PersonaDTO oldPersona, PersonaDTO newPersona) {
		initTransaction();
		
		entityManager.persist(newPersona);
		
		finishTransaction();
		
	}

	@Override
	public List<PersonaDTO> getAllWith(TipoContactoDTO contacto) {

		//1. Creamos la query
		CriteriaQuery<PersonaDTO> query = builder.createQuery(PersonaDTO.class);
		
		//2. Creamos el root
		Root<PersonaDTO> fromPersona = query.from(PersonaDTO.class);
		
		//3. Creamos el join
		Join<PersonaDTO, TipoContactoDTO> joinPerCon = fromPersona.join(PersonaDTO_.tipo);
		
		//4. Creamos las condiciones
		Predicate idTipoidadIgual = builder.equal(joinPerCon.get(TipoContactoDTO_.id), contacto.getId());
		
		//5. Ejecutamos
		TypedQuery<PersonaDTO> typed = entityManager.createQuery(
								query.
								select(fromPersona).
								where(idTipoidadIgual));
		
		return typed.getResultList();
	}

	@Override
	public List<PersonaDTO> getAllWith(LocalidadDTO localidad) {
		
		//1. Creamos la query
		CriteriaQuery<PersonaDTO> query = builder.createQuery(PersonaDTO.class);
		
		//2. Creamos el root
		Root<PersonaDTO> fromPersona = query.from(PersonaDTO.class);
		
		//3. Creamos el join
		Join<PersonaDTO, DomicilioDTO> joinPerDom = fromPersona.join(PersonaDTO_.domicilio);
		Join<DomicilioDTO, LocalidadDTO> joinPerDomLoc = joinPerDom.join(DomicilioDTO_.localidad);
		
		//4. Creamos las condiciones
		Predicate idLocalidadIgual = builder.equal(joinPerDomLoc.get(LocalidadDTO_.id), localidad.getId());
		
		//5. Ejecutamos
		TypedQuery<PersonaDTO> typed = entityManager.createQuery(
								query.
								select(fromPersona).
								where(idLocalidadIgual));
		
		return typed.getResultList();
		

	}

	@Override
	public List<PersonaDTO> readAll() {
		
		List<PersonaDTO> toReturn = new ArrayList<>();
		
		initTransaction();

		CriteriaQuery<PersonaDTO> query = builder.createQuery(PersonaDTO.class);
		Root<PersonaDTO> fromPersona = query.from(PersonaDTO.class);
		
		query.from(LocalidadDTO.class);
		
		List<PersonaDTO> resultados = entityManager.createQuery(query.select(fromPersona)).getResultList();
		
		toReturn.addAll(resultados);
		
		finishTransaction();
		
		return toReturn;
	}

}
